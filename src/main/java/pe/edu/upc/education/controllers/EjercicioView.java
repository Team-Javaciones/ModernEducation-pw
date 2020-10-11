
package pe.edu.upc.education.controllers;


import java.io.Serializable;



import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.education.models.entities.Ejercicio;
import pe.edu.upc.education.services.EjercicioService;

@Named("ejercicioView")
@ViewScoped
public class EjercicioView implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EjercicioService ejercicioService;
	
	
	private Ejercicio ejercicio;		
	

	
	
	public void cleanForm() {
		this.ejercicio = new Ejercicio();
	}
	
	public void newEjercicio() {
		try {
			ejercicioService.save(this.ejercicio);
			cleanForm();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		this.addMessage("Se creó el ejercicio satisfactoriamente");
	}
	

	
	public void addMessage(String summary) {		
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }	
	
	public Ejercicio getEjercicio() {
		return ejercicio;
	}

	public EjercicioService getEjercicioService() {
		return ejercicioService;
	}

	

}
