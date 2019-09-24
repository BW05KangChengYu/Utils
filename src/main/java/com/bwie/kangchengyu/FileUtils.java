package com.bwie.kangchengyu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * 
 * @author apple
 *
 */
public class FileUtils {
public static Logger log = Logger.getLogger(File.class); 
	
	/**
	 * �����Ŀ¼����������ļ���������Ŀ¼�е��ļ���Ҫɾ��
	     ʹ�õݹ顣�漰���ݡ��ж�Ŀ¼�Ĵ����ԣ��ж��Ƿ�ΪĿ¼���ļ���ɾ����

	 * @param fileName
	 */
	public static void delFilePath(String fileName) {
		
		File file = new File(fileName);
		// �ļ�������  ��ֱ�ӷ���
		if(!file.exists()) {
			return;
		}
		
		// ������ļ�  ��ɾ���󷵻�
		if(file.isFile()) {
			log.info(" ɾ���ļ� " + fileName);
			file.delete();
			return;
		}
		
		//�����Ŀ¼
		if(file.isDirectory()) {
			// ���г�Ŀ¼�����е���Ŀ¼���ļ�
			 String[] list = file.list();
			 //���ÿһ��
			 for (String subPath : list) {
				 //����ɾ������
				 delFilePath(fileName + "/" + subPath);
			}
			 log.info(" ------------ ɾ���ļ� �� �� " + fileName); 
			file.delete(); 
		}
		
		
	}
	
	//3.5.2��ȡ�ļ���չ��
	/**
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getSuffix(String fileName) {
		int dotIndex = fileName.lastIndexOf('.');
		//û����չ��
		if(dotIndex<0) {
			return "";
		}
		//���һλ�� .
		if(dotIndex>=fileName.length()) {
			return "";
		}
		//
		return fileName.substring(dotIndex+1);
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public static String getSystemProp(String key) {
		
		String propValue = System.getProperty(key);
		return propValue;
		
	}
	
	/**
	 * �����ļ���ָ����λ��С��ʾ
	 */
	public long  getSize(String fileName,FileUnit fileUnit) {
		File file = new File(fileName);
		
		
		long  size = file.length();
		switch (fileUnit) {
			case B:
				return size;
			case KB:
				return size/1024;
			case MB:
				return size/1024/1024;
			case GB:
				return size/1024/1024/1024;
			case TB:
				return size/1024/1024/1024/1024;
			case PB:
				return size/1024/1024/1024/1024/1024;
			default:
				return 0;
		}
		
	}
	

	public static List fileToBean(String fileName,Constructor constructor) throws IOException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		File file = new File(fileName);
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		String lineString=null;
		List  list = new ArrayList();
		while((lineString =  bufferedReader.readLine()) !=null){
			String[] split = lineString.split("\\|");
			Object object = constructor.newInstance(split);
			list.add(object);
		}
		return list;
	}
	
	/**
	 * 遍历文件夹 读取文件名称
	 * @param pathName
	 * @return
	 */
		public static List<String> getFileList(String pathName){
			String[] list = new File(pathName).list();
			 List<String> fileList = new ArrayList<String>();
			for (String string : list) {
				File subFile = new File(pathName + "\\" + string);
				if(subFile!=null && subFile.exists() && subFile.isFile())
					fileList.add(pathName + "\\" + string);
			}
			return fileList;
			
		}
		
		/**
		 * 读取文件内容
		 * @throws IOException 
		 */
		public static String readFile(String fileName) throws IOException {

			StringBuilder sb = new StringBuilder();
			
			File file = new File(fileName);
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			String lineString = null;
			
			while ((lineString = bufferedReader.readLine()) != null) {
				sb.append(lineString).append("\n");
			}
			return sb.toString();
		}
		
	
}
