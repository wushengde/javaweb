package com.wushengde.jsp;

import java.util.LinkedHashMap;
import java.util.Map;

import com.wushengde.domain.Book;
/*
 * �൱��һ�����ݿ⣺��ģ��һ�����ݿ⡣
 */
public class BookDao {
	private static Map<String,Book> bookMap = new LinkedHashMap<String, Book>();
	private BookDao(){
	}
	static{
		bookMap.put("1",new Book("1","��������","99","�޹���","����������","һȺ���˾��᲻��Ĺ���......"));
		bookMap.put("2",new Book("2","ˮ䰴�","108","ʩ����","���������","105�����˸�3��Ů�˵Ĺ���......"));
		bookMap.put("3",new Book("3","���μ�","10","��ж�","�����ʵ������","һ������һֻ�һ��ͺͷһͷ������һƥ��ȥ����Ĺ���......"));
		bookMap.put("4",new Book("4","��ƿ÷","38","��������","�Ƽ���ҵ������","���Ҳ����Ĺ���......"));
	}
	public static Map<String,Book> getBooks(){
		return bookMap;
	}
	public static Book getBook(String id){
		return bookMap.get(id);
	}
	
}