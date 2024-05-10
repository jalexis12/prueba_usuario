package com.ruiz.app.test.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ruiz.app.test.models.Usuario;
import com.ruiz.app.test.services.IService;



@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	@Autowired
	IService<Usuario> usuarioService;
	
	@PostMapping
	public Map<String, String> guardar(@RequestBody Usuario u){
		usuarioService.guardar(u);
		Map<String, String> respuesta = new HashMap<String, String>();
		respuesta.put("msg", "Usuario guardado correctamente");
		return respuesta;
	}
	
	@GetMapping
	public List<Usuario> listar(){
		return usuarioService.listar();
		}
	
	@GetMapping("/obtener/{id}")
	public Usuario obtenerPorId(@PathVariable (name = "id") Long id) {
		Optional<Usuario> usu= usuarioService.getById(id);
		if(usu.isPresent()) {
			return usu.get();
		}
		else {
			return null;
		}
	}
	
	@DeleteMapping("/eliminar")
	public Map<String, String> eliminar(@RequestParam(name = "id") Long id){
		usuarioService.eliminar(id);
		Map<String,String> respuesta=new HashMap<>();
		respuesta.put("msg", "usuario eliminado correctamente");
		return respuesta;
	}
	
	@PutMapping("/actualizar/{id}")
	public Map<String,String> actualizar(@RequestBody Usuario c, @PathVariable(name= "id")Long id){
		Optional<Usuario> usu=usuarioService.getById(id);
		if(usu.isPresent()) {
			c.setId(id);
			usuarioService.guardar(c);
		}else {
			throw new RuntimeException("El usuario no existe en la base de datos");
		}
		Map<String, String> respuesta= new HashMap<>();
		respuesta.put("msg", "usuario actualizado correctamente");
		return respuesta;
	}
}
