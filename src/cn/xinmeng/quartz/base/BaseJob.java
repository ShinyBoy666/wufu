package cn.xinmeng.quartz.base;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.util.MethodInvoker;

public class BaseJob extends MethodInvokingJobDetailFactoryBean.StatefulMethodInvokingJob
{
	private String targetName;
	private String targetMethod;
	private String jobId;
	private String cronExpression;

	protected String propertiesPath;

	public String getCronExpression()
	{
		return this.cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public String getJobId() {
		return this.jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getTargetMethod() {
		return this.targetMethod;
	}

	public void setTargetMethod(String targetMethod) {
		this.targetMethod = targetMethod;
	}

	public String getTargetName() {
		return this.targetName;
	}

	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}
	public void setPropertiesPath(String propertiesPath) {
		this.propertiesPath = propertiesPath;
	}

	public String getPropertiesPath() {
		return propertiesPath;
	}


	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException
	{
		ApplicationContext applicationContext = JobManager.getApplicationContext();
		if (getTargetName() != null) {
			Object obj = applicationContext.getBean(getTargetName());
			MethodInvoker methodInvoker = new MethodInvoker();
			methodInvoker.setTargetClass(obj.getClass());
			methodInvoker.setTargetObject(obj);
			methodInvoker.setTargetMethod(this.targetMethod);
			methodInvoker.setStaticMethod(null);

			Object data = context.getJobDetail().getJobDataMap().get("job_data");
			if(data != null){
				methodInvoker.setArguments(new Object[]{data}); 
			}
			try {
				methodInvoker.prepare();
				methodInvoker.invoke();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}