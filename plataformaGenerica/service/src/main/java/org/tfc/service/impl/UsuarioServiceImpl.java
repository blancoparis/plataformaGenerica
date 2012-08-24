package org.tfc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.tfc.bom.Usuario;
import org.tfc.dao.UsuarioDao;
import org.tfc.service.UsuarioService;

@Repository(value = "usuarioService")
public class UsuarioServiceImpl 
	extends AbstractServiceImpl<Usuario, Long>
	implements UsuarioService{

	private UsuarioDao dao;
	@Autowired
	private UsuarioServiceImpl( UsuarioDao  dao) {
		super(dao);
		this.dao=dao;
	}
}