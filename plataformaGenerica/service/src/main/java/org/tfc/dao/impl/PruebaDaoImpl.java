package org.tfc.dao.impl;

import org.springframework.stereotype.Repository;
import org.tfc.bom.Prueba;
import org.tfc.dao.PruebaDao;

@Repository(value = "pruebaDao")
public class PruebaDaoImpl extends AbstractJpaDaoImpl<Prueba, Long> implements PruebaDao{

}