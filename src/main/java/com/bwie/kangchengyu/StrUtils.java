package com.bwie.kangchengyu;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author apple
 *
 */
public class StrUtils {
	
	/**
	 *  1.�п�
	 * 	�ж��ǲ��ǿ��ַ���
	 */
	public static boolean isNull(String str) {
		/**
		 * �����null ���� ���� ���� ��   �� ���Ϊtrue
		 * (ע:trim()----ȥ���ո�)
		 */
		return (null==str||"".equals(str.trim()));
	}
	
	/**
	 * 	2.�Ƿ���ֵ
	 *	 �ж��ַ����Ƿ���ֵ�������źͿո�Ҳ��ûֵ
	 */
	public static boolean isHasValue(String str) {
		/**
		 * 	���ַ����ǵȼ۵�
		 * 	 ��(str = null || "".equals(str.trim()));
		 */
		return	(str != null && !"".equals(str.trim()));
	}
	
	/**
	 * 	3.��֤�ֻ���
	 * 	�����������ʽ��֤�ǲ��ǵ绰����
	 */
	public static boolean isTelephone(String str) {
		String phone="^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
		return str.matches(phone);
	}
	
	/**
	 * 	4.��֤����
	 * 	�����������ʽ��֤�ǲ�������
	 */
	public static boolean isEmail(String str) {
		String email="^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		Pattern pattern = Pattern.compile(email);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
	
	/**
	 * 	5.��֤ȫΪ��ĸ
	 */
	public static boolean isLetter(String str) {
		String letter="^[a-zA-Z]+$";
		return str.matches(letter);
	}
	
	/**
	 * 	6.��ȡnλ���Ӣ���ַ���
	 */
	public String getRandomStr (int n) {
		if (n<=0) {
			return "";
		}
		
		/**
		 * String ÿ���������ӵ�ʱ��������new��һ������ �����������ӵ�ʱ���ʱ��
		 * StringBuffer ��һ���̰߳�ȫ�Ķ��� �����������ӵ�ʱ���ʱ��
		 * StringBuilder ��һ���̲߳���ȫ�Ķ��� �ں����ڲ��� �����漰���̰߳�ȫ���� ���������ӵ�ʱ�������������ʡһ��ʱ�� 
		 */
		Random random =new Random();
		
		StringBuilder sb= new StringBuilder();
		for (int i = 0; i < n; i++) {
			char letter = (char)('A'+random.nextInt(26));
			sb.append(letter);
		}
		return sb.toString();
	}
	
	/**
	 * 	7.��ȡnλ���Ӣ�ĺ������ַ���
	 */
	public String getRandomStrNum(int n) {
		char[] chars= {'1','2','3','4','5','6','7','8','9','0',
				'a','s','d','f','g','h','j','k','l','A','S','D','F','G','H','J','K','L',
				'q','w','e','r','t','y','u','i','o','p','Q','W','E','R','T','Y','U','I','O','P',
				'z','x','c','v','b','n','m','Z','X','C','V','B','N','M'};
		Random random =new Random();
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < n; i++) {
			
			/**
			 * 	����ĵ�һ���±�Ϊ	random.nextInt(chars.length)
			 * 	�����±�������л�ȡֵ ƴ�ӵ��ַ�����
			 */
			sb.append(chars[random.nextInt(chars.length)]);
		}
		return sb.toString();
	}
	
	/**
	 * 	8.�����ȡn����������ַ���
	 */
	public static String getRandomCnStr(int n) {
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(getOneCn());
		}
		return sb.toString();
	}
	
	/**
	 * 	�����ȡһ�����ĺ���
	 * @return
	 */
	private static String getOneCn() {
		String str = "";
		int hightPos; //
		int lowPos;
		
		Random random = new Random();

		hightPos = (176 + Math.abs(random.nextInt(39)));
		lowPos = (161 + Math.abs(random.nextInt(93)));

		byte[] b = new byte[2];
		b[0] = (Integer.valueOf(hightPos)).byteValue();
		b[1] = (Integer.valueOf(lowPos)).byteValue();

		try {
			str = new String(b, "GBK");
		} catch (Exception e) {
		    e.printStackTrace();
		    System.out.println("����");
		}

		return str;

	}
}