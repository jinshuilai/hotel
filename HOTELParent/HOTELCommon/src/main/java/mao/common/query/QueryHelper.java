package mao.common.query;

import java.util.ArrayList;
import java.util.List;

/**
 * 辅助拼接hql语句
 * @author mao
 *
 */
public class QueryHelper {

	private String fromClause;
	private String whereClause = "";
	private String orderByClause = "";
	private List<Object> parameters = new ArrayList<Object>();
	
	/**
	 * 查询哪个类
	 * @param clazz 类
	 * @param alias 别名
	 */
	public QueryHelper(Class clazz,String alias) {
		fromClause = "FROM " + clazz.getSimpleName() +" "+ alias;
	}
	

	/**
	 * 拼接where
	 * @param condition
	 * @param params
	 */
	public QueryHelper addCondition(String condition,Object... params) {
		if (whereClause.length() == 0) {
			whereClause = " WHERE " + condition;			
		}else{
			whereClause += " AND " + condition;
		}
		if (params != null) {
			for (Object object : params) {
				parameters.add(object);
			}
		}
		return this;
	}
	
	public QueryHelper addCondition(boolean append,String condition,Object... params) {
		if (append) {
			addCondition(condition, params);
		}
		return this;
	}

	/**
	 * 拼接orderBy
	 * @param propertyName
	 * @param asc true:up
	 */
	public QueryHelper addOrderProperty(String propertyName,boolean asc) {
		if (orderByClause.length() == 0) {
			orderByClause = " ORDER BY " + propertyName + (asc ? " ASC" : " DESC"); 
		}else{
			orderByClause += ", " + propertyName + (asc ? " ASC" : " DESC");
		}
		return this;
	}
	
	public QueryHelper addOrderProperty(boolean append,String propertyName,boolean asc) {
		if (append) {
			addOrderProperty(propertyName, asc);
		}
		return this;
	}
	
	/**
	 * 获取hql语句
	 * @return
	 */
	public String getQueryHql() {
		return fromClause + whereClause + orderByClause;
	}
	
	/**
	 * 获取记录数的hql语句
	 * @return
	 */
	public String getCountQueryHql() {
		return "SELECT COUNT(*) " + fromClause + whereClause;
	}
	
	/**
	 * 获取hql的参数
	 * @return
	 */
	public List<Object> getParameters() {
		return parameters;
	}
}