package pe.edu.upc.education.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.education.models.entities.Usuario;
import pe.edu.upc.education.models.services.UsuarioService;
@Named("editarPerfilView")
@ViewScoped
public class EditarPerfilView implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioService usuarioService;
	
	private Usuario usuario;
	List<Usuario> usuarios;
	
	@PostConstruct
	public void init()
	{
		cleanForm();
	}
	
	
	public void cleanForm()
	{
		this.usuario=new Usuario();
		
	}
	
	public void actualizarPerfil()
	{
		try {
			this.usuarios=usuarioService.findAll();
			if(usuario.getId()==1 )
			{
				usuarioService.update(usuario);
				cleanForm();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		this.addMessage("se actualizo su perfil satisfactoriamente");
	}
	
	public void addMessage(String summary)
	{
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public List<Usuario> getUsuarios() {
		return usuarios;
	}

}
