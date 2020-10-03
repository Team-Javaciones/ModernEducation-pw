package pe.edu.upc.education.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.education.models.entities.Alumno;
import pe.edu.upc.education.models.entities.Curso;
import pe.edu.upc.education.models.services.AlumnoService;
import pe.edu.upc.education.models.services.CursoService;

@Named("cursoView")
@ViewScoped
public class CursoView implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private AlumnoService alumnoService;

	@Inject
	private CursoService cursoService;
	private Curso curso;
	
	private Alumno alumno;
	private List<Alumno> alumnos;
	
	@PostConstruct
	public void init() {
		this.cleanForm();
		this.loadAlumnos();
		
	}
	public void cleanForm()
	{
		this.curso=new Curso();
	}
	
	public void newCurso()
	{
		cleanForm();
	}
	
	
	public void saveCurso()
	{
		try {
			cursoService.save(this.curso);
			cleanForm();
			this.addMessage("se creo el curso satisfactoriamente");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		
		
	}
	
	public void addMessage(String summary) {		
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	
	
	public void loadAlumnos() {
		try {
			this.alumnos = alumnoService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public AlumnoService getAlumnoService() {
		return alumnoService;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public Alumno getAlumno() {
		return alumno;
	}
	public CursoService getCursoService() {
		return cursoService;
	}
	public Curso getCurso() {
		return curso;
	}
	
	
}
