package com.wushengde.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*
 * ����һ�������࣬ע�������಻��ֱ��new�����˽�л��乹�췽��
 * ��Ϊһ�㶼��ͨ�������������еķ������������еķ������Ǿ�̬����
 * �˹������ṩ���ݿ��е�����������
 * 1.��ȡ���ӵķ���
 * 2.�ر����ӵķ���
 */
public class JDBCUtils {
	private JDBCUtils() {
	}
	private static Properties prop=null;
	/**
	 * ��ȡ���ӵķ�����
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	static{
		try{
		prop = new Properties();
		//ʹ�����������ȡ�����ļ�����ʹ��web�����е��ø÷���һ���ܹ�ִ��(ԭ�����������������ȡclass�ļ���class�ļ�����srcĿ¼�����������Ҫ�������ļ����ڸ�class�ļ���ͬ��Ŀ¼�²��ܱ����������ȡ��)
		prop.load(new FileReader(JDBCUtils.class.getClassLoader().getResource("config.properties").getPath()));
		}catch(Exception e){
			e.printStackTrace();
			//���쳣����������
			throw new RuntimeException(e);
		}
	}
	public static Connection getConn() throws SQLException, ClassNotFoundException{
		//1.ע�����ݿ�����:���÷���ʵ��:���в���д���ˣ���Ҫд�������ļ���
		//Class.forName("com.mysql.jdbc.Driver");
		//�˷������ܱ���ε��ã�������������д���д�ڴ˴�������˵���Properties�Ľ����ļ���ִ���鷳.
		//Properties prop = new Properties();
		//prop.load(new FileReader(""));
		
		//�˾��������Ը��ߣ������Ҫ����ֻ��Ҫ���������ļ�
		Class.forName(prop.getProperty("driver"));
		//2.��ȡ���ݿ�����,�����ظ����Ӷ������в���д���ˣ���Ҫд�������ļ���
		return DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("user"),prop.getProperty("password"));
	}
	
	/**
	 * �ر����ӵķ�����
	 */
	
	public static void close(ResultSet rs,Statement stat,Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				rs=null;
			}
		}
		if(stat!=null){
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				stat=null;
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				conn=null;
			}
		}
	}
}