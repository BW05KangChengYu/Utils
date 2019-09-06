package com.bwie.test;

import org.junit.Test;

import com.bwie.kangchengyu.StrUtils;

/**
 * 
 * @author apple
 *
 */
public class TestStringUtils {
	@Test
	public void testIsNull() {
		String tel1=" ";
		String tel2="haha";
		boolean tel3 = StrUtils.isNull(tel1);
		boolean tel4 = StrUtils.isNull(tel2);
		System.out.println(tel3);
		System.out.println(tel4);
	}
	@Test
	public void testTel() {
		String tel1="13791603997";
		String tel2="12221212121";
		boolean tel3 = StrUtils.isTelephone(tel1);
		boolean tel4 = StrUtils.isTelephone(tel2);
		System.out.println(tel3);
		System.out.println(tel4);
	}
	@Test
	public void testEmail() {
		String tel1="13791603997@qq.com";
		String tel2="12221212121@mm.a";
		boolean tel3 = StrUtils.isEmail(tel1);
		boolean tel4 = StrUtils.isEmail(tel2);
		System.out.println(tel3);
		System.out.println(tel4);
	}
	@Test
	public void testLetter() {
		String tel1="asdffgdAs";
		String tel2="1csasaA";
		boolean tel3 = StrUtils.isLetter(tel1);
		boolean tel4 = StrUtils.isLetter(tel2);
		System.out.println(tel3);
		System.out.println(tel4);
	}
	@Test
	public void testCn() {
		System.out.println(StrUtils.getRandomCnStr(4));
	}
}
