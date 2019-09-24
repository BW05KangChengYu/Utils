package com.bwie.test;

import java.util.List;
import java.util.Properties;

import org.junit.Test;

import com.bwie.kangchengyu.FileUtils;

public class TestFileUtils {
	
	@Test
	public void testDel() {
		FileUtils.delFilePath("D:\\ec4 - 副本");
	}
	
	
	@Test
	public void TestPro() {
		
		Properties properties = System.getProperties();
		
		properties.forEach((key,value)->{
			System.out.println("key is : " + key);
			System.out.println("value is : " + value);
		});
	}
	
	@Test
	public void testDir(){
		String pathString = "D:\\内网通\\文件\\拾间\\CMS\\main\\webapp\\resource\\js";
		List<String> fileList = FileUtils.getFileList(pathString);
		for (String string : fileList) {
			System.out.println(" string  is "  + string);
		}
	}
	
	@Test
	public void testReadFile() throws Exception{
		String fileName = "D:\\内网通\\文件\\拾间\\CMS\\main\\webapp\\resource\\js\\jquery-3.2.1.js";
		String string = FileUtils.readFile(fileName);
		string = string.replaceAll("\\\n", "<br/>\n");
		System.out.println(" string  is " + string);
	}
	
}
