package com.wushengde.dao;

import java.util.ArrayList;
import java.util.List;

import com.wushengde.domain.Admin;
import com.wushengde.domain.Message;
import com.wushengde.domain.User;

public interface UserDao {
	/**
	 * �����û��������û�
	 * 
	 * @param uername �û���
	 *            
	 * @return �����û����ҵ����û���Ϣbean�����û���ҵ�����null��
	 */
	public User findUserName(String username);
	
	/**
	 * �����û��ķ���
	 * 
	 * @param user
	 *            Ҫ���ӵ��û���Ϣbean
	 */
	public void addUser(User user);
	
	
	/**
	 * ��ͨ�û���¼��ѯ
	 * �����û���������Ҷ�Ӧ���û�
	 * 
	 * @param username
	 *            �û���
	 * @param password
	 *            ����
	 * @return �ҵ����û�������Ҳ����򷵻�null��
	 */
	
	public User findUserByUNandPSW(String username, String password);
	/**
	 * ����Ա�û���¼��ѯ
	 */
	
	public Admin findAdminUP(String username,String password);
	
	/**
	 * �������ݿ��е�������Ϣ
	 * @return
	 * 
	 */
	
	public List findMessage();
	
	/**
	 * ��������
	 * @param msg
	 */
	public void addMsg(Message msg);
	
	/**
	 * ����Id�鿴��������
	 * @param msg
	 */
	public Message findMsg(int id);
	/**
	 * �����������ݿ��е�����
	 * @param msg
	 */
	public void updateMsg(Message msg);
	/**
	 * ɾ���������ݿ��е�����
	 * @param msg
	 */
	public void deleteMsg(Message msg);
}