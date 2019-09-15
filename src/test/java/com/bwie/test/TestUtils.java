package com.bwie.test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.junit.Test;

import com.bwie.kangchengyu.FileUtils;
import com.bwie.kangchengyu.StrUtils;


public class TestUtils {
	/*
	 * String str="asd���ϵ���ȥ\\\r����\n�������Ϊver������\n"; String html =
	 * StringUtils.toHtml(str); System.out.println(html);
	 */
@Test
public void tohtml() {
	String str = "�Եȹ�\r\n�ͽ���\n��ҹ�\r�Ͷ԰���\n";
	String html =StrUtils.toHtml(str); 
	System.out.println();
	System.out.println(html);
}

@Test
public void testFileToBean() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
	String fileNameString="F:\\רҵ����\\Сʵѵ\\1705D\\Utils\\src\\main\\resources\\reginfo";
	List list= FileUtils.fileToBean(fileNameString,RegisterInfo.class.getConstructor(
			String.class,String.class,String.class,String.class,String.class,
			String.class,String.class,String.class,String.class,String.class
			
			) );
	
	System.out.println("list is " + list);
	for (int i = 0; i < list.size(); i++) {
		System.out.println("list is " + list.get(i));
	}
	
}
}
