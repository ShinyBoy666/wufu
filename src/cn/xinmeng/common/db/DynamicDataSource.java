package cn.xinmeng.common.db;

import java.util.logging.Logger;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
/**
 * 动态数据源
 * @author jiangyong.tan
 */
public final class DynamicDataSource extends AbstractRoutingDataSource{
	public Logger getParentLogger(){
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object determineCurrentLookupKey() {
		 return DynamicDataSourceHolder.getDataSource();  
	}
}
