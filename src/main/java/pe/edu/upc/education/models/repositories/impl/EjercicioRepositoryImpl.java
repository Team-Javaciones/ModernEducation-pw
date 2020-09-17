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

import pe.edu.upc.education.models.entities.Ejercicio;
import pe.edu.upc.education.models.repositories.EjercicioRepository;

@Named
@ApplicationScoped
public class EjercicioRepositoryImpl implements EjercicioRepository, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "ModernEducationPU")
	private EntityManager em;
	
	@Override
	public Ejercicio save(Ejercicio entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Override
	public Ejercicio update(Ejercicio entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		Optional<Ejercicio> optional = findById(id);
		if(optional.isPresent()) {
			em.remove(optional.get());
		}	
	}

	@Override
	public Optional<Ejercicio> findById(Integer id) throws Exception {
		Optional<Ejercicio> optional = Optional.empty();
		String qlString = "SELECT e FROM Ejercicio e WHERE e.id = ?1";
		TypedQuery<Ejercicio> query = em.createQuery(qlString, Ejercicio.class);
		query.setParameter(1, id);
		Ejercicio ejercicio = query.getSingleResult();
		if(ejercicio != null) {
			optional = Optional.of(ejercicio);
		}		
		return optional;
	}

	@Override
	public List<Ejercicio> findAll() throws Exception {		
		List<Ejercicio> ejercicios = new ArrayList<Ejercicio>();
		String qlString = "SELECT e FROM Ejercicio e";	
		TypedQuery<Ejercicio> query = em.createQuery(qlString, Ejercicio.class);
		ejercicios = query.getResultList();		
		return ejercicios;
	}

	@Override
	public List<Ejercicio> findByNombre(String nombre) throws Exception {
		List<Ejercicio> ejercicios = new ArrayList<Ejercicio>();
		String qlString = "SELECT e FROM Ejercicio e WHERE e.nombre LIKE '%?1%'";	
		TypedQuery<Ejercicio> query = em.createQuery(qlString, Ejercicio.class);
		query.setParameter(1, nombre);
		ejercicios = query.getResultList();		
		return ejercicios;
	}

}
