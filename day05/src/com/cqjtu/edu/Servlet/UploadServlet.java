package com.cqjtu.edu.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/UploadServlet")
@MultipartConfig(
		location="G:\\MyEclipseProfessional\\day05\\upload",
		maxFileSize=831828882,
		fileSizeThreshold=819200,
		maxRequestSize=-1
		)
public class UploadServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ȡ�����ϴ��ļ���Ӧ��Part����
		Collection<Part>parts=request.getParts();
		for(Iterator<Part>iterator=parts.iterator();iterator.hasNext();){
			Part part=iterator.next();
			String cotentDisposition=part.getHeader("content-disposition");
			System.out.println("content-disposition="+cotentDisposition);
			String fileName=null;
			//ʹ���������ǲ���ƥ�䣬��ȡ�ϴ��ļ�����
			Pattern pattern=Pattern.compile("filename=\".+\"");//ע��filename��fileName��ͬ
			Matcher matcher=pattern.matcher(cotentDisposition);
			if(matcher.find()){
				fileName=matcher.group();
				System.out.println("fileName="+fileName);
				fileName=fileName.substring(10,fileName.length()-1);
				System.out.println("subFileName="+fileName);
			}
			if(fileName!=null){
				part.write(fileName);
			}
		}	
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
