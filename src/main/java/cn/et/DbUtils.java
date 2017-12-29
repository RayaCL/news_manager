package cn.et;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;



public class DbUtils {
	static Properties p=new Properties();
	static{
		InputStream is=DbUtils.class.getResourceAsStream("/jdbcmysql.properties");
		try {
			p.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		String url=p.getProperty("url");
		String driverClass=p.getProperty("driverClass");
		String uName=p.getProperty("userName");
		String password=p.getProperty("password");
		Class.forName(driverClass);
		Connection conn=DriverManager.getConnection(url, uName, password);
		return conn;
	}
	public static List<Map> query(String sql){
		List<Map> list=new ArrayList<Map>();
		try {
			Connection conn=getConnection();
			PreparedStatement sta=conn.prepareStatement(sql);
			ResultSet rs=sta.executeQuery();
			ResultSetMetaData rsm=rs.getMetaData();
			//取出列的个数
			int columnCount=rsm.getColumnCount();
			
			while(rs.next()){
				Map map=new HashMap();
				for(int i=1;i<=columnCount;i++){
					String colName=rsm.getColumnName(i);
					String colValue=rs.getString(i);
					map.put(colName, colValue);
				}
				list.add(map);
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 数据库增删改方法
	 */
	public static int execute(String sql){
		Connection conn;
		int i = 0;
		try {
			conn = getConnection();
			PreparedStatement sta=conn.prepareStatement(sql);
			i=sta.executeUpdate();
			sta.close();
			conn.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
}
