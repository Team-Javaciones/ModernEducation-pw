package pe.edu.upc.education.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.education.models.entities.Alumno;
import pe.edu.upc.education.services.AlumnoService;
@Named("editarPerfilView")
@ViewScoped
public class EditarPerfilView implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private AlumnoService alumnoService;
	
	private Alumno alumno;
	List<Alumno> alumnos;
	
	@PostConstruct
	public void init()
	{
		cleanForm();
	}
	
	
	public void cleanForm()
	{
		this.alumno=new Alumno();
		
	}
	
	public void actualizarPerfil()
	{
		try {
			this.alumnos=alumnoService.findAll();
			if(alumno.getId()==1 )
			{
				alumnoService.update(alumno);
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


	public Alumno getAlumno() {
		return alumno;
	}


	public List<Alumno> getAlumnos() {
		return alumnos;
	}

}
