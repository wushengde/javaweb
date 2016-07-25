package com.wushengde.sm_test.mapper;

import java.util.List;

import com.wushengde.sm_test.domain.User;
/*
 * 对应的增删改查的方法
 */
public interface UserMapper {
	
	void save(User user);
	
	void update(User user);
	
	void delete(int id);
	
	User findById(int id);
	
	List<User> findAll();

}
