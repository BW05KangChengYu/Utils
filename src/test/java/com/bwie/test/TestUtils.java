package com.bwie.test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.junit.Test;

import com.bwie.kangchengyu.FileUtils;
import com.bwie.kangchengyu.StrUtils;


public class TestUtils {
	/*
	 * String str="asd鐖变笂鐨勬垜鍘籠\\r澶х鍙慭n澶х澶汉涓簐er楗跨殑鎴慭n"; String html =
	 * StringUtils.toHtml(str); System.out.println(html);
	 */
@Test
public void tohtml() {
	String str = "绋嶇瓑鍝圽r\n鍜屽仴搴穃n澶у鍝圽r鍜屽鍟婃拻\n";
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
