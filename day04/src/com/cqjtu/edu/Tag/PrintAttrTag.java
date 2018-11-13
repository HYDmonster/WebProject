package com.cqjtu.edu.Tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class PrintAttrTag extends TagSupport{
	private String attr;
	public String getAttr() {
		return attr;
	}
	public void setAttr(String attr) {
		this.attr = attr;
	}
	public int doStartTag() throws JspException{
		HttpServletRequest request=(HttpServletRequest)pageContext.getRequest();
		String val=(String)request.getAttribute(attr);
		if(val!=null&&!val.equals("")){
			JspWriter out=pageContext.getOut();
			try {
				out.print("<font color='red'>"+val+"</font>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return super.doStartTag();
	}
}
