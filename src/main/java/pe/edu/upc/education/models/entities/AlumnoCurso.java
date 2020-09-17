package pe.edu.upc.education.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "alumno_cursos")
@IdClass(AlumnoCursoId.class )
public class AlumnoCurso {
	@Id
	@ManyToOne
	@JoinColumn(name = "alumno_id")	
	private Alumno alumno;
		
	@Id
	@ManyToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;
	
	@Column(name = "bloqueado", nullable = false)
	private Boolean bloqueado;

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Boolean getBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(Boolean bloqueado) {
		this.bloqueado = bloqueado;
	}
	
	
}
