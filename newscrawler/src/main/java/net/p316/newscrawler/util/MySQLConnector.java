package net.p316.newscrawler.util;

import java.sql.*;

public class MySQLConnector {
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
   static final String DB_URL = "jdbc:mysql://news.p316.net/news_crawler";
   //string형 변수 DB_URL에 DB연동을 할 주소(URL)저장
   
   static final String USER = "crawler";
   //String형 변수 USER에 아이디 crawler저장
   static final String PASS = "4X\"Zd@JaTs\\Yk<c]";
   //String형 변수 PASS에 비밀번호 저장
   
   private DriverManager driverManager;
   private Connection conn = null;
   
   public MySQLConnector(){
	   try{
		   conn = driverManager.getConnection(DB_URL
				   + "?characterEncoding=utf8"
				   + "&user=" + USER + "&password=" + PASS);
	   } catch(Exception ex){
		   System.out.println("SQLException: " + ex.getMessage());
	   }
   }
   
   public void simpleInsertTitle(String _href, String _title, String _comp, String _day){
	   Statement stmt = null;
	   ResultSet rs = null;
	   try{
		   stmt = conn.createStatement();
		   stmt.execute("INSERT INTO `nc_title`"
		   		+ "(`idx`, `idx_category`, `url`, `title`, `company`, `date`)"
		   		+ "VALUES (NULL,"
		   		+ "'1',"
		   		+ "'" + _href + "',"
		   		+ "'" + _title + "',"
		   		+ "'" + _comp + "',"
		   		+ "'" + _day + "')");
	   } catch(Exception ex){
		   
	   } finally {
		   
	   }
   }
   
   public void testConn(){
	   Statement stmt = null;
	   ResultSet rs = null;
	   try{
		   stmt = conn.createStatement();
	   } catch(Exception ex){
		   
	   } finally {
		   
	   }
   }
}
