package org.tfc.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.tfc.EntityBD;
import org.tfc.dao.AbstractJpaDao;
import org.tfc.exception.DbpException;
import org.tfc.service.AbstractService;
import org.tfc.utils.GenericUtils;

public class AbstractServiceImpl <T extends EntityBD<ID>, ID extends Serializable>
implements AbstractService<T,ID>{
	
	private Class<T> clazzT;
	private Class<ID> clazzID;
	
	public AbstractJpaDao<T,ID> dao;

	public AbstractServiceImpl(AbstractJpaDao<T, ID> dao) {
		super();
		clazzT = (Class<T>) GenericUtils
				.getPrimeroTypeParametroDeclaroOnSuperclass(this.getClass());
		this.dao = dao;
	}
	@Transactional(readOnly=true)
	public T findOne(final ID id) throws DbpException{
		return dao.findOne( id);
	}
	@Transactional(readOnly=true)
	public List<T> findAll() throws DbpException{
		return dao.findAll();
	}
	@Transactional
	public T save(final T entity) throws DbpException{
		return dao.save(entity);
	}
	@Transactional
	public T update(final T entity) throws DbpException{
		return dao.update(entity);
	}
	@Transactional
	public void delete(final T entity) throws DbpException{
		dao.delete(entity);
	}
	@Transactional
	public void deleteById(final ID entityId) throws DbpException{
		dao.deleteById(entityId);
	}	
    
	
}
