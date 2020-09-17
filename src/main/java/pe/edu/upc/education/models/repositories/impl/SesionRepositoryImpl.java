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

import pe.edu.upc.education.models.entities.Sesion;
import pe.edu.upc.education.models.repositories.SesionRepository;

@Named
@ApplicationScoped
public class SesionRepositoryImpl implements SesionRepository, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "ModernEducationPU")
	private EntityManager em;
	
	@Override
	public Sesion save(Sesion entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Override
	public Sesion update(Sesion entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		Optional<Sesion> optional = findById(id);
		if(optional.isPresent()) {
			em.remove(optional.get());
		}	
	}

	@Override
	public Optional<Sesion> findById(Integer id) throws Exception {
		Optional<Sesion> optional = Optional.empty();
		String qlString = "SELECT s FROM Sesion s WHERE s.id = ?1";
		TypedQuery<Sesion> query = em.createQuery(qlString, Sesion.class);
		query.setParameter(1, id);
		Sesion sesion = query.getSingleResult();
		if(sesion != null) {
			optional = Optional.of(sesion);
		}		
		return optional;
	}

	@Override
	public List<Sesion> findAll() throws Exception {		
		List<Sesion> sesiones = new ArrayList<Sesion>();
		String qlString = "SELECT s FROM Sesion s";	
		TypedQuery<Sesion> query = em.createQuery(qlString, Sesion.class);
		sesiones = query.getResultList();		
		return sesiones;
	}

	@Override
	public List<Sesion> findByTema(String tema) throws Exception {
		List<Sesion> sesiones = new ArrayList<Sesion>();
		String qlString = "SELECT s FROM Sesion s WHERE s.tema LIKE '%?1%'";	
		TypedQuery<Sesion> query = em.createQuery(qlString, Sesion.class);
		query.setParameter(1, tema);
		sesiones = query.getResultList();		
		return sesiones;
	}

}
