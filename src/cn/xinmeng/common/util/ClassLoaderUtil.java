package cn.xinmeng.common.util;

import java.io.File;
import java.io.InputStream;

import cn.xinmeng.common.exceptions.FileException;

public class ClassLoaderUtil {
	private static ClassLoader classLoader = null;
	/**
	 * 获取文件绝对路径
	 * @param value 文件相对 classpath 路径
	 * @return
	 */
	private static String getClassPath(String value){
		try{
			if(classLoader == null){
				classLoader = ClassLoaderUtil.class.getClassLoader();
			}
			return classLoader.getResource(value).getPath();
		}catch(Exception e){
			throw new FileException("Exception 文件地址："+value+" 错误。",e);
		}
	}
	/**
	 * 返回 classPath 路径
	 * @return
	 */
	public static String getClassPath(){
		return getClassPath("");
	}
	
	/**
	 * 获取文件绝对路径
	 * @param value 文件相对 classpath 路径
	 * @return
	 */
	public static String getFilePath(String value){
		return getClassPath(value);
	}
	/**
	 * 获取文件
	 * @param value 文件相对 classpath 路径
	 * @return
	 */
	public static File getFile(String value){
		return new File(getClassPath(value));
	}
	
	/**
	 * 获取文件输入流
	 * @param value 文件相对 classpath 路径
	 * @return
	 */
	public static InputStream getInputStream(String value){
		try{
			if(classLoader == null){
				classLoader = ClassLoaderUtil.class.getClassLoader();
			}
			return classLoader.getResourceAsStream(value);
		}catch(Exception e){
			throw new FileException("Exception 文件地址："+value+" 错误。",e);
		}
	}
}
