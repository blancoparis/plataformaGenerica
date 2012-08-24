package org.tfc.dao.impl;

import org.springframework.stereotype.Repository;
import org.tfc.bom.Usuario;
import org.tfc.dao.UsuarioDao;

@Repository(value = "usuarioDao")
public class UsuarioDaoImpl extends AbstractJpaDaoImpl<Usuario, Long> implements UsuarioDao{

}