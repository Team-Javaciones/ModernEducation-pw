package pe.edu.upc.education.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.education.models.entities.Categoria;
import pe.edu.upc.education.services.CategoriaService;

@Named("categoriaView")
@ViewScoped
public class CategoriaView implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CategoriaService categoriaService;
	
	private Categoria categoria;
	
	
	public void cleanForm()
	{
		this.categoria=new Categoria();
	}
	
	@PostConstruct
	public void init()
	{
		cleanForm();
		
	}
	
	
	public void saveCategoria()
	{
		try {
			categoriaService.save(this.categoria);
			cleanForm();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public CategoriaService getCategoriaService() {
		return categoriaService;
	}

	public Categoria getCategoria() {
		return categoria;
	}


}
