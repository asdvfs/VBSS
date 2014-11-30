/**
 * 
 */
package com.ap.base.dao;


import java.lang.reflect.ParameterizedType;

import org.hibernate.Criteria;
import org.hibernate.LockOptions;

/**
 * 
 * ʹ�÷���ʵ�ֵ�hibernate��DAO����
 * 
 * @author sunqx
 *
 */
public abstract class CommonDaoOSupport<T> extends BaseDao {

	protected Class<T> entityClass;
	
	@SuppressWarnings("unchecked")
	public CommonDaoOSupport() {
		entityClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		//log.info("���Ͳ�������ʵ���ͣ�"+entityClass);
	}
	
	
	/**
	 * ���ʹ��JPA�淶����persist��
	 * ���ʹ��hibernate����save
	 * ����ֻ�ṩsave����
	 * @param <T>
	 * @param v
	 */
	public  void save(T v){
		
		this.getSession().save(v);
	}
	
   
	public   void saveOrUpdate(T v){
		
		this.getSession().saveOrUpdate(v);
	}
	
    public   void Update(T v){
		
		this.getSession().update(v);
	}
    
    public   void delete(T v){
		
		this.getSession().delete(v);
	}
    
    /**
     * 
     * @param <T>
     * @param v
     * @param id
     * @return
     */
    @SuppressWarnings("unchecked")
	public  T load (Class<T> v, Long id){
		return (T)this.getSession().load(v, id);
	}
    
    /**
     * 
     * �������Ǻ��ٱ�ʹ�õģ���Ϊ����������˲����ԣ������������ݿ�ײ���ά������������󽵵���Ӧ�ó����Ч�ʡ�
     * ������������һ��hibernateAPI���ṩ��get������
     * Get��Classclazz��Serializable id��LockMode lockMode��
     * @param <T>
     * @param v
     * @param id
     * @return
     */
    @SuppressWarnings("unchecked")
	public  T load (Class<T> v, Long id,LockOptions lock){
		return (T)this.getSession().load(v, id, lock);
	}
    
    /**
     * 
     * @param <T>
     * @param v
     * @param id
     * @return
     */
    @SuppressWarnings("unchecked")
	public  T get (Class<T> v, Long id){
		return (T)this.getSession().get(v, id);
	}
    
    /**
     * 
     * @param <T>
     * @param v
     * @param id
     * @return
     */
    @SuppressWarnings("unchecked")
	public  T get (String entityName, Long id){
		return (T)this.getSession().get(entityName, id);
	}
    
    /**
     * 
     * @param <T>
     * @param v
     * @param id
     * @return
     */
    @SuppressWarnings("unchecked")
	public  T get (Class<T> v, Long id, LockOptions lock){
		return (T)this.getSession().get(v, id, lock);
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
    public  Criteria queryByCriteria (Class<T> persistentClass){
    	
    	return this.getSession().createCriteria(persistentClass);
    }
    
	
	
}
