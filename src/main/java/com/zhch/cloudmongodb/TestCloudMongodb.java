//package com.zhch.cloudmongodb;
//
//import java.sql.SQLException;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//
//import com.lifeix.analyzer.server.common.Constants;
//import com.lifeix.common.clouddao.Cloud;
//import com.lifeix.common.clouddao.config.CloudNode;
//import com.lifeix.common.clouddao.config.CloudStorageConfig;
//import com.lifeix.common.clouddao.mongodb.MongoDBUtil;
//import com.mongodb.BasicDBList;
//import com.mongodb.BasicDBObject;
//import com.mongodb.DBCollection;
//import com.mongodb.DBCursor;
//import com.mongodb.DBObject;
//
//public class TestCloudMongodb {
//	public void test() throws SQLException {
//		CloudNode node = null;
//		node = CloudStorageConfig.getInstance().getAllNodes().get(0);
//		DBCollection colDone = MongoDBUtil.getConnection(node,
//				Constants.analyze_job_done);
//		BasicDBList list = new BasicDBList();
//		list.add(new BasicDBObject(Constants.JobStatus.type(), Constants.JobStatus.Failed));
//		list.add(new BasicDBObject(Constants.JobStatus.type(), Constants.JobStatus.Done));
//		
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(new Date());
//		cal.add(Calendar.MONTH, -3);
//		Date oldDate = cal.getTime();
//		
//		BasicDBObject lt = new BasicDBObject();
//		lt.put("$lt", oldDate);
//		
//		BasicDBObject obj = new BasicDBObject();
//		obj.put("$or", list);
//		obj.put(Constants.processTime, lt);
//		
//		System.out.println("==============================");
//		DBCursor cursor = colDone.find(obj);
//		List<DBObject> result = cursor.toArray();
//		System.out.println("size:"+result.size());
//		for(DBObject row : result){
//			System.out.println(row);
//		}
//		System.out.println("end   ==============================");
////		colDone.remove(obj);
//	}
//	public void test2() throws SQLException {
//		CloudNode node = null;
//		node = CloudStorageConfig.getInstance().getAllNodes().get(0);
//		DBCollection colDone = MongoDBUtil.getConnection(node,
//				Constants.analyze_job_done);
//		
//
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(new Date());
//		cal.add(Calendar.MONTH, -3);
//		Date oldDate = cal.getTime();
//
//		BasicDBObject lt = new BasicDBObject();
//		lt.put("$lt", oldDate);
//
//		BasicDBObject obj = new BasicDBObject();
////		obj.put("$or", list);
//		obj.put(Constants.processTime, lt);
//
////		colDone.remove(obj);
//		
//		System.out.println("==============================");
//		DBCursor cursor = colDone.find(obj);
//		List<DBObject> result = cursor.toArray();
//		System.out.println("size:"+result.size());
//		for(DBObject row : result){
//			System.out.println(row);
//		}
//		System.out.println("end   ==============================");
//		colDone.remove(obj);
//	}
//	
//	public void test3() throws SQLException{
//		CloudNode node = null;
//		node = CloudStorageConfig.getInstance().getAllNodes().get(0);
//		DBCollection colDone = MongoDBUtil.getConnection(node,
//				Constants.analyze_job_done);
//		BasicDBObject obj = new BasicDBObject();
//		obj.put("data_analyze_message_type", 1);
//		obj.put("__sequence__", 2);
//		
//		
//		BasicDBObject result = (BasicDBObject)colDone.findOne(obj);
//		System.out.println(result);
//		System.out.println(result.get("__sequence__w")==null);
//		
//		
////		DBCursor cursor = colDone.findOne(obj);
////		List<DBObject> result = cursor.toArray();
////		System.out.println("size:"+result.size());
////		for(DBObject row : result){
////			System.out.println(row);
////		}
//		System.out.println("end   ==============================");
//	}
//
//	public static void main(String[] args) throws SQLException {
//		Cloud.init("/home/lifeix/workspace/testsomething/src/main/java/sharing-config.xml");
//		TestCloudMongodb t = new TestCloudMongodb();
//		t.test3();
//	}
//}
