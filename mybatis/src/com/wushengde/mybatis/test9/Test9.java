package com.wushengde.mybatis.test9;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.wushengde.mybatis.beans.CUser;
import com.wushengde.mybatis.util.MybatisUtil;

/**
 * 测试缓存
 * @author john
 *
 */
public class Test9 {
	/**测试缓存：
	 * 一级缓存：
	 * 作用域：session对象，默认是自动开启的！
	 * 1.当session调用了clearcache()方法后清除缓存
	 * 2.当在两次查询过程之间执行了增删改的操作时，select中的缓存将被清空
	 * 3.不是同一个session对象时，缓存被清理了
	 * 
	 * 二级缓存：
	 * 作用域：是整个映射文件，默认是自动关闭的！需要在映射文件中打开<cache>标签即可
	 */
	@Test
	public void testCacheOne(){
		SqlSessionFactory factory=MybatisUtil.getFactory();
		SqlSession session=factory.openSession();
		
		String statement="com.wushengde.mybatis.test9.userMapper.getUser";
		CUser user=session.selectOne(statement, 1);
		System.out.println(user);
		
		user=session.selectOne(statement, 1);
		System.out.println(user);
		
		System.out.println("-----------------------------------------");
		
/*		//清空缓存的操作，需要再次执行查询数据库的操作
		session.clearCache();	*/
		session.update("com.wushengde.mybatis.test9.userMapper.updateUser", new CUser(1,"tom",25));
	
		user=session.selectOne(statement, 1);
		System.out.println(user);
		
		session.close();
	}
	@Test
	public void testCacheTwo(){
		SqlSessionFactory factory=MybatisUtil.getFactory();
		SqlSession session1=factory.openSession();
		SqlSession session2=factory.openSession();
		
		String statement="com.wushengde.mybatis.test9.userMapper.getUser";
		CUser user=session1.selectOne(statement, 1);
		session1.commit();
		System.out.println(user);
		
		user=session2.selectOne(statement, 1);
		session2.commit();
		System.out.println(user);
		
		
	}
}
