package pe.edu.upc.education.controllers;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.education.models.entities.Alumno;
import pe.edu.upc.education.models.entities.Asesor;
import pe.edu.upc.education.models.entities.Curso;
import pe.edu.upc.education.services.AlumnoService;
import pe.edu.upc.education.services.AsesorService;
import pe.edu.upc.education.services.CursoService;

@Named("alumnoView")
@ViewScoped
public class AlumnoView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private AlumnoService alumnoService;
	@Inject
	private AsesorService asesorService;
	@Inject
	private CursoService cursoService;
	
	private Alumno alumno;
	private Curso curso;
	private List<Alumno> alumnos;
	private List<Curso> cursos;	
	
	private String password1;
	private String password2;


	@PostConstruct
	public void init() {	
		this.cleanForm();
		this.loadAlumnos();
		this.loadCursos();
	}
	
	public void cleanForm() {
		this.alumno = new Alumno();
	}
	
	public void loadAlumnos() {
		try {
			this.alumnos = alumnoService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	public void loadCursos() {
		try {
			this.cursos = cursoService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	public void newAlumno() {
		boolean uniqueUsername = true;
		boolean passwordConfirmation = false;
		try {
			Optional<Alumno> optionalAlumno = alumnoService.findByUsername(alumno.getUsername());
			Optional<Asesor> optionalAsesor = asesorService.findByUsername(alumno.getUsername());
			if (optionalAlumno.isPresent()) 
				if(!optionalAlumno.get().getId().equals(alumno.getId())) 
					uniqueUsername = false;		
			
			if(optionalAsesor.isPresent())
				uniqueUsername = false;
			
			if(password1.equals(password2)) {
				passwordConfirmation = true;
				this.alumno.setPassword(password1);
			}
			if(uniqueUsername == true && passwordConfirmation == true) {
				alumnoService.save(this.alumno);
				cleanForm();
				this.addMessage("Se registró el alumno satisfactoriamente");			
			}
			else if (uniqueUsername == false){
				this.addMessage("El usuario '" + alumno.getUsername() + "' ya se encuentra registrado.");
			}		
			else if (passwordConfirmation == false) {
				this.addMessage("Las contraseñas no coinciden.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}		
	}
	
	public void addMessage(String summary) {		
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
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

	public AlumnoService getAlumnoService() {
		return alumnoService;
	}
	
	public AsesorService getAsesorService() {
		return asesorService;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public String getPassword1() {
		return password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	
}
