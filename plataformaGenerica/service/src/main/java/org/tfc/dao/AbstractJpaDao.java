package org.tfc.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import org.tfc.EntityBD;
/**
 * Intefaz donde definimos las operaciones basicas para el tema de los dao
 * @author dbp
 *
 * @param <T>
 * @param <ID>
 */
public interface AbstractJpaDao <T extends EntityBD<ID>, ID extends Serializable>{
	  public T findOne(  ID id );
	  public List< T > findAll();
	  public T save(  T entity );
	  public T update(  T entity );
	  public void delete(  T entity );
	  public void deleteById(  ID entityId );
	  public EntityManager getEntityManager();
	  // Datos importantes.
	 /* public EntityManager getEntityManager();
	  public Class<T> getClazzT(); 
	  public void setClazzT(Class<T> clazzT); 
	  public Class<ID> getClazzID(); 
	  public void setClazzID(Class<ID> clazzID); 
*/
}
