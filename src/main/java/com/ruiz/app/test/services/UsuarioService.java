package com.ruiz.app.test.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ruiz.app.test.dao.UsuarioDao;
import com.ruiz.app.test.models.Usuario;

@Component
public class UsuarioService implements IService<Usuario>{

	@Autowired
	private UsuarioDao usuarioDao;
	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		List<Usuario> u = new ArrayList<Usuario>();
		u = (List<Usuario>)usuarioDao.findAll();
		return u;
	}

	@Override
	public Optional<Usuario> getById(Long id) {
		Optional<Usuario> u = usuarioDao.findById(id);
		return u;
	}

	@Override
	public void guardar(Usuario t) {
		// TODO Auto-generated method stub
		this.usuarioDao.save(t);
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		this.usuarioDao.deleteById(id);
	}
	
}
