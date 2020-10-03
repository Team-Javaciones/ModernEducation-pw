package pe.edu.upc.education.controllers;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.education.models.entities.Material;
import pe.edu.upc.education.models.entities.Sesion;
import pe.edu.upc.education.models.services.MaterialService;
import pe.edu.upc.education.models.services.SesionService;

@Named("sesionView")
@ViewScoped
public class SesionView implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private SesionService sesionService;
	@Inject
	private MaterialService materialService;
	
	private Sesion sesion;		
	private List<Material> materiales;

	@PostConstruct
	public void init() {	
		this.cleanForm();	
		this.loadMateriales();
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
	
	public void loadMateriales() {
		try {
			this.materiales = materialService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
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

	public MaterialService getMaterialService() {
		return materialService;
	}

	public List<Material> getMateriales() {
		return materiales;
	}
	
}
