/**
 * 
 */
package com.ap.base.dao;


import java.lang.reflect.ParameterizedType;

import org.hibernate.Criteria;
import org.hibernate.LockOptions;

/**
 * 
 * 使用泛型实现的hibernate的DAO处理
 * 
 * @author sunqx
 *
 */
public abstract class CommonDaoOSupport<T> extends BaseDao {

	protected Class<T> entityClass;
	
	@SuppressWarnings("unchecked")
	public CommonDaoOSupport() {
		entityClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		//log.info("类型参数的真实类型："+entityClass);
	}
	
	
	/**
	 * 如果使用JPA规范就用persist，
	 * 如果使用hibernate就用save
	 * 这里只提供save方法
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
     * 悲观锁是很少被使用的，因为它大大限制了并发性，并且利用数据库底层来维护锁，这样大大降低了应用程序的效率。
     * 下面我们来看一下hibernateAPI中提供的get方法：
     * Get（Classclazz，Serializable id，LockMode lockMode）
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
     * 使用案例：
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
