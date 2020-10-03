package pe.edu.upc.education.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.education.models.entities.Alumno;
import pe.edu.upc.education.models.services.AlumnoService;

@Named("cursoView")
@ViewScoped
public class CursoView implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private AlumnoService alumnoService;

	private Alumno alumno;
	private List<Alumno> alumnos;
	
	@PostConstruct
	public void init() {
		this.loadAlumnos();
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
	
	
}
