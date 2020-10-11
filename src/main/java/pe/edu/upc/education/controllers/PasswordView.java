package pe.edu.upc.education.controllers;

import java.io.Serializable;
//import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.education.models.entities.Alumno;
import pe.edu.upc.education.services.AlumnoService;
@Named("passwordView")
@ViewScoped
public class PasswordView implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private AlumnoService alumnoService;
	private Alumno alumno;
	//private Optional<Alumno> optional;
	
	@PostConstruct
	public void init()
	{
		cleanForm();
	}
	
	public void cleanForm()
	{
		this.alumno=new Alumno();
		
	}
	
	
	public void savePassword()
	{
		try {
			//this.optional =alumnoService.findById(1);
			//this.alumno = optional.getClass();
			this.alumno= alumnoService.findById(1).get();
			 alumnoService.update(alumno);
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

	public AlumnoService getAlumnoService() {
		return alumnoService;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	

}
