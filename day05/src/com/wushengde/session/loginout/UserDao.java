package com.wushengde.session.loginout;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
	private UserDao() {
	}

	private static Map<String, String> map = new HashMap<String, String>();
	static {
		map.put("������", "123456");
		map.put("�Ŵ�ɽ", "123456");
		map.put("���޼�", "123456");
		map.put("����", "123456");

	}

	public static boolean valiNamePsw(String username, String password) {
		return map.containsKey(username) && map.get(username).equals(password);
	}
}