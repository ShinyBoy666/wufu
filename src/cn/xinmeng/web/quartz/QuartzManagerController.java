package cn.xinmeng.web.quartz;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerKey;

import cn.xinmeng.common.context.ApplicationContextHolder;
import cn.xinmeng.common.util.DateUtil;
import cn.xinmeng.quartz.base.BaseJob;
import cn.xinmeng.quartz.base.JobManager;

@SuppressWarnings("all")
public class QuartzManagerController {

	/**
	 * 得到job数据列表
	 * @author jiangyong.tan
	 * @date 2014-6-12 上午11:18:03
	 * @return
	 */
	public String getJobDataList() {
		JobManager jobManager = 
				(JobManager) ApplicationContextHolder.getWebApplicationContext().getBean("autoJob");
		Scheduler scheduler = 
				(Scheduler) ApplicationContextHolder.getWebApplicationContext().getBean("quartzScheduler");
		List<String> jobsList = jobManager.getJobs();
		List dataList = new ArrayList();
		StringBuffer sb = new StringBuffer();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		StringBuffer sbOperator = new StringBuffer();
		for (String jobName : jobsList) {
			Map<String, String> dataMap = new HashMap();
			dataMap.put("jobName", jobName);
			try {
				BaseJob job = (BaseJob) ApplicationContextHolder.getWebApplicationContext().getBean(jobName);
				String realJobName = "job-" + job.getJobId();
				JobKey jobKey = new JobKey(realJobName);
				TriggerKey triggerKey = TriggerKey.triggerKey("trigger-" + jobKey.getName());
				Trigger trigger = scheduler.getTrigger(triggerKey);
				if (trigger != null) {
					dataMap.put("previousFireTime", trigger.getPreviousFireTime() == null ? "" : df.format(trigger.getPreviousFireTime()));
					dataMap.put("nextFireTime", trigger.getNextFireTime() == null ? "" : df.format(trigger.getNextFireTime()));
					dataMap.put("startTime", trigger.getStartTime() == null ? "" : df.format(trigger.getStartTime()));
					dataMap.put("endTime", trigger.getEndTime() == null ? "" : df.format(trigger.getEndTime()));
					dataMap.put("diffTime", trigger.getEndTime() == null ? "" : DateUtil.getDiffTimeDesc(trigger.getStartTime(), trigger.getEndTime()));
				}
				String stateName = scheduler.getTriggerState(triggerKey).name();
				dataMap.put("triggerState", stateName);
				if ("NORMAL".equals(stateName)) {
					// 运行中
					sbOperator.append("<a href='#' onclick='oper(\"0\", \"" + realJobName + "\");'>暂停</a>&nbsp;&nbsp;");
					sbOperator.append("<a href='#' onclick='oper(\"1\", \"" + realJobName + "\");'>停止</a>");
					sbOperator.append("<a href='#' onclick='oper(\"4\", \"" + realJobName + "\");'>运行一次</a>");
				} else if ("ERROR".equals(stateName)) {
					sbOperator.append("<a href='#' onclick='oper(\"1\", \"" + realJobName + "\");'>停止</a>");
					sbOperator.append("<a href='#' onclick='oper(\"4\", \"" + realJobName + "\");'>运行一次</a>");
				} else if (stateName.equals("PAUSED")) {
					sbOperator.append("<a href='#' onclick='oper(\"2\", \"" + realJobName + "\");'>恢复</a>");
					sbOperator.append("<a href='#' onclick='oper(\"1\", \"" + realJobName + "\");'>停止</a>");
				} else if ("NONE".equals(stateName)) {
					sbOperator.append("<a href='#' onclick='oper(\"3\", \"" + realJobName + "\");'>启动</a>");
				}
				dataMap.put("operator", sbOperator.toString());
				sbOperator.setLength(0);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			dataList.add(dataMap);
		}
//		this.getAttributeUtil().setAttribute("dataList", Scope.REQUEST, dataList);
//		this.getAttributeUtil().setAttribute("totalRows", Scope.REQUEST, dataList.size());
		return "jobsPage";
	}
	
	/**
	 * 暂停job
	 * @author jiangyong.tan
	 * @date 2014-6-12 下午3:38:58
	 * @param jobName
	 */
	public void pauseJob(String jobName) {
		try {
			JobManager jobManager = 
					(JobManager) ApplicationContextHolder.getWebApplicationContext().getBean("autoJob");
			jobManager.pauseJob(jobName);
//			this.succAjaxResult("操作成功");
		} catch (Exception e) {
			e.printStackTrace();
//			this.failAjaxResult("操作失败", e.getLocalizedMessage());
		}
	}
	
	/**
	 * 恢复job
	 * @author jiangyong.tan
	 * @date 2014-6-12 下午3:38:58
	 * @param jobName
	 */
	public void resumeJob(String jobName) {
		try {
			JobManager jobManager = 
					(JobManager) ApplicationContextHolder.getWebApplicationContext().getBean("autoJob");
			jobManager.resumeJob(jobName);
//			this.succAjaxResult("操作成功");
		} catch (Exception e) {
			e.printStackTrace();
//			this.failAjaxResult("操作失败", e.getLocalizedMessage());
		}
	}
	
	/**
	 * 停止job
	 * @author jiangyong.tan
	 * @date 2014-6-12 下午3:38:58
	 * @param jobName
	 */
	public void stopJob(String jobName) {
		try {
			JobManager jobManager = 
					(JobManager) ApplicationContextHolder.getWebApplicationContext().getBean("autoJob");
			jobManager.stopJob(jobName);
//			this.succAjaxResult("操作成功");
		} catch (Exception e) {
			e.printStackTrace();
//			this.failAjaxResult("操作失败", e.getLocalizedMessage());
		}
	}
	
	/**
	 * 开始job
	 * @author jiangyong.tan
	 * @date 2014-6-12 下午3:38:58
	 * @param jobName
	 */
	public void startJob(String jobName) {
		try {
			JobManager jobManager = 
					(JobManager) ApplicationContextHolder.getWebApplicationContext().getBean("autoJob");
			jobManager.startJob(jobName);
//			this.succAjaxResult("操作成功");
		} catch (Exception e) {
			e.printStackTrace();
//			this.failAjaxResult("操作失败", e.getLocalizedMessage());
		}
	}
	
	/**
	 * 运行一次
	 * @author jiangyong.tan
	 * @date 2014-6-13 下午2:45:57
	 * @param jobName
	 */
	public void runOnceJob(String jobName) {
		try {
			JobManager jobManager = 
					(JobManager) ApplicationContextHolder.getWebApplicationContext().getBean("autoJob");
			jobManager.triggerJob(jobName);
//			this.succAjaxResult("操作成功");
		} catch (Exception e) {
			e.printStackTrace();
//			this.failAjaxResult("操作失败", e.getLocalizedMessage());
		}
	}
}
