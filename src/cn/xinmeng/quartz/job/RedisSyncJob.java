package cn.xinmeng.quartz.job;

import javax.annotation.Resource;

import org.quartz.SchedulerException;

import cn.xinmeng.api.service.IActivityProductService;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.quartz.base.BaseJob;

public class RedisSyncJob extends BaseJob{
	
	@Resource
	private IActivityProductService activityProductService;

	public void work() throws SchedulerException{
		try {
			LogManager.info(this.getClass(),"redis同步job","");
			activityProductService.redisSyncMysqlActivityProduct();
		} catch (Exception e) {
			LogManager.error(this.getClass(),e.getMessage(),e);
		}
	}
}
