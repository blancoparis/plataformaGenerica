package org.tfc.form;

import java.io.Serializable;
import java.util.List;

import org.tfc.form.enumerados.TipoOperacionResultado;
import org.tfc.form.subs.ErroresNegocioSubForm;
/**
 * 
 * Es donde definimos los campos que van a utilizar todos las funcionalidades</br>
 * <ul>
 * 		<li><b>Errores de negocio</b>: Estructura de datos donde guardaremos los mensajes de error</li>
 * 		<li><b>Tipo operacion</b>: Donde le indicaremos si la operación se ha realizado correctamente.</li>
 * </ul>
 * 
 * @author David Blanco París
 *
 */
@SuppressWarnings("serial")
public class BaseForm implements Serializable{

	private List<ErroresNegocioSubForm> erroresNegocio;

	private TipoOperacionResultado tipoOperacion;
	
	private String textoTipoOperacion;
	
	private String mensajeTipoOperacion;
	
	public List<ErroresNegocioSubForm> getErroresNegocio() {
		return erroresNegocio;
	}

	public void setErroresNegocio(List<ErroresNegocioSubForm> erroresNegocio) {
		this.erroresNegocio = erroresNegocio;
	}

	public TipoOperacionResultado getTipoOperacion() {
		return tipoOperacion;
	}

	public void setTipoOperacion(TipoOperacionResultado tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	public String getTextoTipoOperacion() {
		return textoTipoOperacion;
	}

	public void setTextoTipoOperacion(String textoTipoOperación) {
		this.textoTipoOperacion = textoTipoOperación;
	}

	public String getMensajeTipoOperacion() {
		return mensajeTipoOperacion;
	}

	public void setMensajeTipoOperacion(String mensajeTipoOperacion) {
		this.mensajeTipoOperacion = mensajeTipoOperacion;
	}
	
	
	
	
}
