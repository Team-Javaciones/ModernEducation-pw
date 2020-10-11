package pe.edu.upc.education.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.education.models.entities.Alumno;
import pe.edu.upc.education.services.AlumnoService;
@Named("iniciarSesionView")
@ViewScoped
public class IniciarSesionView implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AlumnoService alumnoService;
	private Alumno alumno;
	
	@PostConstruct
	public void init()
	{
		cleanForm();
	}
	
	public void cleanForm()
	{
		this.alumno=new Alumno();
		
	}
	
	public void comprobarCuenta()
	{
		try {
		if(!this.alumno.getCorreo().isEmpty() && !this.alumno.getPassword().isEmpty() && !this.alumno.getPassword().isEmpty())
			
			//this.alumno= alumnoService.findById(1).get();
			
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

	public AlumnoService getAlumnoService() {
		return alumnoService;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	
	
}
