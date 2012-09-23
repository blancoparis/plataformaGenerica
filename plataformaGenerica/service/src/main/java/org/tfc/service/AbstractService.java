package org.tfc.service;

import java.io.Serializable;
import java.util.List;

import org.tfc.EntityBD;
import org.tfc.exception.DbpException;

public interface AbstractService <T extends EntityBD<ID>, ID extends Serializable>{
	  public T findOne(  ID id ) throws DbpException;
	  public List< T > findAll() throws DbpException;
	  public T save(  T entity ) throws DbpException;
	  public T update(  T entity ) throws DbpException;
	  public void delete(  T entity ) throws DbpException;
	  public void deleteById(  ID entityId ) throws DbpException;

}
