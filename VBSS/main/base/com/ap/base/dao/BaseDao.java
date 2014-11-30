/**
 * 
 */
package com.ap.base.dao;

import java.util.Collection;
import java.util.Iterator;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.stat.Statistics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * hibernate Dao操作的基类
 * 
 * @author sunqx
 *
 */
public  class BaseDao {
	
	protected  static Logger log =LoggerFactory.getLogger(BaseDao.class);
	
	protected SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	protected Session  getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	
    
    
    /**
     * 创建Query对象
     * 
     * @param hsql
     * @return
     */
    public Query query(String hsql){
    	
    	return this.getSession().createQuery(hsql);
    }
    
    /**the results are returned in
	 * an instance of <tt>Object[]</tt>
	 * 
	 * 根据iterate查询方法的执行方式，其每次都会到数据库中查询满足条件的id值，
	 * 然后再根据此id 到缓存中获取数据，当缓存中没有此id的数据才会执行数据库查询；
	 * 
	 * 如果此记录已被sql直接删除，则iterate在执行id查询时不会将此id查询出来。
	 * 
	 */
    public Iterator<?> iterator(String hsql){
    	
    	return this.getSession().createQuery(hsql).iterate();
    }
    
    
    public SQLQuery queryBySQl(String sqlstr){
    	
    	return this.getSession().createSQLQuery(sqlstr);
    }
    
    
    /**
     * 使用案例：
     * List list=session.createCriteria(MeterUser.class)
     * .add(Restrictions.eq("name", "11"))
     * .addOrder(Order.desc("userid")).list();
     * 
     * @param <T>
     * @param persistentClass
     * @return
     */
    public Criteria queryByCriteria (String  entityName){
    	return this.getSession().createCriteria(entityName);
    }
    
    /**
     * 
     * 查询对象之间的关系
     * 一对多
     * 一对一
     * 例如：
     * Query q = session.createFilter(team.getStudents(),"where this.age>?").setParameter(1,new Integer(22))
     * 
     * Team和Student之间是一对多的双向关联关系,一个班级有好多学生，一个学生属于一个班级，双方都持有对方的引用
     * 
     * @param <T>
     * @param belongobjSet
     * @param hqlstr
     * @return
     */
    public <T extends Collection<?>> Query  queryBySQl(T belongobjSet,String hqlstr){
    	return this.getSession().createFilter(belongobjSet, hqlstr);
    }
   
	
    
    public <T> T find(){
    	throw new UnsupportedOperationException("session无find方法。");
    }
    
	
	public ProcedureCall callProcedure(String proName){
		ProcedureCall callPro = this.getSession().createStoredProcedureCall(proName);
		//callPro.registerParameter(position, type, mode);
		return callPro;
	}
	
	/**
	 * 获取hibernate中二级缓存中的统计
	 * 
	 * @return
	 */
	protected  Statistics staatics() {
		 return this.sessionFactory.getStatistics();
	}
	
	
	

}
