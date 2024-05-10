package com.ruiz.app.test.dao;

import org.springframework.data.repository.CrudRepository;

import com.ruiz.app.test.models.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario, Long>{

}
