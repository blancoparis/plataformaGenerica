package org.tfc.dao.impl;

import org.springframework.stereotype.Repository;
import org.tfc.bom.Flujo;
import org.tfc.dao.FlujoDao;

@Repository(value = "flujoDao")
public class FlujoDaoImpl extends AbstractComboJpaDaoImpl<Flujo, Long> implements FlujoDao{

}