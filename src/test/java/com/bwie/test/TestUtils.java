package com.bwie.test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.junit.Test;

import com.bwie.kangchengyu.FileUtils;
import com.bwie.kangchengyu.StrUtils;


public class TestUtils {
	/*
	 * String str="asd爱上的我去\\\r大神发\n大神夫人为ver饿的我\n"; String html =
	 * StringUtils.toHtml(str); System.out.println(html);
	 */
@Test
public void tohtml() {
	String str = "稍等哈\r\n和健康\n大家哈\r和对啊撒\n";
	String html =StrUtils.toHtml(str); 
	System.out.println();
	System.out.println(html);
}

@Test
public void testFileToBean() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
	String fileNameString="F:\\专业资料\\小实训\\1705D\\Utils\\src\\main\\resources\\reginfo";
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
