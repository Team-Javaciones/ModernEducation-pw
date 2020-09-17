package pe.edu.upc.education.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.education.models.entities.Usuario;
import pe.edu.upc.education.models.services.UsuarioService;

@Named("usuarioView")
@ViewScoped
public class UsuarioView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioService usuarioService;
	
	private List<Usuario> usuarios;

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	@PostConstruct
	public void init() {
		this.loadUsuarios();
	}	
	
	public void loadUsuarios() {
		try {
			this.setUsuarios(usuarioService.findAll());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
	}

}
