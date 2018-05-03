package cn.xinmeng.quartz.service.impl;

import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.stereotype.Service;

import cn.xinmeng.quartz.service.QuartzJobManager;

/**
 * 动态定时任务添加
 * @author jiangyong.tan
 */
@Service("quartzJobManager")
public class QuartzJobManagerImpl extends BaseQuartzManager implements QuartzJobManager {

	@Override
	public void addJob(String targetObject, String targetMethod, Date startTime) {
		try {
			//设置执行对象
			JobDetail jobDetail = getJobDetail(targetObject, targetMethod);
			
			//设置执行时间
			Trigger trigger = getSimpleTrigger(targetObject, startTime);
			
			//启动定时器
			quartzScheduler.scheduleJob(jobDetail, trigger);
		} catch (Exception e) {
			
		}
	}

	/**
	 * 指定时间执行（只执行一次）
	 * @param targetObject  执行类
	 * @param targetMethod	执行方法
	 * @param startTime		执行时间
	 * @param data			参数数据
	 */
	public void addJob(String targetObject,String targetMethod,Date startTime,String data){
		try {
			//设置执行对象
			JobDetail jobDetail = getJobDetail(targetObject, targetMethod, data);
			
			//设置执行时间
			Trigger trigger = getSimpleTrigger(targetObject, startTime);
			
			//启动定时器
			quartzScheduler.scheduleJob(jobDetail, trigger);
			quartzScheduler.start();
		} catch (Exception e) {
			
		}
	}
	
	/**
	 * 指定时间执行（多次）
	 * @param targetObject  	执行类
	 * @param targetMethod		执行方法
	 * @param startTime			执行时间
	 * @param repeatCount		重复执行次数
	 * @param repeatInterval	重复执行时间间隔
	 */
	public void addJob(String targetObject,String targetMethod,Date startTime,int repeatCount,int repeatInterval){
		try {
			//设置执行对象
			JobDetail jobDetail = getJobDetail(targetObject, targetMethod);
			
			//设置执行时间
			Trigger trigger = getSimpleTrigger(targetObject, startTime, repeatCount, repeatInterval);
			
			//启动定时器
			quartzScheduler.scheduleJob(jobDetail, trigger);
		} catch (Exception e) {
			
		}
	}
	

	/**
	 * 指定时间执行（多次）
	 * @param targetObject  	执行类
	 * @param targetMethod		执行方法
	 * @param startTime			执行时间
	 * @param repeatCount		重复执行次数
	 * @param repeatInterval	重复执行时间间隔
	 * @param data				参数数据
	 */
	public void addJob(String targetObject,String targetMethod,Date startTime,int repeatCount,int repeatInterval,String data){
		try {
			//设置执行对象
			JobDetail jobDetail = getJobDetail(targetObject, targetMethod, data);
			
			//设置执行时间
			Trigger trigger = getSimpleTrigger(targetObject, startTime, repeatCount, repeatInterval);
			
			//启动定时器
			quartzScheduler.scheduleJob(jobDetail, trigger);
		} catch (Exception e) {
			
		}
	}
}
