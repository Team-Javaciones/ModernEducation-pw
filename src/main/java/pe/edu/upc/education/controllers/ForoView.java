package pe.edu.upc.education.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import pe.edu.upc.education.models.entities.Foro;
import pe.edu.upc.education.models.services.ForoService;
@Named("foroView")
@ViewScoped
public class ForoView implements Serializable {


	private static final long serialVersionUID = 1L;

	
	private ForoService foroService;
	private Foro foro;
	private List<Foro> foros;
	
	
	@PostConstruct
	public void init() {
		this.cleanForm();
		this.loadForo();
		
	}
	
	public void cleanForm()
	{
		this.foro=new Foro();
	}
	
	public void loadForo()
	{
		try {
			this.foros = foroService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public ForoService getForoService() {
		return foroService;
	}

	public Foro getForo() {
		return foro;
	}

	public List<Foro> getForos() {
		return foros;
	}

}
