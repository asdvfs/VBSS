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
 * hibernate Dao�����Ļ���
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
     * ����Query����
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
	 * ����iterate��ѯ������ִ�з�ʽ����ÿ�ζ��ᵽ���ݿ��в�ѯ����������idֵ��
	 * Ȼ���ٸ��ݴ�id �������л�ȡ���ݣ���������û�д�id�����ݲŻ�ִ�����ݿ��ѯ��
	 * 
	 * ����˼�¼�ѱ�sqlֱ��ɾ������iterate��ִ��id��ѯʱ���Ὣ��id��ѯ������
	 * 
	 */
    public Iterator<?> iterator(String hsql){
    	
    	return this.getSession().createQuery(hsql).iterate();
    }
    
    
    public SQLQuery queryBySQl(String sqlstr){
    	
    	return this.getSession().createSQLQuery(sqlstr);
    }
    
    
    /**
     * ʹ�ð�����
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
     * ��ѯ����֮��Ĺ�ϵ
     * һ�Զ�
     * һ��һ
     * ���磺
     * Query q = session.createFilter(team.getStudents(),"where this.age>?").setParameter(1,new Integer(22))
     * 
     * Team��Student֮����һ�Զ��˫�������ϵ,һ���༶�кö�ѧ����һ��ѧ������һ���༶��˫�������жԷ�������
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
    	throw new UnsupportedOperationException("session��find������");
    }
    
	
	public ProcedureCall callProcedure(String proName){
		ProcedureCall callPro = this.getSession().createStoredProcedureCall(proName);
		//callPro.registerParameter(position, type, mode);
		return callPro;
	}
	
	/**
	 * ��ȡhibernate�ж��������е�ͳ��
	 * 
	 * @return
	 */
	protected  Statistics staatics() {
		 return this.sessionFactory.getStatistics();
	}
	
	
	

}
