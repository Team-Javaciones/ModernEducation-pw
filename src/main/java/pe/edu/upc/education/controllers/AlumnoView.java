package pe.edu.upc.education.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.education.models.entities.Curso;
import pe.edu.upc.education.models.services.CursoService;

@Named("alumnoView")
@ViewScoped
public class AlumnoView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CursoService cursoService;
	
	private Curso curso;
	private List<Curso> cursos;	


	@PostConstruct
	public void init() {	
		this.cleanForm();	
		this.loadCursos();
	}
	
	public void cleanForm() {
	
	}
	
	public void loadCursos() {
		try {
			this.cursos = cursoService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public CursoService getCursoService() {
		return cursoService;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public Curso getCurso() {
		return curso;
	}
	
}
