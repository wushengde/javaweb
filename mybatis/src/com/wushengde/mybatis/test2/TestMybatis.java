package com.wushengde.mybatis.test2;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.wushengde.mybatis.beans.User;
import com.wushengde.mybatis.util.MybatisUtil;
/**
 * �������ڲ��Խ�sql������xml��ʵ����ɾ���(CRUD)
 * @author john
 *
 */
public class TestMybatis {

	/**
	 * ����һ����¼
	 */
	@Test
	public void testAdd(){
		SqlSessionFactory factory=MybatisUtil.getFactory();
		//Ĭ�����ֶ��ύ�ķ�ʽ
		SqlSession session= factory.openSession();
		String statement="com.wushengde.mybatis.test2.userMapper.addUser";
		int insert =session.insert(statement, new User(-1,"johntttt",25));
		//�ֶ��ύ����
		session.commit();
		session.close();
		System.out.println(insert);
	}
	/**
	 * ����һ����¼
	 */
	@Test
	public void testUpdate(){
		SqlSessionFactory factory=MybatisUtil.getFactory();
		SqlSession session=factory.openSession(true);
		String statement="com.wushengde.mybatis.test2.userMapper.updateUser";
		int update=session.update(statement, new User(4,"aaaa",25));
		session.close();
		System.out.println(update);
	}
	/**
	 * ɾ��һ����¼
	 */
	@Test
	public void testDelete(){
		SqlSessionFactory factory=MybatisUtil.getFactory();
		SqlSession session=factory.openSession(true);
		String statement="com.wushengde.mybatis.test2.userMapper.deleteUser";
		int delete=session.delete(statement,6);
		session.close();
		System.out.println(delete);
	}
	/**
	 *��ѯһ����¼
	 */
	@Test
	public void testSelect(){
		SqlSessionFactory factory=MybatisUtil.getFactory();
		SqlSession session=factory.openSession();
		String statement="com.wushengde.mybatis.test2.userMapper.getUser";
		User user=session.selectOne(statement, 4);
		session.close();
		System.out.println(user);
	}
	/**
	 * ��ѯ������¼
	 */
	@Test
	public void testSelectAllUser(){
		SqlSessionFactory factory=MybatisUtil.getFactory();
		SqlSession session=factory.openSession();
		String statement="com.wushengde.mybatis.test2.userMapper.selectAllUsers";
		List<User> list= session.selectList(statement);
		session.close();
		System.out.println(list);
	}
	
}