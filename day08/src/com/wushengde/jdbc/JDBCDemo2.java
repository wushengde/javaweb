package com.wushengde.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com.wushengde.util.JDBCUtils;

public class JDBCDemo2 {
	/*
	 *功能一：实现数据库删除 
	 */
	@Test
	public void delete(){
		Connection conn=null;
		Statement stat = null;
		try{
			conn = JDBCUtils.getConn();
			stat = conn.createStatement();
			int count = stat.executeUpdate("delete from user where name='gouwa'");
			if(count>0){
				System.out.println("删除成功！");
			}else{
				System.out.println("删除失败！");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.close(null, stat, conn);
		}
	}
	
	/*
	 * 功能二：实现数据库查询
	 * 
	 */
	@Test
	public void find() {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
			stat = conn.createStatement();
			rs = stat.executeQuery("select *from user where name='zs'");
			while(rs.next()){
				String name =rs.getString("name");
				String password =rs.getString("password");
				String birthday = rs.getString("birthday");
				System.out.println("姓名："+name);
				System.out.println("密码："+password);
				System.out.println("生日："+birthday);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(rs, stat, conn);
		}
	}

	/*
	 * 功能三：实现更新数据的中的数据
	 */
	@Test
	public void update() {
		Connection conn = null;
		Statement statement = null;
		try {
			// 1.注册数据库驱动
			// Class.forName("com.mysql.jdbc.Driver");
			// 2.获取数据库连接
			// conn =
			// DriverManager.getConnection("jdbc:mysql:///day08?user=root&password=123456");

			// 直接调用工具类：JDBCUtils
			conn = JDBCUtils.getConn();
			// 3.创建传输器对象
			statement = conn.createStatement();
			// 4.执行sql语句
			int count = statement
					.executeUpdate("update user set birthday='2000-1-1' where name='zs'");
			// 5.处理执行结果
			if (count > 0) {
				System.out.println("执行成功！影响到的行数为:" + count + "行");
			} else {
				System.out.println("执行失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6.关闭资源
			/*
			 * if(rs!=null){ try { rs.close(); } catch (SQLException e) {
			 * e.printStackTrace(); }finally{ rs=null; } } if(statement!=null){
			 * try { statement.close(); } catch (SQLException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }finally{
			 * statement=null; } } if(conn!=null){ try { conn.close(); } catch
			 * (SQLException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }finally{ conn=null; } }
			 */

			// 直接调用工具类关闭资源:当没有定义ResultSet时，直接传入一个null
			JDBCUtils.close(null, statement, conn);
		}

	}

	/*
	 * 功能四：实现向数据库新增一行数据：即实现注册的方法
	 */
	@Test
	public void add() {
		Connection conn = null;
		Statement statement = null;
		try {
			// 1.注册数据库驱动
			// Class.forName("com.mysql.jdbc.Driver");
			// 2.获取数据库连接
			// conn =
			// DriverManager.getConnection("jdbc:mysql:///day08?user=root&password=123456");

			// 直接调用工具类：JDBCUtils
			conn = JDBCUtils.getConn();

			// 3.创建传输器对象
			statement = conn.createStatement();
			// 4.利用传输器传输sql语句(即：执行sql语句)
			int count = statement.executeUpdate("insert into user values(null,'gouwa','123321','gouwa@sina.com','1999-9-9')");
			// 5.因为没有返回结果集，直接处理结果
			if (count > 0) {
				System.out.println("执行成功！影响到的行数为:" + count + "行");
			} else {
				System.out.println("执行失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6.关闭资源
			/*
			 * if(rs!=null){ try { rs.close(); } catch (SQLException e) {
			 * e.printStackTrace(); }finally{ rs=null; } } if(statement!=null){
			 * try { statement.close(); } catch (SQLException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }finally{
			 * statement=null; } } if(conn!=null){ try { conn.close(); } catch
			 * (SQLException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }finally{ conn=null; } }
			 */

			// 直接调用工具类关闭资源:当没有定义ResultSet时，直接传入一个null
			JDBCUtils.close(null, statement, conn);
		}

	}

}
