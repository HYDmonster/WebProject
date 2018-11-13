package com.cqjtu.edu.Servlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadWriter {
	public static int read(String path) throws IOException{
		int count=0;
		try {
			BufferedReader in=new BufferedReader(new FileReader(path+"count.txt"));
			String s=in.readLine();
			if(s!=null){
				count=Integer.parseInt(s);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	public static void write(String path,String content){
		try {
			BufferedWriter out=new BufferedWriter(new FileWriter(path+"count.txt"));
			out.write(content);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
