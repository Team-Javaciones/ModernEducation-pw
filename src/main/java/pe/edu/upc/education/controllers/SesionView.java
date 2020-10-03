package pe.edu.upc.education.controllers;


import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.education.models.entities.Sesion;
import pe.edu.upc.education.models.services.SesionService;

@Named("sesionView")
@ViewScoped
public class SesionView implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private SesionService sesionService;
	
	private Sesion sesion;		

	@PostConstruct
	public void init() {	
		this.cleanForm();		
	}
	
	public void cleanForm() {
		this.sesion = new Sesion();
	}
	
	public void newSesion() {
		try {
			sesionService.save(this.sesion);
			cleanForm();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		this.addMessage("Se creó la sesión satisfactoriamente");
	}
	
	public void addMessage(String summary) {		
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }	
	
	public Sesion getSesion() {
		return sesion;
	}

	public SesionService getSesionService() {
		return sesionService;
	}
}
