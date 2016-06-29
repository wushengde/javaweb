package com.wushengde.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ʹ��JDBC�������ݿ�Ĳ��裺
 * 
 * @author john
 * 
 */
public class JDBCDemo1 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement statement = null;
		ResultSet result = null;
		// 1.ע�����ݿ��������
		// DriverManager.registerDriver(new Driver());//������ʹ������ע�᷽ʽ���������±׶ˣ�
		// �׶�1������mysql��Driver���ʵ�����Լ�ע����һ�Σ���������ע����һ�Σ�����������mysql������ע������
		// �׶�2������mysql��Driver����ʱ�����³���;����mysql����������һ����������˲�ͬ�����ݿ��磺oracle������Ҫ�Ķ�java����
		// �������ֱ׶˵Ľ�����������������˷�����ʵ��ע��
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// �Ժ���Ҫ�������ݿ�ʱֱ�ӿ��Ե������ļ����޸ģ���ʱ�����������еĴ���(�˴�ֵΪ�ַ�������)������ֱ�ӷ�װ�������ļ��У������޸�
			// 2.��ȡ���ݿ�����
			// �������ַ�ʽ������ʵ�ֻ�ȡ���ݿ�����ӣ�ע��������ݿ�ʱ���ӵı������Ҷ˿ں�Ҳ��Ĭ�ϵ�3306����������������ʡ��
			// Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/day08","root","123456");
			conn = DriverManager.getConnection("jdbc:mysql:///day08?user=root&password=123456");
			// 3.������������������Connection�����createStatement()������ȡ
			statement = conn.createStatement();
			// 4.���ô���������sql��䵽���ݿ���ִ�У���ȡ���������
			result = statement.executeQuery("select * from user");
			// 5.�����������ȡ��ѯ���
			/*
			 * while(result.next()){ String name = result.getString("name");
			 * System.out.println(name); }
			 */
			result.next();
			result.next();
			result.previous();
			result.absolute(3);
			String name = result.getString("name");
			System.out.println(name);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6.�ر���Դ:�ر�ԭ�����ȴ����Ķ������ر�
			if (result != null) {
				try {
					result.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					//��ֹresult��close()�������쳣���������´��뽫ǿ�ƽ�������Ϊ�գ����ձ��������յ�
					result=null;
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					//��ֹstatement��close()�������쳣���������´��뽫ǿ�ƽ�������Ϊ�գ����ձ��������յ�
					statement=null;
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					//��ֹconn��close()�������쳣���������´��뽫ǿ�ƽ�������Ϊ�գ����ձ��������յ�
					conn=null;
				}
			}
		}
	}
}