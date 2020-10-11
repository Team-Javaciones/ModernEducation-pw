package pe.edu.upc.education.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import pe.edu.upc.education.models.entities.Usuario;
import pe.edu.upc.education.services.UsuarioService;
@Named("iniciarSesionView")
@ViewScoped
public class IniciarSesionView implements Serializable {

	private static final long serialVersionUID = 1L;

	private UsuarioService usuarioService;
	private Usuario usuario;
	
	@PostConstruct
	public void init()
	{
		cleanForm();
	}
	
	public void cleanForm()
	{
		this.usuario=new Usuario();
		
	}
	
	public void comprobarCuenta()
	{
		try {
		if(!this.usuario.getCorreo().isEmpty() && !this.usuario.getPassword().isEmpty() && !this.usuario.getPassword().isEmpty())
			
			//this.usuario= usuarioService.findById(1).get();
			
			this.addMessage("bienvienido otra vez :D");
			 
			cleanForm();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
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
