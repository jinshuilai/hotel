package mao.hotel.framework.dao;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import mao.common.query.PageBean;
import mao.common.query.QueryHelper;

@SuppressWarnings("unchecked")
public abstract class BaseDao<T> implements IBaseDao<T> {

	@Autowired
	private SessionFactory sessionFactory;
	private Class<T> clazz = null;
	
	public BaseDao() {
		 ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		 this.clazz = (Class<T>) pt.getActualTypeArguments()[0];
	}

	/**
	 * 获取当前可用的session
	 * @return
	 */
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void save(T entity) {
		getSession().save(entity);
	}

	@Override
	public void delete(String id) {
		Object obj = getById(id);
		if (obj != null) {
			getSession().delete(obj);
		}
		
	}

	@Override
	public void update(T entity) {
		getSession().update(entity);
	}

	@Override
	public T getById(String id) {
		if (id == null) {
			return null;
		}else{
			return (T) getSession().get(clazz, id);
		}
	}

	@Override
	public List<T> getByIds(String[] ids) {
		if (ids == null || ids.length == 0) {
			return Collections.EMPTY_LIST;
		} else {
			return getSession().createQuery(//
					"FROM " + clazz.getSimpleName() + " WHERE id IN (:ids)")//
					.setParameterList("ids", ids)//
					.list();
		}	
	}
	
	@Override
	public List<T> findAll() {
		return getSession().createQuery("FROM "+ clazz.getSimpleName()).list();
	}
	
	
	@Override
	public PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryHelper) {
		List<Object> parameters = queryHelper.getParameters();
		
		Query query = getSession().createQuery(queryHelper.getQueryHql());
		if (parameters != null) {
			for (int i = 0; i < parameters.size(); i++) {
				query.setParameter(i, parameters.get(i));
			}
		}
		query.setFirstResult((pageNum-1) * pageSize).setMaxResults(pageSize);
		List<T> recordList = query.list();
		
		Query queryCount = getSession().createQuery(queryHelper.getCountQueryHql());
		if (parameters != null) {
			for (int i = 0; i < parameters.size(); i++) {
				queryCount.setParameter(i, parameters.get(i));
			}
		}
		Long recordCount = (Long) queryCount.uniqueResult();
		
		return new PageBean(recordList, pageNum, pageSize, recordCount.intValue());
	}
}
