package com.wushengde.dbutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DbUtilsUpdate {
	/*
	 * �Զ���MyQueryRunner��ʵ����QueryRunner��ͬ�Ĺ���
	 */
	
	//ʹ��MyQueryRunnerʵ�ָ������ݿ���Ϣ
	@Test
	public void update3() throws SQLException{
		MyQueryRunner runner=new MyQueryRunner(new ComboPooledDataSource());
		runner.update("update account set money=? where name=?", 777,"a");
	}
	
	//ʹ��MyQueryRunnerʵ����������
	@Test
	public void add() throws SQLException{
		MyQueryRunner runner=new MyQueryRunner(new ComboPooledDataSource());
		runner.update("insert into account values(null,?,?)", "c",555);
	}
	
	//ʹ��MyQueryRunnerʵ��ɾ�����ݵĹ���
	@Test
	public void delete() throws SQLException{
		MyQueryRunner runner=new MyQueryRunner(new ComboPooledDataSource());
		runner.update("delete from account where name=?", "a");
	}
	
	/*
	 * DBUtils����е�QureyRunner��ʵ����ɾ�ĵĹ���
	 */
	
	//���·�ʽʹ��DBUtils���ʵ�ָĵĹ���ֻ��Ҫ���д���
	@Test
	public void update2() throws SQLException{
		QueryRunner runner=new QueryRunner(new ComboPooledDataSource());
		runner.update("update account set money=? where name=?",888,"a");
	}
	
	
	/*
	 * ���ϵ���ɾ��Ĵ����д
	 */
	//ʵ�ָĵķ���
	
	@Test
	public void update1(){
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	ComboPooledDataSource source=new ComboPooledDataSource();
		try{
			conn=source.getConnection();
			ps=conn.prepareStatement("update account set money=? where name=?");
			ps.setDouble(1, 999);
			ps.setString(2, "a");
			ps.executeUpdate();
		}catch(Exception e){
		e.printStackTrace();
		}finally{
			DbUtils.closeQuietly(conn, ps, rs);
		}
	}
}