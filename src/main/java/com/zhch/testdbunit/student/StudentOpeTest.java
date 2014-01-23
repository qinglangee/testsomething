package com.zhch.testdbunit.student;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;

public class StudentOpeTest {
	protected void setUp() {
		IDatabaseConnection connection = null;
		try {
			// 本例使用postgresql数据库
			Class.forName("org.postgresql.Driver");
			// 连接DB
			Connection conn = DriverManager.getConnection("jdbc:postgresql:testdb.test", "postgres", "postgres");
			// 获得DB连接
			connection = new DatabaseConnection(conn);

			// 对数据库中的操作对象表student进行备份
			QueryDataSet backupDataSet = new QueryDataSet(connection);
			backupDataSet.addTable("student");
			File file = File.createTempFile("student_back", ".xml");// 备份文件
			FlatXmlDataSet.write(backupDataSet, new FileOutputStream(file));

			// 准备数据的读入
			IDataSet dataSet = new FlatXmlDataSet(new FileInputStream("student_pre.xml"));
			DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
			}
		}
	}

	// findStudent
	// public void testFindStudent() throws Exception {
	// // 执行findStudent方法
	// StudentOpe studentOpe = new StudentOpe();
	// Student result = studentOpe.findStudent("0001");
	//
	// // 预想结果和实际结果的比较
	// Assertion.assertEquals("翁仔", result.getName());
	// Assertion.assertEquals("m", result.getSex());
	// assertEquals("1979-12-31", result.getBirthDay());
	// }

	// public void testAddStudent() throws Exception {
	// // 执行addStudent方法
	// StudentOpe studentOpe = new StudentOpe();
	// // 被追加的记录
	// Student newStudent = new Student("0088", "王耳朵", "m", "1982-01-01");
	// // 执行追加方法
	// Student result = studentOpe.addStudent(newStudent);
	//
	// // 预想结果和实际结果的比较
	// IDatabaseConnection connection = null;
	//
	// try {
	//
	// // 预期结果取得
	// IDataSet expectedDataSet = new FlatXmlDataSet(new
	// FileInputStream("student_exp.xml"));
	// ITable expectedTable = expectedDataSet.getTable("student");
	//
	// // 实际结果取得
	// Connection conn = getConnection();
	// connection = new DatabaseConnection(conn);
	//
	// IDataSet databaseDataSet = connection.createDataSet();
	// ITable actualTable = databaseDataSet.getTable("student");
	//
	// // 比较
	// Assertion.assertEquals(expectedTable, actualTable);
	//
	// } finally {
	// if (connection != null)
	// connection.close();
	// }
	// }
	

	//*如果在整体比较表的时候，有个别字段不需要比较，可以用DefaultColumnFilter.excludedColumnsTable()方法，
	//将指定字段给排除在比较范围之外。比如上例中不需要比较birthday这个字段的话，那么可以如下代码所示进行处理：
//	ITable filteredExpectedTable = DefaultColumnFilter.excludedColumnsTable(expectedTable, new String[]{"birthday"});
//	ITable filteredActualTable = DefaultColumnFilter.excludedColumnsTable(actualTable,new String[]{"birthday"});
//	Assertion.assertEquals(filteredExpectedTable, filteredActualTable);
	
	

//	protected void tearDown() throws Exception {
//
//		IDatabaseConnection connection = null;
//		try {
//			Connection conn = getConnection();
//			connection = new DatabaseConnection(conn);
//
//			IDataSet dataSet = new FlatXmlDataSet(file);
//			DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (connection != null)
//					connection.close();
//			} catch (SQLException e) {
//			}
//		}
//
//	}
}
