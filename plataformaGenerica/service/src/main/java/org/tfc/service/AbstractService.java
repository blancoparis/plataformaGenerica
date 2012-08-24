package org.tfc.service;

import java.io.Serializable;
import java.util.List;

import org.tfc.EntityBD;

public interface AbstractService <T extends EntityBD<ID>, ID extends Serializable>{
	  public T findOne(  ID id );
	  public List< T > findAll();
	  public T save(  T entity );
	  public T update(  T entity );
	  public void delete(  T entity );
	  public void deleteById(  ID entityId );

}
