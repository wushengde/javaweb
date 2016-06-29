package com.wushengde.lob;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.wushengde.util.JDBCUtils;

/*
 *������ƵĴ�����ȡ�����磺��Ƶmp3����Ƶmp4�ȴ������ݿ������ȡ����
 *ע��һ�㲻����������Ч�ʵ��£�һ�����ݿ���ֻ�Ǵ洢���ڷ������еĴ���·���� 
 */

/*
	create table blobdemo(
	id int primary key auto_increment,
	name varchar(100),
	content MEDIUMBLOB
	);
*/
public class BlobDemo01 {
	
	
	@Test
	public void findBlob(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement("select * from blobdemo");
			rs =ps.executeQuery();
			while(rs.next()){
				 String filename = rs.getString("name");
				 InputStream in =rs.getBinaryStream("content");
				 OutputStream out = new FileOutputStream(filename);
				 
				 byte[] bs= new byte[1024];
				 int i = 0;
				 while((i=in.read(bs))!=-1){
					 out.write(bs,0,i);
				 }
				 in.close();
				 out.close();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs, ps, conn);
		}
		
	}
	//�����ݿ��д����Ķ������ļ����˴������mp3��Ҳ���Դ�����Ƶ�ȣ�����ע�������������ֶε����͵����ã�������Ƶ���ֻ�ܴ�4G��
	@Test
	public void addBlob(){
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement("insert into blobdemo values (null,?,?)");
			ps.setString(1, "������.mp3");
			File file = new File("b.mp3");
			ps.setBinaryStream(2, new FileInputStream(file),(int)file.length());
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs, ps, conn);
		}
	}
}