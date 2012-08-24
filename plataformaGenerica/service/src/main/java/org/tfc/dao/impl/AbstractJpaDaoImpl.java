package org.tfc.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.tfc.EntityBD;
import org.tfc.dao.AbstractJpaDao;
import org.tfc.utils.GenericUtils;

/**
 * Es la clase abstracta centraliza las operaciones basica que vamos a realizar
 * sobre cualquier entidad de la capa de persistencia.
 * 
 * @author dbp
 * 
 * @param <T>
 *            La definicion de la clase de la entidad.
 * @param <ID>
 * 			  La definición de la clase que vamos a utilizar como indice.
 */
public abstract class AbstractJpaDaoImpl<T extends EntityBD<ID>, ID extends Serializable>
		implements AbstractJpaDao<T, ID> {

	private Class<T> clazzT;
	private Class<ID> clazzID;

	@PersistenceContext
	EntityManager entityManager;

	public AbstractJpaDaoImpl() {
		super();
		clazzT = (Class<T>) GenericUtils
				.getPrimeroTypeParametroDeclaroOnSuperclass(this.getClass());
	}

	public T findOne(final ID id) {
		return entityManager.find(clazzT, id);
	}

	public List<T> findAll() {
		return entityManager.createQuery("from " + clazzT.getName())
				.getResultList();
	}

	public T save(final T entity) {
		entityManager.persist(entity);
		return entity;
	}

	public T update(final T entity) {
		entityManager.merge(entity);
		return entity;
	}

	public void delete(final T entity) {
		entityManager.remove(entity);
	}

	public void deleteById(final ID entityId) {
		final T entity = findOne(entityId);

		delete(entity);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public Class<T> getClazzT() {
		return clazzT;
	}

	public void setClazzT(Class<T> clazzT) {
		this.clazzT = clazzT;
	}

	public Class<ID> getClazzID() {
		return clazzID;
	}

	public void setClazzID(Class<ID> clazzID) {
		this.clazzID = clazzID;
	}

}
