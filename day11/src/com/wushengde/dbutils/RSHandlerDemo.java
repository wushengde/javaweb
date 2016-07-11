package com.wushengde.dbutils;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.wushengde.domain.Account;

/**
 * ʹ��DBUtils���ʵ�ֲ�ѯʱ���Խ�����Ĳ�ͬ������ʽ�ľ�����
 * ���������Ѿ�Ϊ����д���˲�ͬ������ʽʱ�õ��Ĳ�ͬ���࣬����ֻ��Ҫʹ�þͿ��ԡ�
 * ע�����д���ʵ�ֲ�ѯ
 * @author john
 *
 */
public class RSHandlerDemo {
	
	//������ʽһ��
	// ArrayHandler �ѽ�����еĵ�һ������ת�ɶ�������
	//���ص���һ��Object���͵�����
	@Test
	public void find1() throws SQLException{
		QueryRunner runner=new QueryRunner(new ComboPooledDataSource());
		Object objs[]=runner.query("select * from account where money>?",new ArrayHandler(),300);
		System.out.println(objs);
	}
	
	//������ʽ����
	//ArrayListHandler���ѽ�����е�ÿһ�����ݶ�ת��һ���������飬�ٴ�ŵ�List��
	//����һ��list
	@Test
	public void find2() throws SQLException{
		QueryRunner runner=new QueryRunner(new ComboPooledDataSource());
		List<Object[]> list=runner.query("select * from account where money>?",new ArrayListHandler(),300);
		System.out.println(list);
	}
	
	//������ʽ��������
	//BeanHandler����������еĵ�һ�����ݷ�װ��һ����Ӧ��JavaBeanʵ���С�
	@Test
	public void find3() throws SQLException{
		QueryRunner runner=new QueryRunner(new ComboPooledDataSource());
		Account account=runner.query("select * from account where money>?",new BeanHandler<Account>(Account.class) ,300);
		System.out.println(account);
	}
	
	//������ʽ�ģ�����
	//BeanListHandler����������е�ÿһ�����ݶ���װ��һ����Ӧ��JavaBeanʵ���У���ŵ�List�
	@Test
	public void find4() throws SQLException{
		QueryRunner runner=new QueryRunner(new ComboPooledDataSource());
		List<Account> list=runner.query("select * from account where money>?",new BeanListHandler<Account>(Account.class),300);
		System.out.println(list);
	}

	
	
}