package pe.edu.upc.education.models.repositories.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.upc.education.models.entities.Curso;
import pe.edu.upc.education.models.repositories.CursoRepository;

@Named
@ApplicationScoped
public class CursoRepositoryImpl implements CursoRepository, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "ModernEducationPU")
	private EntityManager em;
	
	@Override
	public Curso save(Curso entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Override
	public Curso update(Curso entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		Optional<Curso> optional = findById(id);
		if(optional.isPresent()) {
			em.remove(optional.get());
		}	
	}

	@Override
	public Optional<Curso> findById(Integer id) throws Exception {
		Optional<Curso> optional = Optional.empty();
		String qlString = "SELECT c FROM Curso c WHERE c.id = ?1";
		TypedQuery<Curso> query = em.createQuery(qlString, Curso.class);
		query.setParameter(1, id);
		Curso curso = query.getResultList().stream().findFirst().orElse(null);
		if(curso != null) {
			optional = Optional.of(curso);
		}		
		return optional;
	}

	@Override
	public List<Curso> findAll() throws Exception {		
		List<Curso> cursos = new ArrayList<Curso>();
		String qlString = "SELECT c FROM Curso c";	
		TypedQuery<Curso> query = em.createQuery(qlString, Curso.class);
		cursos = query.getResultList();		
		return cursos;
	}

	@Override
	public List<Curso> findByNombre(String nombre) throws Exception {
		List<Curso> cursos = new ArrayList<Curso>();
		String qlString = "SELECT c FROM Curso c WHERE UPPER(c.nombre) LIKE ?1";	
		TypedQuery<Curso> query = em.createQuery(qlString, Curso.class);
		query.setParameter(1, "%" + nombre.toUpperCase() + "%");
		cursos = query.getResultList();		
		return cursos;
	}

	@Override
	public List<Curso> findByPopularidad(Float popularidad) throws Exception {
		List<Curso> cursos = new ArrayList<Curso>();
		String qlString = "SELECT c FROM Curso c WHERE c.popularidad = ?1";	
		TypedQuery<Curso> query = em.createQuery(qlString, Curso.class);
		query.setParameter(1, popularidad);
		cursos = query.getResultList();		
		return cursos;
	}
	
	@Override
	public List<Curso> findByPrecio(Float precio) throws Exception {
		List<Curso> cursos = new ArrayList<Curso>();
		String qlString = "SELECT c FROM Curso c WHERE c.precio = ?1";	
		TypedQuery<Curso> query = em.createQuery(qlString, Curso.class);
		query.setParameter(1, precio);
		cursos = query.getResultList();		
		return cursos;
	}
}
