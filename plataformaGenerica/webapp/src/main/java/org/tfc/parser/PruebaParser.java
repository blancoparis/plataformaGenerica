package org.tfc.parser;

import org.springframework.stereotype.Repository;
import org.tfc.bom.Prueba;
import org.tfc.form.PruebaForm;
@Repository(value = "pruebaParser")
public class PruebaParser extends AbstractParser<PruebaForm,Long,Prueba>{

}
