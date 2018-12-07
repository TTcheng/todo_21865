package com.wcc.base.dao;

import com.wcc.base.entity.BaseEntity;

import java.util.List;
import java.util.Map;

public interface WebCommonDao {

	/**
	 * 
	 * @Title: insert
	 * @Description: 新增
	 * @param @param BaseEntity
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throw
	 */
	public int insert(BaseEntity entity);

	/**
	 * 
	 * @Title: update
	 * @Description: 修改
	 * @param @param BaseEntity
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throw
	 */
	public int update(BaseEntity entity);
	
	/**
	 * 
	 * @Title: delete
	 * @Description: 删除
	 * @param @param entity
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throw
	 */
	public int delete(BaseEntity entity);
	
	/**
	 * 
	 * @Title: queryByZj
	 * @Description: 通过主键查询对象
	 * @param @param zj
	 * @param @return    设定文件
	 * @return BaseEntity    返回类型
	 * @throw
	 */
	public BaseEntity queryByZj(String zj);
	
	/**
	 * 
	 * @Title: queryListByEntity
	 * @Description: 通过对象查列表
	 * @param @param entity
	 * @param @return    设定文件
	 * @return List<BaseEntity>    返回类型
	 * @throw
	 */
	public List<BaseEntity> queryListByEntity(BaseEntity entity);
	
	/**
	 * 
	 * @Title: queryPageCount
	 * @Description: 查询分页总数
	 * @param @param map
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throw
	 */
	public int queryPageCount(Map<String, Object> map);

	/**
	 * 
	 * @Title: queryPageList
	 * @Description: 查询分页列表
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<?>    返回类型
	 * @throw
	 */
	public List<?> queryPageList(Map<String, Object> map);
	
	/**
	 * 
	 * @Title: querySingleByCondition
	 * @Description: 查询单条
	 * @param @param entity
	 * @param @return    设定文件
	 * @return BaseEntity    返回类型
	 * @throw
	 */
	public BaseEntity querySingleByCondition(Object entity);

}
