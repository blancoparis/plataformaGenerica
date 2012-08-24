package org.tfc.bom;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.BeforeClass;
/**
 * 
 * Aqui creamos el mock, para crear un entitymanager 
 * 
 * @author dbp
 *
 */
public class BomTestGeneric {
	
	static EntityManagerFactory emf = null; 
	
	
	
	/**
	 * Montamos el data source para JTA.
	 * @throws SQLException
	 * @throws NamingException
	 * @throws IOException 
	 */
	@BeforeClass 
	public static void setupForm() throws SQLException, NamingException, IOException{
		BasicDataSource ds = new BasicDataSource();
		Properties pro= new Properties();
		InputStream resourceAsStream = PersistenceTest.class.getClassLoader().getResourceAsStream ("hibernate.properties");
		pro.load(resourceAsStream);
		ds.setDriverClassName(pro.getProperty("connection.driver_class"));
		ds.setUsername(pro.getProperty("connection.username"));
		ds.setPassword(pro.getProperty("connection.password"));
		ds.setUrl(pro.getProperty("connection.url"));
	    System.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.osjava.sj.memory.MemoryContextFactory"); 
	    System.setProperty("org.osjava.sj.jndi.shared", "true"); 
	    Context ic =  new InitialContext(); 
	    ic.bind("/tfc/ds", ds);
	    emf= Persistence.createEntityManagerFactory("sample");
	}
}
