package com.wushengde.mybatis.test1;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wushengde.mybatis.beans.User;

public class Test {
	public static void main(String[] args) throws IOException {
		String resource = "conf.xml"; 
		//加载mybatis的配置文件,此处使用类加载器加载文件（它也加载关联的映射文件）
		 InputStream inputStream= Test.class.getClassLoader().getResourceAsStream(resource);
		//构建sqlSession的工厂
		SqlSessionFactory factory= new SqlSessionFactoryBuilder().build(inputStream);
		//创建能执行映射文件中sql的sqlSession
		SqlSession session=factory.openSession();
		//映射sql的标识字符串
		//以下代码用了加号字符串拼接，目的是为了说明先找映射文件再找相应的sql语句标签
		String statement="com.wushengde.mybatis.test1.userMapper.getUser";
		//执行查询返回一个唯一user对象的sql
		User user=session.selectOne(statement, 11);
		System.out.println(user);
	}
}
