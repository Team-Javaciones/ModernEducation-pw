package pe.edu.upc.education.controllers;

import java.io.Serializable;
//import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.education.models.entities.Usuario;
import pe.edu.upc.education.services.UsuarioService;
@Named("passwordView")
@ViewScoped
public class PasswordView implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioService usuarioService;
	private Usuario usuario;
	//private Optional<Usuario> optional;
	
	@PostConstruct
	public void init()
	{
		cleanForm();
	}
	
	public void cleanForm()
	{
		this.usuario=new Usuario();
		
	}
	
	
	public void savePassword()
	{
		try {
			//this.optional =usuarioService.findById(1);
			//this.usuario = optional.getClass();
			this.usuario= usuarioService.findById(1).get();
			 usuarioService.update(usuario);
			cleanForm();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		this.addMessage("se creo la unidad satisfactoriamente");
	}
	
	public void addMessage(String summary)
	{
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	

}
