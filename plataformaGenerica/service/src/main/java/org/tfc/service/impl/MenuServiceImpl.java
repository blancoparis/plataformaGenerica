package org.tfc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.tfc.bom.Menu;
import org.tfc.dao.MenuDao;
import org.tfc.service.MenuService;

@Repository(value = "menuService")
public class MenuServiceImpl 
	extends AbstractServiceImpl<Menu, Long>
	implements MenuService{

	private MenuDao dao;
	@Autowired
	private MenuServiceImpl( MenuDao  dao) {
		super(dao);
		this.dao=dao;
	}
}