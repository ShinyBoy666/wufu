package cn.xinmeng.api.dao.ex;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.xinmeng.api.entity.auto.Notice;

public interface ExNoticeDao {
	
	/**
	 * 查询消息列表
	 * @author jiangyong.tan
	 * @date 2016年2月23日 上午10:22:22
	 * @param customerId
	 * @return
	 */
	public List<Notice> searchNoticeList(RowBounds rowBounds,@Param("customerId") Integer customerId,@Param("shopId") Integer shopId);

	
	/**
	 * 查询消息数量
	 * @author jiangyong.tan
	 * @date 2016年2月23日 上午10:22:22
	 * @param customerId
	 * @return
	 */
	public Integer searchNoticeCount(@Param("customerId") Integer customerId,@Param("shopId") Integer shopId);
	
	/**
	 * 查询消息已读数量
	 * @param customerId
	 * @param shopId
	 * @return
	 */
	public Integer searchNoticeReadCount(@Param("customerId") Integer customerId,@Param("shopId") Integer shopId);
	
	/**
	 * 消息阅读次数
	 * @param id
	 * @return
	 */
	public Integer readNotice(@Param("id") Integer id);
}
