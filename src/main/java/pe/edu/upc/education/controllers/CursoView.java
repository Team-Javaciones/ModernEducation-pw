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
import pe.edu.upc.education.services.AlumnoService;
import pe.edu.upc.education.services.CursoService;
import pe.edu.upc.education.utils.Action;

@Named("cursoView")
@ViewScoped
public class CursoView implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<Curso> cursos;
	private Curso cursoSearch;
	
	private Action action;
	
	private String styleTableCurso;
	private String styleTableAsesor;
	private String styleSearchCurso;
	private String styleSearchAsesor;
	
	
	
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
		this.cursoSearch=new Curso();
		this.action=Action.NONE;
		this.stateListCurso();
	}
	public void cleanForm()
	{
		this.curso=new Curso();
	}
	
	public void loadCursos() {
		try {
			this.cursos=cursoService.findAll();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	public void searchAsesor() {
		cleanForm();
		this.action=Action.NONE;
		this.stateListAsesor();
	}
	
	public void findByNombreCurso() {
		if(!this.cursoSearch.getNombre().isEmpty()) {
			try {
				this.cursos=cursoService.findByNombre(cursoSearch.getNombre());
				this.stateListCurso();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
	}
	
	public void stateListCurso() {
		this.styleTableCurso="display:block;";
		this.styleTableAsesor="display:none;";
		this.styleSearchCurso="display:block;";
		this.styleSearchAsesor="display:none;";
	}
	
	public void stateListAsesor() {
		this.styleTableCurso="display:none;";
		this.styleTableAsesor="display:block;";
		this.styleSearchCurso="display:none;";
		this.styleSearchAsesor="display:block;";
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

	public List<Curso> getCursos() {
		return cursos;
	}

	public Curso getCursoSearch() {
		return cursoSearch;
	}

	public String getStyleTableCurso() {
		return styleTableCurso;
	}

	public String getStyleTableAsesor() {
		return styleTableAsesor;
	}

	public String getStyleSearchCurso() {
		return styleSearchCurso;
	}


	public String getStyleSearchAsesor() {
		return styleSearchAsesor;
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
