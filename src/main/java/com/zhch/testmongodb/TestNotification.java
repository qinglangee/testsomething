//package com.zhch.testmongodb;
//
//import java.sql.SQLException;
//
//import com.lifeix.common.clouddao.Cloud;
//import com.lifeix.common.clouddao.config.CloudNode;
//import com.lifeix.common.clouddao.mongodb.MongoDBUtil;
//import com.lifeix.notification.jobs.NotificationServer;
//import com.lifeix.notification.jobs.core.Constants;
//import com.lifeix.notification.jobs.util.FileUtil;
//import com.mongodb.BasicDBObject;
//import com.mongodb.DBCollection;
//import com.mongodb.DBCursor;
//
//public class TestNotification {
//	CloudNode node;
//	public TestNotification() {
//		Cloud.init(getShardConfigPath());
//
//		node = new CloudNode();
//		node.setId("192.168.1.200");
//		node.setNodeUrl("192.168.1.200");
//		node.setPort(27017);
//		node.setDatabase("dovebox");
//		node.setNodeUserName("");
//		node.setNodePassword("");
//
////		try {
////			DBCollection col1 = MongoDBUtil.getConnection(CloudStorageConfig.getInstance().getAllNodes().get(0),
////					Constants.message_queue_job);
////			col1.ensureIndex(new BasicDBObject(Constants.jobSequenceNumber, 1));
////			DBCollection col2 = MongoDBUtil.getConnection(CloudStorageConfig.getInstance().getAllNodes().get(0),
////					Constants.message_queue_job_done);
////			col2.ensureIndex(new BasicDBObject(Constants.jobSequenceNumber, 1));
////		} catch (Exception e) {
////			FileUtil.error("Init Notification Server database failed.");
////			FileUtil.log(e);
////		}
//	}
//
//	public void test() throws SQLException {
//		DBCollection col = MongoDBUtil.getConnection(this.node, Constants.message_queue_job);
//		DBCollection colDone = MongoDBUtil.getConnection(this.node, Constants.message_queue_job_done);
//
//		BasicDBObject query = new BasicDBObject();
//		BasicDBObject fields = new BasicDBObject();
//		fields.put(Constants.jobSequenceNumber, 1);
//
//		BasicDBObject sort = new BasicDBObject();
//		sort.put(Constants.jobSequenceNumber, 1);
//		DBCursor cursor = col.find(query, fields).sort(sort).limit(1);
//		long realMinRange = -1;
//
//		if (cursor.hasNext())
//			realMinRange = ((BasicDBObject) cursor.next()).getLong(Constants.jobSequenceNumber);
//		System.out.println("realMinRange  " + realMinRange);
//
//		sort.put(Constants.jobSequenceNumber, -1);
//		cursor = col.find(query, fields).sort(sort).limit(1);
//		long realMaxRange = -1;
//		if (cursor.hasNext())
//			realMaxRange = ((BasicDBObject) cursor.next()).getLong(Constants.jobSequenceNumber);
//		System.out.println("realMaxRange  " + realMaxRange);
//
//		long calcMaxRange = realMaxRange + 1;
//		int threadCount = 50;
//		int batchSize = 100;
//
//		calcMaxRange = (int) (Math.ceil((double) calcMaxRange / threadCount) * threadCount);
//		System.out.println("calcMaxRange  " + calcMaxRange);
//		int threadProcessSize = (int) (calcMaxRange / threadCount);
//		System.out.println("threadProcessSize  " + threadProcessSize);
//
//	}
//
//	public static void main(String[] args) throws SQLException {
//		TestNotification t = new TestNotification();
//		t.test();
//	}
//
//	private static String getShardConfigPath() {
//		String configFilePath = FileUtil.concatPath(getConfigPath(), "sharing-config.xml", false);
//		FileUtil.info("Use MongoDB shard config file path : %s", configFilePath);
//		return configFilePath;
//	}
//
//	private static String getConfigPath() {
//		String configPath = null;
//		// Get /WEB-INF/conf/shard-config.xml file path.
//		try {
//			configPath = NotificationServer.class.getResource("/").getPath().replaceAll("%20", " ");
//		} catch (Exception e) {
//			FileUtil.info("Get /WEB-INF/class path failed, try to use [user.dir] path.");
//			FileUtil.log(e);
//			configPath = System.getProperty("user.dir");
//		}
//		configPath = FileUtil.concatPath(configPath, "conf", false);
//		return configPath;
//	}
//}
