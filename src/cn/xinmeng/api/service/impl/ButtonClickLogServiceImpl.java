package cn.xinmeng.api.service.impl;

import java.util.List;
import cn.xinmeng.api.service.IButtonClickLogService;
import cn.xinmeng.api.dao.auto.ButtonClickLogDao;
import cn.xinmeng.api.entity.auto.ButtonClickLog;
import cn.xinmeng.api.entity.auto.example.ButtonClickLogExample;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.apache.ibatis.session.RowBounds;

/**
 * 业务层：ButtonClickLogServiceImpl
 * 描述：按钮点击记录
 * @author jiangyong.tan
 * @date 2016-10-19 17:54:19
 */
@Service("buttonClickLogService")
public class ButtonClickLogServiceImpl implements IButtonClickLogService {

    @Resource
	private ButtonClickLogDao buttonClickLogDao;
	
    
    /**
     * 添加数据
     * @param record
     * @return
     */
    public int add(ButtonClickLog record){
    	return buttonClickLogDao.insert(record);
    }
    
    /**
     * 按主键删除
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id){
    	return buttonClickLogDao.deleteByPrimaryKey(id);
    }
    
    /**
     * 按主键修改（全新替换每一个字段数据）
     * @param record
     * @return
     */
	public int updateByPrimaryKey(ButtonClickLog record){
		return buttonClickLogDao.updateByPrimaryKey(record);
	}
    
    /**
     * 按主键查询
     * @param id
     * @return
     */
    public ButtonClickLog selectByPrimaryKey(Integer id){
    	return buttonClickLogDao.selectByPrimaryKey(id);
    }
    
	/**
	 * 查询总条数
	 * @param example
	 * @return
	 */
	public int countByExample(ButtonClickLogExample example){
		return buttonClickLogDao.countByExample(example);
	}
	
    /**
     * 按条件查询
     * @param example
     * @return
     */
    public List<ButtonClickLog> selectByExample(ButtonClickLogExample example){
    	return buttonClickLogDao.selectByExample(example);
    }
    
    /**
     * 按条件查询（分页）
     * @param currentPage
     * @param limit
     * @param example
     * @return
     */
    public List<ButtonClickLog> selectByExample(int currentPage, int limit,ButtonClickLogExample example){
        return buttonClickLogDao.selectByExample(new RowBounds(currentPage, limit),example);
    }
    
}