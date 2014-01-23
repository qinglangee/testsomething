//package com.zhch.cloudmongodb;
//
//import java.sql.SQLException;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.lifeix.analyzer.server.common.Constants;
//import com.lifeix.common.clouddao.Cloud;
//import com.lifeix.common.clouddao.config.CloudStorageConfig;
//import com.lifeix.common.clouddao.mongodb.MongoDBUtil;
//import com.mongodb.BasicDBObject;
//import com.mongodb.DBCollection;
//import com.mongodb.DBCursor;
//import com.mongodb.DBObject;
//import com.mongodb.MongoException;
//
//public class PkRemind {
//	protected static final Logger LOG = LoggerFactory.getLogger(PkRemind.class);
//	static DBCollection  chaCol;
//	
//	public void test() {
//		Long startId = null;
//		BasicDBObject query = new BasicDBObject();
//		
//		// 组装参数，4个小时后结束的
//		Calendar cal = Calendar.getInstance();
//		cal.add(Calendar.HOUR, 4);
//		Date oldDate = cal.getTime();
//		BasicDBObject lt = new BasicDBObject();
//		lt.put("$lt", oldDate);
//		query.put("endTime", lt);
//
//		if (startId != null) {
//			BasicDBObject condition = new BasicDBObject();
//			condition.put("$gt", startId);
//			query.put("chaId", condition);
//		}
//		query.put("remind", new BasicDBObject("$ne", 1));
//
//		DBCursor cursor = chaCol.find(query).sort(new BasicDBObject("chaId", 1))
//				.limit(Constants.BATCH_SIZE);
//		List<DBObject> list = null;
//
//		try {
//			list = cursor.toArray();
//			for(DBObject rec : list)
//			System.out.println(rec);
//			LOG.debug("处理立方PK remind的个数: {}", list.size());
//		} catch (MongoException e) {
//			LOG.error("数据库连接出错！本次处理结束", e);
//		}
//		System.out.println("=============over");
//	}
//	
//	public void updateDate(){
//		BasicDBObject query = new BasicDBObject();
//		query.put("chaId", 4029);
//		BasicDBObject rec = (BasicDBObject)chaCol.findOne(query);
//		rec.put("endTime", new Date());
//		chaCol.update(new BasicDBObject("_id",rec.get("_id")), rec);
//	}
//
//	public static void main(String[] args) throws SQLException {
//		Cloud.init("/home/lifeix/workspace/testsomething/src/main/java/sharing-config.xml");
//		
//		 chaCol = MongoDBUtil.getConnection(CloudStorageConfig.getInstance().getAllNodes().get(0),
//					Constants.challenge_col);
//			
//		PkRemind t = new PkRemind();
//		t.updateDate();
//	}
//}
