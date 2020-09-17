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

import pe.edu.upc.education.models.entities.Alumno;
import pe.edu.upc.education.models.repositories.AlumnoRepository;

@Named
@ApplicationScoped
public class AlumnoRepositoryImpl implements AlumnoRepository, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "ModernEducationPU")
	private EntityManager em;

	@Override
	public Alumno save(Alumno entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Override
	public Alumno update(Alumno entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		Optional<Alumno> optional = findById(id);
		if(optional.isPresent()) {
			em.remove(optional.get());
		}	
	}

	@Override
	public Optional<Alumno> findById(Integer id) throws Exception {
		Optional<Alumno> optional = Optional.empty();
		String qlString = "SELECT a FROM Alumno a WHERE a.id = ?1";
		TypedQuery<Alumno> query = em.createQuery(qlString, Alumno.class);
		query.setParameter(1, id);
		Alumno alumno = query.getSingleResult();
		if(alumno != null) {
			optional = Optional.of(alumno);
		}		
		return optional;
	}

	@Override
	public List<Alumno> findAll() throws Exception {		
		List<Alumno> alumnos = new ArrayList<Alumno>();
		String qlString = "SELECT a FROM Alumno a";	
		TypedQuery<Alumno> query = em.createQuery(qlString, Alumno.class);
		alumnos = query.getResultList();		
		return alumnos;
	}

	@Override
	public List<Alumno> findByEntidadEducativa(String entidadEducativa) throws Exception {
		List<Alumno> alumnos = new ArrayList<Alumno>();
		String qlString = "SELECT a FROM Alumno a WHERE a.entidadEducativa LIKE '%?1%'";	
		TypedQuery<Alumno> query = em.createQuery(qlString, Alumno.class);
		query.setParameter(1, entidadEducativa);
		alumnos = query.getResultList();		
		return alumnos;
	}

}
