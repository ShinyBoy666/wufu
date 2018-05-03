package cn.xinmeng.quartz.job;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;

import cn.xinmeng.quartz.base.BaseJob;
import cn.xinmeng.quartz.service.QuartzJobManager;

public class MyJob extends BaseJob{
	
	private QuartzJobManager quartzJobManager;
	protected Scheduler quartzScheduler;

	public void work() throws SchedulerException{
//		try {
////			HttpClientUtils.testThread();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		Date date = new Date();
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		System.out.println(format.format(date)+" myJob is work....");
//
//		TriggerKey triggerKey = TriggerKey.triggerKey("trigger-job-addJob", Scheduler.DEFAULT_GROUP);  
//		Trigger trigger = quartzScheduler.getTrigger(triggerKey);  
//		if(trigger == null){  
//			System.out.println("==========================================================================");
//			//			quartzJobManager.addJob("addJob", "work", new Date(),6,1);
//			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("data", "数据");
//			map.put("params", "params");
//			map.put("id", 1234);
//			quartzJobManager.addJob("addJob", "work",new Date(),6,1,map.toString());
//			//			quartzJobManager.addJob("addJob", "work", DateUtil.addSecond(new Date(), 1),300,1);
//		}
//		//		quartzJobManager.addJob("addJob", "work", DateUtil.addSecond(new Date(), 1),"paramsb");
	}

	
	public void setQuartzJobManager(QuartzJobManager quartzJobManager) {
		this.quartzJobManager = quartzJobManager;
	}

	public void setQuartzScheduler(Scheduler quartzScheduler) {
		this.quartzScheduler = quartzScheduler;
	}


}
