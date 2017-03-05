package mao.hotel.framework.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import mao.common.query.PageBean;
import mao.common.query.QueryHelper;
import mao.hotel.framework.dao.IBaseDao;

@Transactional
public abstract class BaseService<T> implements IBaseService<T>{

	@Autowired
	private IBaseDao<T> baseDao;
	
	@Override
	public void save(T entity) {
		Assert.notNull(entity);
		baseDao.save(entity);
	}

	@Override
	public void delete(String id) {
		baseDao.delete(id);
	}

	@Override
	public void update(T entity) {
		Assert.notNull(entity);
		baseDao.update(entity);
		
	}

	@Override
	@Transactional(readOnly = true)
	public T getById(String id) {
		return baseDao.getById(id);
	}

	@Override
	public List<T> getByIds(String[] ids) {
		return baseDao.getByIds(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> findAll() {
		return baseDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryHelper) {
		return baseDao.getPageBean(pageNum, pageSize, queryHelper);
	}

}
