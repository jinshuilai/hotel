package mao.hotel.framework.service;

import java.util.List;

import mao.common.query.PageBean;
import mao.common.query.QueryHelper;

public interface IBaseService<T> {

	/**
	 * 保存实体
	 * @param entity
	 */
	void save(T entity);
	
	/**
	 * 删除实体
	 * @param id
	 */
	void delete(String id);
	
	/**
	 * 更新实体
	 * @param entity
	 */
	void update(T entity);
	
	/**
	 * 根据id查询实体
	 * @param id
	 * @return
	 */
	T getById(String id);
	
	/**
	 * 根据一组id查询一组实体
	 * @param ids
	 * @return
	 */
	List<T> getByIds(String[] ids);
	
	/**
	 * 查询所有的实体
	 * @return
	 */
	List<T> findAll();
	
	/**
	 * 分页信息
	 */
	PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryHelper);
}
