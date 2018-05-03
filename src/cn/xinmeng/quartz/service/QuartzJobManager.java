package cn.xinmeng.quartz.service;

import java.util.Date;

public interface QuartzJobManager {
	
	/**
	 * 指定时间执行（只执行一次）
	 * @param targetObject  执行类
	 * @param targetMethod	执行方法
	 * @param startTime		执行时间
	 */
	public void addJob(String targetObject,String targetMethod,Date startTime);

	/**
	 * 指定时间执行（只执行一次）
	 * @param targetObject  执行类
	 * @param targetMethod	执行方法
	 * @param startTime		执行时间
	 * @param data			参数数据
	 */
	public void addJob(String targetObject,String targetMethod,Date startTime,String data);
	
	/**
	 * 指定时间执行（多次）
	 * @param targetObject  	执行类
	 * @param targetMethod		执行方法
	 * @param startTime			执行时间
	 * @param repeatCount		重复执行次数
	 * @param repeatInterval	重复执行时间间隔（秒）
	 */
	public void addJob(String targetObject,String targetMethod,Date startTime,int repeatCount,int repeatInterval);
	

	/**
	 * 指定时间执行（多次）
	 * @param targetObject  	执行类
	 * @param targetMethod		执行方法
	 * @param startTime			执行时间
	 * @param repeatCount		重复执行次数
	 * @param repeatInterval	重复执行时间间隔（秒）
	 * @param data				参数数据
	 */
	public void addJob(String targetObject,String targetMethod,Date startTime,int repeatCount,int repeatInterval,String data);
}
