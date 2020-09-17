package pe.edu.upc.education.models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "alumnos")
public class Alumno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "entidad_educativa", length = 50, nullable = false)
	private String entidadEducativa;
	
	@OneToOne(mappedBy = "alumno")
	private Usuario usuario;
		
	@OneToMany(mappedBy = "alumno")
	private List<AlumnoCurso> alumnoCursos;
	
	public Alumno() {
		alumnoCursos = new ArrayList<AlumnoCurso>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEntidadEducativa() {
		return entidadEducativa;
	}

	public void setEntidadEducativa(String entidadEducativa) {
		this.entidadEducativa = entidadEducativa;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<AlumnoCurso> getAlumnoCursos() {
		return alumnoCursos;
	}

	public void setAlumnoCursos(List<AlumnoCurso> alumnoCursos) {
		this.alumnoCursos = alumnoCursos;
	}	
}
