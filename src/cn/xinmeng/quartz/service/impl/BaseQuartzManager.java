package cn.xinmeng.quartz.service.impl;

import java.util.Date;

import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;

import cn.xinmeng.quartz.base.BaseJob;

public class BaseQuartzManager {

	protected Scheduler quartzScheduler;
	
	protected JobDetail getJobDetail(String targetObject, String targetMethod){
		return getJobDetail(targetObject, targetMethod, null);
	}
	
	protected JobDetail getJobDetail(String targetObject, String targetMethod,String data) {
		JobDetailFactoryBean jobDetailFactory = new JobDetailFactoryBean()
		{
			public JobDetail getObject(){
				return super.getObject();
			}
		};
		jobDetailFactory.setJobClass(BaseJob.class);
		JobDataMap jobDataMap = new JobDataMap();
		jobDataMap.put("targetName", targetObject);
		jobDataMap.put("targetMethod", targetMethod);
		if(data != null){
			jobDataMap.put("job_data", data);
		}
		jobDataMap.put("concurrent", false);
		jobDetailFactory.setJobDataMap(jobDataMap);
		jobDetailFactory.setName("job-"+targetObject);
		jobDetailFactory.afterPropertiesSet();
		JobDetail jobDetail = jobDetailFactory.getObject();
		return jobDetail;
	}
	
	protected Trigger getSimpleTrigger(String name,Date startTime) {
		return TriggerBuilder.newTrigger()
				.withIdentity("trigger-job-"+name, Scheduler.DEFAULT_GROUP)
				.startAt(startTime)
				.build();
	}
	
	protected Trigger getSimpleTrigger(String name,Date startTime,int repeatCount,int repeatInterval) {
		return TriggerBuilder.newTrigger()
				.withIdentity("trigger-job-"+name, Scheduler.DEFAULT_GROUP)
				.startAt(startTime)
				.withSchedule(SimpleScheduleBuilder
								.simpleSchedule()
								.withIntervalInSeconds(repeatInterval)
								.withRepeatCount(repeatCount))
				.build();
	}

	public void setQuartzScheduler(Scheduler quartzScheduler) {
		this.quartzScheduler = quartzScheduler;
	}
	
}
