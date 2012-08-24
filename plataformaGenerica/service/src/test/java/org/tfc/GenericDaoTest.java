package org.tfc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import static org.tfc.utils.ConstantesTest.ESPACIONS_CONSTRUCTOR;
import static org.tfc.utils.ConstantesTest.ESPACIO_ATRIBUTO;
import static org.tfc.utils.ConstantesTest.ESPACIO_METODO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanInstantiationException;
import org.springframework.transaction.annotation.Transactional;
import org.tfc.dao.AbstractJpaDao;
import org.tfc.utils.ConstantesTest;
import org.tfc.utils.GenericUtils;
import org.tfc.utils.TfcMockUtils;

/**
 * 
 * Es el test de generic.
 * 
 * @author dbp
 * 
 * @param <T>
 * @param <ID>
 */
public abstract class GenericDaoTest<T extends EntityBD<ID>, ID extends Serializable>
		extends DaoTest {

	// Logger.
	private static final Logger logger = LoggerFactory
			.getLogger(GenericDaoTest.class);

	private AbstractJpaDao<T, ID> daoJpa;

	protected Class<T> entityClass;

	/**
	 * Es un flag que nos indica si queremos ejecutar el test por defecto para
	 * los dao genericos.
	 */
	private boolean activarTestPorDefecto = true;

	private int numeroElementosProcesarTest = 0;

	/**
	 * Con este constructor se deja la configuración por defecto. - La
	 * activación del test por defecto. - El entity class lo saca por defecto
	 * del 1º elemento de la definición de la clase.
	 */
	public GenericDaoTest() {
		this(true);
	}

	/**
	 * Configuramos la activación del test por defecto. - El entity class lo
	 * saca por defecto del 1º elemento de la definición de la clase.
	 * 
	 * @param paramActivarTestPorDefecto
	 *            Le indicamos si se tiene que ejecutar el test por defecto.
	 */
	public GenericDaoTest(boolean paramActivarTestPorDefecto) {
		this(paramActivarTestPorDefecto, null);
	}

	/**
	 * 
	 * Parametrizamos los elementos.
	 * 
	 * @param paramActivarTestPorDefecto
	 *            Le indicamos si se tiene que ejecutar el test por defecto.
	 * @param paramEntityClass
	 *            Le indicamos el class desde el hijo, si ponemos null coje el
	 *            class del 1º parametro definido en la clase.
	 */
	public GenericDaoTest(boolean paramActivarTestPorDefecto,
			Class<T> paramEntityClass) {
		this(paramActivarTestPorDefecto, paramEntityClass,
				ConstantesTest.PRUEBA_DAO_GENERIC_DECECTO);
	}

	/**
	 * 
	 * Parametrizamos los elementos.
	 * 
	 * @param paramActivarTestPorDefecto
	 *            Le indicamos si se tiene que ejecutar el test por defecto.
	 * @param paramEntityClass
	 *            Le indicamos el class desde el hijo, si ponemos null coje el
	 *            class del 1º parametro definido en la clase.
	 * @param paramNumeroElementosProcesarTest
	 *            El número de elementos que vamos a realizar con las pruebas.
	 */
	@SuppressWarnings("unchecked")
	public GenericDaoTest(boolean paramActivarTestPorDefecto,
			Class<T> paramEntityClass, int paramNumeroElementosProcesarTest) {
		this.activarTestPorDefecto = paramActivarTestPorDefecto;
		if (paramEntityClass == null) {
			entityClass = (Class<T>) GenericUtils
					.getPrimeroTypeParametroDeclaroOnSuperclass(getClass());
		} else {
			entityClass = paramEntityClass;
		}
		this.numeroElementosProcesarTest = paramNumeroElementosProcesarTest;
		debugGenericDaoTest();

	}

	/**
	 * Es el debug para el constructor.
	 */
	private void debugGenericDaoTest() {
		logger.debug("{}Constructor de la clase{}", ESPACIONS_CONSTRUCTOR,
				GenericDaoTest.class.getCanonicalName());
		logger.debug("{}Atributo:activarTestPorDefecto {}", ESPACIO_ATRIBUTO,
				activarTestPorDefecto);
		logger.debug("{}Atributo:entityClass {}", ESPACIO_ATRIBUTO,
				entityClass.getCanonicalName());
		logger.debug("{}Atributo:numeroElementosProcesarTest {}",
				ESPACIO_ATRIBUTO, numeroElementosProcesarTest);
	}

	@Test
	public void pruebaInsert() {
		System.out.println("Insertar");
	}



	 /**
     * TEST 000
     * 
     * 1º Comprueba que existe el dao.
     * 2º Procesamos el test basico.
     */
    @Test
    @Transactional()
    public void test000Basico() {
        assertNotNull("Comprobamos el dao", this.getDaoJpa());
        if(activarTestPorDefecto){
            procesarTestBasico();
        }
    }



    /**
     * 
     * Este test simplemente prueba todos los metodos de la interfaz generica.
     * 
     * @throws IllegalArgumentException
     * @throws BeanInstantiationException 
     */
    private void procesarTestBasico() throws IllegalArgumentException, BeanInstantiationException {
        logger.debug("{}Inicio metodo({})", ESPACIO_METODO,"procesarTestBasico");
        int elementos = daoJpa.findAll().size();
        int elementosIniciales=elementos;
        List<T> entidades=new ArrayList<T>();
        elementos = altaNregistros(entidades, elementos);
        eliminarNRegistros(entidades, elementos);
        assertEquals(elementosIniciales,daoJpa.findAll().size());
        logger.debug("{}Fin metodo({})", ESPACIO_METODO,"procesarTestBasico");
    }
    /**
     * 
     * Borramos los registros que nos proporcina el usuario.
     * 
     * @param entidades Es el listado de entidades que vamos a eliminar.
     * @param elementos Es el número de elementos con los que vamos a trabajar.
     */
    private void eliminarNRegistros(List<T> entidades, int elementos) {
        logger.debug("{}Antes de eliminar  los registros ({}) ", ESPACIO_METODO,elementos);
        // Borramos los registros correspondientes.
        for(T entityEliminar:entidades){
            eliminarEntidad(entityEliminar);
            elementos--;
            assertEquals(elementos,daoJpa.findAll().size());
        }
        logger.debug("{}Despues de eliminar  los registros ({}) ", ESPACIO_METODO,elementos);
    }
    /**
     * Se encarga de eliminar, una entidad.
     * 
     * @param entityEliminar Es la entidad que vamos a eliminar.
     */
    private void eliminarEntidad(T entityEliminar) {
        logger.debug("{}Antes eliminar el registro(id({}))", ESPACIO_ATRIBUTO,entityEliminar.getId());
        assertNotNull(daoJpa.findOne(entityEliminar.getId()));
        daoJpa.delete(entityEliminar);
        assertNull(daoJpa.findOne(entityEliminar.getId()));
        logger.debug("{}Despues eliminar el registro(id({}))", ESPACIO_ATRIBUTO,entityEliminar.getId());
    }
    
    /**
     * 
     * Se encarga de dar de alta ne registros.
     * 
     * @param entidades Listado donde vamos a guardar las entidades que vamos a dar de alta.
     * @param elementos Elementos que ya se habian dado de alta.
     * @return  Nos devuelve el numero de elementos que han sido insertados, mas los que ya tenia.
     * @throws IllegalArgumentException
     * @throws BeanInstantiationException 
     */
    private int altaNregistros(List<T> entidades, int elementos) throws IllegalArgumentException, BeanInstantiationException {
        logger.debug("{}Antes de dar de alta ne registros ", ESPACIO_METODO);
        for(Integer i=0;i<numeroElementosProcesarTest;i++){
            entidades.add(crearRegistro(i.toString()));
            elementos++;
            assertEquals(elementos,daoJpa.findAll().size());
        }
        logger.debug("{}Despues de dar de alta ({}) registros ", ESPACIO_METODO,elementos);
        return elementos;
    }
    
    /**
     * 
     * Se encarga de crear un registro de la entidad.
     * 
     * @param prefijo   Es el prefijo que le vamos a poner a los campos.
     * @return
     * @throws IllegalArgumentException
     * @throws BeanInstantiationException 
     */
    private T crearRegistro(String prefijo) throws IllegalArgumentException, BeanInstantiationException {
        logger.debug("{}Antes crear el registro prefijo({}) ", ESPACIO_ATRIBUTO,prefijo);
        T elemento = TfcMockUtils.entityMock(entityClass,prefijo);
        T elementoAlta = this.getDaoJpa().save(elemento);
        T elementoPersistidoAlta=this.getDaoJpa().findOne(elementoAlta.getId());
        TfcMockUtils.assertEntityMock(entityClass, prefijo, elementoPersistidoAlta);
        logger.debug("{}Despues crear el registro prefijo({}) ", ESPACIO_ATRIBUTO,prefijo);
        return elementoPersistidoAlta;
    }
	
	
	public AbstractJpaDao<T, ID> getDaoJpa() {
		return daoJpa;
	}

	public void setDaoJpa(AbstractJpaDao<T, ID> daoJpa) {
		this.daoJpa = daoJpa;
	}

}
