package pe.edu.upc.education.controllers;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.education.models.entities.Solucion;
import pe.edu.upc.education.services.SolucionService;

@Named("solucionView")
@ViewScoped
public class SolucionView implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private SolucionService solucionService;
	
	private Solucion solucion;

	@PostConstruct
	public void init() {
		this.cleanForm();
	}

	public void cleanForm() {
		this.solucion = new Solucion();
	}
	
	public void newSolucion() {
		try {
			Date fechaActual = new Date();
			this.solucion.setFecha(fechaActual);
			solucionService.save(this.solucion);
			cleanForm();
			this.addMessage("Se envió la solución correctamente");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}		
	}
	
	public void addMessage(String summary) {		
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }	
	
	public SolucionService getSolucionService() {
		return solucionService;
	}

	public Solucion getSolucion() {
		return solucion;
	}
	
	
}
