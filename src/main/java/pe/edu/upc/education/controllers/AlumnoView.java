package pe.edu.upc.education.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.education.models.entities.Alumno;
import pe.edu.upc.education.models.services.AlumnoService;

@Named("alumnoView")
@ViewScoped
public class AlumnoView implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AlumnoService alumnoService;
	
	private List<Alumno> alumnos;
	
	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	@PostConstruct
	public void init() {
		this.loadAlumnos();
	}	
	
	public void loadAlumnos() {
		try {
			this.setAlumnos(alumnoService.findAll());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
	}
	
	
	
}
