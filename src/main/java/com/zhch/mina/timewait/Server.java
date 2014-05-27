package com.zhch.mina.timewait;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.keepalive.KeepAliveFilter;
import org.apache.mina.filter.keepalive.KeepAliveMessageFactory;
import org.apache.mina.filter.keepalive.KeepAliveRequestTimeoutHandler;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.filter.logging.MdcInjectionFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Server {
	public static int idleTimeBeforeDisconnect = 60;// 1 minutes is enough.
	private static final Logger LOG = LoggerFactory.getLogger(Server.class);
	private static final int PORT = 9123;
	NioSocketAcceptor acceptor;

	public void test() throws IOException {
		boolean result = false;

		int _port = 0;
		try {

			// Start up thread pool.
			Integer poolSize = 10;
			ThreadPoolExecutor threadPoolDispatcher = new ThreadPoolExecutor(poolSize, poolSize * 2, 30,
					TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

			_port = PORT;// PORT;
			// For TCP
			acceptor = new NioSocketAcceptor();

			// For UDP
			/* acceptor = new NioDatagramAcceptor(); */
			DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
			MdcInjectionFilter mdcInjectionFilter = new MdcInjectionFilter();
			chain.addLast("mdc", mdcInjectionFilter);

			// Add SSL filter if SSL is enabled.
			TextLineCodecFactory tlcf = new TextLineCodecFactory(Charset.forName("UTF-8"), LineDelimiter.UNIX,
					LineDelimiter.UNIX);
			tlcf.setDecoderMaxLineLength(Integer.MAX_VALUE);
			tlcf.setEncoderMaxLineLength(Integer.MAX_VALUE);

			chain.addLast("codec", new ProtocolCodecFilter(tlcf));
			chain.addLast("keep-alive", new HachiKeepAliveFilterInMina());
			chain.addLast("logger", new LoggingFilter());
			// Bind
			acceptor.setHandler(new MQServerProtocolHandler());

			acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, idleTimeBeforeDisconnect);
			// For UDP
			/*
			 * DatagramSessionConfig dcfg = acceptor.getSessionConfig();
			 * dcfg.setReuseAddress(true);
			 */

			acceptor.bind(new InetSocketAddress(_port));
			FileUtil.info("Listening on port %d.", _port);
			result = true;

			FileUtil.info("------------------------------------------------------------------");
			FileUtil.info("               Start Message Queue Server Succeed!");
			FileUtil.info("------------------------------------------------------------------");
		} catch (Exception e) {
			LOG.error("", e);
		}
	}

	public static void main(String[] args) throws IOException {
		Server t = new Server();
		t.test();
	}
}

class MQServerProtocolHandler extends IoHandlerAdapter {

	public MQServerProtocolHandler() throws Exception {
	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) {
		FileUtil.log(cause);
		session.close(true);
	}

	@Override
	public void messageReceived(IoSession session, Object message) {
		String incomingMessage = "";
		Integer retCode = 0;
		String errorMessage = "";
		String retResult = null;
		String sessionId = "";
		try {
			incomingMessage = (String) message;
			incomingMessage = incomingMessage.trim();

			if (incomingMessage.length() <= 0) {
				// session.close(true);
				return;
			}

			int pos = incomingMessage.indexOf("@");
			if (pos != -1) {
				sessionId = incomingMessage.substring(0, pos);
				if (pos >= incomingMessage.length())
					incomingMessage = "";
				else
					incomingMessage = incomingMessage.substring(pos + 1);
			}

			// no matter it is first time or not, need to parse version if
			// possible
			// incomingMessage = Base64Coder.decodeString(incomingMessage);
			// MQServer.threadPoolDispatcher.execute(new
			// DispatcherThread(session, sessionId, incomingMessage));
		} catch (Exception e) {
			FileUtil.log(e);
			retCode = -1;
			errorMessage = e.getMessage();

			StringBuilder str = new StringBuilder();
			str.append("{").append(JSONObject.quote("__sessionId__")).append(":").append(JSONObject.quote(sessionId))
					.append(",").append(JSONObject.quote("retCode")).append(":").append(retCode).append(",")
					.append(JSONObject.quote("retData")).append(":").append(JSONObject.quote(retResult)).append(",")
					.append(JSONObject.quote("errorMessage")).append(":").append(JSONObject.quote(errorMessage))
					.append("}");
			session.write(str.toString());
		}
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		try {
			FileUtil.debug("Session %d closed.", session.getId());
		} catch (Exception e) {
			FileUtil.log(e);
		}
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status) {
		System.out.println("Session %d idled." + session.getId());
	}

	public void sessionCreated(IoSession session) {
		FileUtil.debug("New session created %d", session.getId());
	}
}

class HachiKeepAliveFilterInMina extends KeepAliveFilter {
	private static final int INTERVAL = 10;// 30 seconds
	private static final int TIMEOUT = 10; // 5 seconds

	public HachiKeepAliveFilterInMina(KeepAliveMessageFactory messageFactory) {
		super(messageFactory, IdleStatus.BOTH_IDLE, new ExceptionHandler(), INTERVAL, TIMEOUT);
	}

	public HachiKeepAliveFilterInMina() {
		super(new KeepAliveMessageFactoryImpl(), IdleStatus.BOTH_IDLE, new ExceptionHandler(), INTERVAL, TIMEOUT);
		this.setForwardEvent(false);
	}
}

class KeepAliveMessageFactoryImpl implements KeepAliveMessageFactory {
	private static final byte int_req = -1;
	private static final byte int_rep = -2;
	private static final IoBuffer KAMSG_REQ = IoBuffer.wrap(new byte[] { int_req });
	private static final IoBuffer KAMSG_REP = IoBuffer.wrap(new byte[] { int_rep });
	private static final String HELLO = "Hello!";
	private static final String YES = "Yes!";

	public Object getRequest(IoSession session) {
		// return KAMSG_REQ.duplicate();
		return HELLO;
	}

	public Object getResponse(IoSession session, Object request) {
		// return KAMSG_REP.duplicate();
		return YES;
	}

	public boolean isRequest(IoSession session, Object message) {
		return HELLO.equals(message);
	}

	public boolean isResponse(IoSession session, Object message) {
		return YES.equals(message);
	}
}

class ExceptionHandler implements KeepAliveRequestTimeoutHandler {
	public void keepAliveRequestTimedOut(KeepAliveFilter filter, IoSession session) throws Exception {
		System.out.println("Connection lost, session [%d] will be closed" + session.getId());
		session.close(true);
	}
}

class FileUtil {
	static final Logger Log = LoggerFactory.getLogger(FileUtil.class);

	public static void info(String text, Object... args) {
		if (Log.isInfoEnabled())
			Log.info(String.format(text, args));
	}

	public static void debug(String text, Object... args) {
		if (Log.isDebugEnabled())
			Log.debug(String.format(text, args));
	}

	public static void error(String text, Object... args) {
		Log.error(String.format(text, args));
	}

	public static void log(Exception e) {
		Log.error(e.getMessage(), e);
	}

	public static void log(Throwable t) {
		Log.error(t.getMessage(), t);
	}

	public static String concatPath(String dirName, String fileName, Boolean bWindowsType) {
		String tempDirName = dirName.replace("\\", "/");
		int lastIndex = tempDirName.length() - 1;
		int index = tempDirName.lastIndexOf("/");
		if (index != lastIndex)
			tempDirName += "/";

		String tempFileName = fileName.replace("\\", "/");
		// if(tempFileName.charAt(0) == '/')
		if (tempFileName.startsWith("/"))
			tempFileName = tempFileName.length() > 1 ? tempFileName.substring(1) : "";

		tempDirName += tempFileName;
		if (bWindowsType != null && bWindowsType == true)
			tempDirName = tempDirName.replace("/", "\\");
		else
			tempDirName = tempDirName.replace("\\", "/");
		return tempDirName;
	}

}