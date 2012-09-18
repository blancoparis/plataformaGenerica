package org.tfc.dao.impl;

import org.springframework.stereotype.Repository;
import org.tfc.bom.Menu;
import org.tfc.dao.MenuDao;

@Repository(value = "menuDao")
public class MenuDaoImpl extends AbstractJpaDaoImpl<Menu, Long> implements MenuDao{

}