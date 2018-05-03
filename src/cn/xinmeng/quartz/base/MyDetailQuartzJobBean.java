package cn.xinmeng.quartz.base;

import java.lang.reflect.Method;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import cn.xinmeng.common.context.ApplicationContextHolder;

public class MyDetailQuartzJobBean extends QuartzJobBean
{
  private String targetObject;
  private String targetMethod;
  
  protected void executeInternal(JobExecutionContext context)
    throws JobExecutionException
  {
    try
    {
      Object otargetObject = ApplicationContextHolder.getWebApplicationContext().getBean(this.targetObject);
      System.out.println(otargetObject.toString());
      Method m = null;
      try {
        m = otargetObject.getClass().getMethod(this.targetMethod, 
          new Class[0]);
        m.invoke(otargetObject, new Object[0]);
      }
      catch (SecurityException localSecurityException)
      {
      }
      catch (NoSuchMethodException localNoSuchMethodException) {
      }
    }
    catch (Exception e) {
      throw new JobExecutionException(e);
    }
  }

  public void setTargetObject(String targetObject)
  {
    this.targetObject = targetObject;
  }

  public void setTargetMethod(String targetMethod)
  {
    this.targetMethod = targetMethod;
  }
}