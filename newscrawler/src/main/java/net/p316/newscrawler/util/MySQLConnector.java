package net.p316.newscrawler.util;

import java.sql.*;

public class MySQLConnector {
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://news.p316.net/news_crawler";
   
   static final String USER = "crawler";
   static final String PASS = "4X\"Zd@JaTs\\Yk<c]";
   
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
   
   public void simpleInsertTitle(){
	   
   }
   
   public void testConn(){
	   Statement stmt = null;
	   ResultSet rs = null;
	   try{
		   stmt = conn.createStatement();
		   stmt.execute("INSERT INTO `nc_title` (`idx`, `idx_category`, `url`, `title`, `company`, `date`) VALUES (NULL, '1', 'http://p316.net', '박현준ㅁㅇㄴㄹㅇㅁㄴasdfsadfas 한글이 왜 안될까', '동국대학교', CURRENT_DATE())");
	   } catch(Exception ex){
		   
	   } finally {
		   
	   }
   }
}
