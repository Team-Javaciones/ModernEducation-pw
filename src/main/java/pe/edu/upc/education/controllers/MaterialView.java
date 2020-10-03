package pe.edu.upc.education.controllers;


import java.io.Serializable;


import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.education.models.entities.Material;
import pe.edu.upc.education.models.services.MaterialService;

@Named("materialView")
@ViewScoped
public class MaterialView implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private MaterialService materialService;
	
	private Material material;

	@PostConstruct
	public void init() {	
		this.cleanForm();
	}
	
	public void cleanForm() {
		this.material = new Material();
	}
	
	public void newMaterial() {
		try {
			materialService.save(this.material);
			cleanForm();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		this.addMessage("Se creó el material satisfactoriamente");
	}
	
	public void addMessage(String summary) {		
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }	
	
	public Material getMaterial() {
		return material;
	}

	public MaterialService getSesionService() {
		return materialService;
	}
}