package pe.edu.upc.education.controllers;

import java.io.Serializable;


import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;


import pe.edu.upc.education.models.entities.Unidad;

import pe.edu.upc.education.models.services.UnidadService;
@Named("unidadView")
@ViewScoped
public class UnidadView implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	@Inject
	private UnidadService unidadService;	
	private Unidad unidad;
	
	
	

	
	@PostConstruct
	public void init()
	{
		cleanForm();
	}
	
	
	public void cleanForm()
	{
		this.unidad=new Unidad();
		
	}


	public void saveUnidad()
	{
		try {
			unidadService.save(this.unidad);
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

	
	public UnidadService getUnidadService() {
		return unidadService;
	}

	public Unidad getUnidad() {
		return unidad;
	}
	
	

}