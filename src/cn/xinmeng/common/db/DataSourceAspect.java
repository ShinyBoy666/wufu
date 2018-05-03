package cn.xinmeng.common.db;

import org.aspectj.lang.JoinPoint;

import cn.xinmeng.common.enums.EnumDataBase;

public class DataSourceAspect {
	
	//业务库
	public void before(JoinPoint point)  
	{  
		String method = point.getSignature().getName();  
		if(method.indexOf("get") == 0){
			DynamicDataSourceHolder.setDataSource(EnumDataBase.DB_BUSINESS_R);
		}else if(method.indexOf("find") == 0){
			DynamicDataSourceHolder.setDataSource(EnumDataBase.DB_BUSINESS_R);
		}else if(method.indexOf("select") == 0){
			DynamicDataSourceHolder.setDataSource(EnumDataBase.DB_BUSINESS_R);
		}else if(method.indexOf("query") == 0){
			DynamicDataSourceHolder.setDataSource(EnumDataBase.DB_BUSINESS_R);
		}else if(method.indexOf("search") == 0){
			DynamicDataSourceHolder.setDataSource(EnumDataBase.DB_BUSINESS_R);
		}else{
			DynamicDataSourceHolder.setDataSource(EnumDataBase.DB_BUSINESS_RW);
		}
		
	} 
	
	//权限库
	public void privilege(JoinPoint point)  
	{  
		DynamicDataSourceHolder.setDataSource(EnumDataBase.DB_PRIVILEGE_RW);
	} 
}
