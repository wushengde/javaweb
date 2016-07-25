package com.wushengde.mybatis.test3;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.wushengde.mybatis.beans.User;
import com.wushengde.mybatis.util.MybatisUtil;
/**
 * �������ڲ��Խ�sql���д��ע��ʵ����ɾ���
 * @author john
 *
 */
public class TestMybatis2 {
	/**
	 * ���������ݿ�������һ������
	 */
	@Test
	public void testAdd(){
		SqlSessionFactory factory=MybatisUtil.getFactory();
		SqlSession session=factory.openSession(true);
		
		UserMapper userMapper=session.getMapper(UserMapper.class);
		int add =userMapper.addUser(new User(-1,"jackss",20));
		session.close();
		System.out.println(add);
	}
	/**
	 * ���Դ����ݿ���ɾ��һ������
	 */
	@Test
	public void testDelete(){
		SqlSessionFactory factory=MybatisUtil.getFactory();
		SqlSession session=factory.openSession(true);
		
		UserMapper userMapper=session.getMapper(UserMapper.class);
		int delete=userMapper.deleteUser(13);
		session.close();
		System.out.println(delete);
	}
	/**
	 * ���Ը������ݿ��е�һ������(����id�޸�����)
	 */
	@Test
	public void testUpdate(){
		SqlSessionFactory factory=MybatisUtil.getFactory();
		SqlSession session = factory.openSession(true);
		
		UserMapper userMapper=session.getMapper(UserMapper.class);
		int update = userMapper.updateUser(new User(1,"tomcat",100));
		session.close();
		System.out.println(update);
		System.out.println(UserMapper.class);
	}
	/**
	 * ���Բ�ѯ���ݿⵥ������
	 */
	@Test
	public void testGet(){
		SqlSessionFactory factory=MybatisUtil.getFactory();
		SqlSession session=factory.openSession();
		
		UserMapper userMapper=session.getMapper(UserMapper.class);
		User user=userMapper.getUser(1);
		session.close();
		System.out.println(user);
	}
	/**
	 * ���Բ�ѯ���ݵ��������ݣ�����һ��List
	 */
	@Test
	public void testGetAll(){
		SqlSessionFactory factory=MybatisUtil.getFactory();
		SqlSession session= factory.openSession();
		
		UserMapper userMapper=session.getMapper(UserMapper.class);
		List<User> list=userMapper.getAllUser();
		session.close();
		System.out.println(list);
	}
}