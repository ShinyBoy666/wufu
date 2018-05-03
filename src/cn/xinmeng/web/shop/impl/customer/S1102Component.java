package cn.xinmeng.web.shop.impl.customer;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xinmeng.api.entity.auto.CustomerReport;
import cn.xinmeng.api.entity.auto.example.CustomerReportExample;
import cn.xinmeng.api.service.ICustomerReportService;
import cn.xinmeng.common.enums.ex.ExCustomerEnum;
import cn.xinmeng.common.enums.ex.ExRequestEnum;
import cn.xinmeng.common.exceptions.BusinessException;
import cn.xinmeng.common.exceptions.NullException;
import cn.xinmeng.common.util.LogManager;
import cn.xinmeng.common.util.Utils;
import cn.xinmeng.web.base.entity.AppRequestEntity;
import cn.xinmeng.web.base.entity.AppResponseEntity;
import cn.xinmeng.web.base.entity.PageInfoEntity;
import cn.xinmeng.web.base.entity.PageSearchEntity;
import cn.xinmeng.web.base.service.BaseService;

/**
 * 团队列表
 * @author Administrator
 *
 */
@Component ("cn.xinmeng.web.shop.impl.customer.S1102Component")
public class S1102Component extends BaseService {

	@Resource
	private ICustomerReportService customerReportService;
	
	@Override
	public AppResponseEntity callServer(AppRequestEntity request,String data){
		PageSearchEntity entity = parseRequertParam(data, PageSearchEntity.class);
		
		if(entity == null){
			throw new NullException(LogManager.getLogger(this.getClass()),ExRequestEnum.REQUEST_DATA);
		}else if(Utils.isEmpty(entity.getCustomerId())) {
			throw new BusinessException(LogManager.getLogger(this.getClass()),ExCustomerEnum.EX_NULL_CUSTOMER_ID);
		}
		
		//返回分页数据
		PageInfoEntity<CustomerReport> resPage = new PageInfoEntity<CustomerReport>();
		List<CustomerReport> result = new ArrayList<CustomerReport>();
		
		CustomerReportExample example = new CustomerReportExample();
		example.setOrderByClause(" team_number desc,last_update_time,id ");
		CustomerReportExample.Criteria criteria = example.createCriteria();
		criteria.andRecommendCustomerIdEqualTo(entity.getCustomerId());		
		int totalCount = customerReportService.countByExample(example);
		if(totalCount > 0){
			List<CustomerReport> list = customerReportService.selectByExample(entity.getCurrentPage(), entity.getLimit(), example);
			if(!Utils.isEmpty(list)){
				result = list;
			}
		}
		resPage.setList(result);
		resPage.setCurrentPage(entity.getCurrentPage());
		resPage.setLimit(entity.getLimit());
		resPage.setTotalRecord(totalCount);
		return getAppResponseEntity(resPage);
	}
	
}
