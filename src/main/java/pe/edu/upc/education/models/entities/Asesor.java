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
@Table(name = "asesores")
public class Asesor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "cuenta_zoom", length = 50, nullable = false)
	private String cuentaZoom;
	
	@OneToOne(mappedBy = "asesor")
	private Usuario usuario;
		
	@OneToMany(mappedBy = "asesor")
	private List<Curso> cursos;
	
	@OneToMany(mappedBy = "asesor")
	private List<Foro> foros;
	
	public Asesor() {
		cursos = new ArrayList<Curso>();
		foros = new ArrayList<Foro>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCuentaZoom() {
		return cuentaZoom;
	}

	public void setCuentaZoom(String cuentaZoom) {
		this.cuentaZoom = cuentaZoom;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<Foro> getForos() {
		return foros;
	}

	public void setForos(List<Foro> foros) {
		this.foros = foros;
	}
	
	
}