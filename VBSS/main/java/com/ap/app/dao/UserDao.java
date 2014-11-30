/**
 * 
 */
package com.ap.app.dao;


/**
 * @author Administrator
 *
 */
public interface UserDao<V>  {
 
	
	public void adddData(V v) throws Exception;
	
	public void removeData(V v) throws Exception;
	
	public void updateData(V v) throws Exception;
	
	public V getData(Long id) throws Exception;
	
	
}
