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

import pe.edu.upc.education.models.entities.Solucion;
import pe.edu.upc.education.models.repositories.SolucionRepository;

@Named
@ApplicationScoped
public class SolucionRepositoryImpl implements SolucionRepository, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "ModernEducationPU")
	private EntityManager em;
	
	@Override
	public Solucion save(Solucion entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Override
	public Solucion update(Solucion entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		Optional<Solucion> optional = findById(id);
		if(optional.isPresent()) {
			em.remove(optional.get());
		}	
	}

	@Override
	public Optional<Solucion> findById(Integer id) throws Exception {
		Optional<Solucion> optional = Optional.empty();
		String qlString = "SELECT s FROM Solucion s WHERE s.id = ?1";
		TypedQuery<Solucion> query = em.createQuery(qlString, Solucion.class);
		query.setParameter(1, id);
		Solucion solucion = query.getResultList().stream().findFirst().orElse(null);
		if(solucion != null) {
			optional = Optional.of(solucion);
		}		
		return optional;
	}

	@Override
	public List<Solucion> findAll() throws Exception {		
		List<Solucion> soluciones = new ArrayList<Solucion>();
		String qlString = "SELECT s FROM Solucion s";	
		TypedQuery<Solucion> query = em.createQuery(qlString, Solucion.class);
		soluciones = query.getResultList();		
		return soluciones;
	}

}
