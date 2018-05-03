package cn.xinmeng.quartz.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;

@SuppressWarnings("all")
public class JobManager implements ApplicationContextAware{
	private String config;
	private List<String> jobs = null;
	private StdScheduler stdScheduler;
	private List<Scheduler> schedulerList = new ArrayList();
	private static ApplicationContext applicationContext;
	private Map<String, Object[]> jobInfoMap = new HashMap();

	public void init(){
		
		if (this.jobs == null) {
			System.out.println("job list is not initialized.");
			return;
		}
		try {
			JobDetailFactoryBean jobDetailFactory = new JobDetailFactoryBean()
			{
				public JobDetail getObject(){
					return super.getObject();
				}
			};
			jobDetailFactory.setJobClass(BaseJob.class);
			Scheduler scheduler = getScheduler();
			Scheduler stdScheduler = scheduler;
			this.schedulerList.add(stdScheduler);
			for (String jobName : this.jobs) {
				try {
					BaseJob job = (BaseJob)applicationContext.getBean(jobName);
					String name = "job-" + job.getJobId();
					JobDataMap jobDataMap = new JobDataMap();
					jobDataMap.put("targetName", jobName);
					jobDataMap.put("targetMethod", job.getTargetMethod());
					jobDataMap.put("concurrent", false);
					jobDetailFactory.setJobDataMap(jobDataMap);
					jobDetailFactory.setName(name);
					jobDetailFactory.afterPropertiesSet();

					CronTriggerFactoryBean triggerBean = new CronTriggerFactoryBean();
					triggerBean.setMisfireInstruction(2);
					triggerBean.setJobDetail(jobDetailFactory.getObject());
					triggerBean.setCronExpression(job.getCronExpression());
					triggerBean.setName("trigger-" + name);
					triggerBean.afterPropertiesSet();

					JobKey jobKey = new JobKey(name);

					stdScheduler.deleteJob(jobKey);
					JobDetail jobDetail = jobDetailFactory.getObject();
					CronTrigger cronTrigger = triggerBean.getObject();
					stdScheduler.scheduleJob(jobDetail, cronTrigger);

					this.jobInfoMap.put(name, new Object[] { jobDetail, cronTrigger });
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}

			stdScheduler.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void destroy() {
		for (Scheduler sc : this.schedulerList)
			try {
				if (!sc.isShutdown())
					sc.shutdown(true);
			}catch (Exception localException){
			}
	}

	private Scheduler getScheduler()
	{
		if (this.stdScheduler != null) {
			return this.stdScheduler;
		}
		if ((this.config == null) || ("".equals(this.config.trim()))) {
			System.out.println("job config is not ok.");
			return null;
		}
		String filePath = getClass().getResource(this.config).getPath();
		System.out.println("job config location is " + filePath);
		try {
			SchedulerFactory sf = new StdSchedulerFactory(filePath);
			return sf.getScheduler();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<String> getJobs() {
		return this.jobs;
	}

	public void setJobs(List<String> jobs) {
		this.jobs = jobs;
	}

	public void setConfig(String config) {
		this.config = config;
	}

	public void setApplicationContext(ApplicationContext context)throws BeansException{
		applicationContext = context;
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public void setStdScheduler(StdScheduler stdScheduler) {
		this.stdScheduler = stdScheduler;
	}

	public void stopJob(String jobName)throws SchedulerException{
		Scheduler scheduler = getScheduler();
		if (!scheduler.isStarted()) {
			return;
		}
		scheduler.deleteJob(JobKey.jobKey(jobName));
	}

	public void startJob(String jobName)throws SchedulerException{
		Scheduler scheduler = getScheduler();
		if (!scheduler.isStarted()) {
			return;
		}
		if (this.jobInfoMap.containsKey(jobName)) {
			Object[] jobInfos = (Object[])this.jobInfoMap.get(jobName);
			scheduler.scheduleJob((JobDetail)jobInfos[0], (CronTrigger)jobInfos[1]);
		}
	}

	public void resumeJob(String jobName)throws SchedulerException{
		Scheduler scheduler = getScheduler();
		if (!scheduler.isStarted()) {
			return;
		}
		scheduler.resumeJob(JobKey.jobKey(jobName));
	}

	public void pauseJob(String jobName)throws SchedulerException{
		Scheduler scheduler = getScheduler();
		if (!scheduler.isStarted()) {
			return;
		}
		scheduler.pauseJob(JobKey.jobKey(jobName));
	}

	public void triggerJob(String jobName)throws SchedulerException{
		Scheduler scheduler = getScheduler();
		if (!scheduler.isStarted()) {
			return;
		}
		scheduler.triggerJob(JobKey.jobKey(jobName));
	}
}