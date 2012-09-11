package org.tfc.parser;

import org.springframework.stereotype.Repository;
import org.tfc.bom.Prueba;
import org.tfc.form.PruebaBuscadorForm;
import org.tfc.form.subs.TablaPruebaBuscadorSubForm;
/**
 * 
 * @author David Blanco París
 *
 */
@Repository(value = "pruebaBuscadorParser")
public class PruebaBuscadorParser extends AbstracBuscadorParser<Long,Prueba,PruebaBuscadorForm,TablaPruebaBuscadorSubForm>{

}
