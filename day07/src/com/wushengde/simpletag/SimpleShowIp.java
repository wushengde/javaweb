package com.wushengde.simpletag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

public class SimpleShowIp implements SimpleTag {
	private JspContext pc = null;

	// ������doTag����,��������������ǿ�����д������ǩ�¼���java����
	// ���Զ����ǩִ����ɺ�,�򵥱�ǩ��������ٵ���.
	public void doTag() throws JspException, IOException {
		PageContext pcx = (PageContext)pc;
		String ip = pcx.getRequest().getRemoteAddr();
		pcx.getOut().write(ip);
	}

	public JspTag getParent() {

		return null;
	}

	// �����ǰ��ǩ���б�ǩ��,������setJspBody����װ�˱�ǩ����Ϣ��JspFragment����,���û�б�ǩ��,���������ִ��
	public void setJspBody(JspFragment jspBody) {

	}

	// �൱�ڴ����˵�ǰjspҳ���pageContext������ΪJspContext��pageContext��ֱ�Ӹ��ࡣ
	public void setJspContext(JspContext pc) {
		this.pc = pc;

	}

	// �����ǰ��ǩ�и���ǩ�����setParent����������ǩ����,���û�и���ǩ������������ᱻ����.
	public void setParent(JspTag parent) {

	}

}