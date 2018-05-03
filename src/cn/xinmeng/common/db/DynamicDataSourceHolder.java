package cn.xinmeng.common.db;

import cn.xinmeng.common.enums.EnumDataBase;

public class DynamicDataSourceHolder {
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
	/**
	 * 设置数据源
	 * 业务库  => EnumDataBase.DB_BUSINESS
	 * 权限库  => EnumDataBase.DB_PERMISSION
	 * 默认 业务库 EnumDataBase.DB_BUSINESS
	 * @param edb 数据源枚举
	 */
	public static void setDataSource(EnumDataBase edb) {
		if(edb == null){
			//默认业务库
			contextHolder.set(EnumDataBase.DB_BUSINESS_RW.key());
			return;
		}
        contextHolder.set(edb.key());  
    }
	
	/**
	 * 设置数据源 => 业务库(EnumDataBase.DB_BUSINESS)
	 */
	public static void setDataSource() {
		setDataSource(null);
    }
	
	/**
	 * 设置数据源 => 业务库(EnumDataBase.DB_BUSINESS)
	 */
	public static Object getDataSource() {
		 String dataSource = contextHolder.get();
		 if(EnumDataBase.exist(dataSource) == false){
			 
		 }
		 return contextHolder.get();   
    }
	
	/**
	 * 移除数据源
	 */
    public static void removeDataSoure() {    
        contextHolder.remove();    
    }    
}
