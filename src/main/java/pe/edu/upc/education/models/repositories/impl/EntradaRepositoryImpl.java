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

import pe.edu.upc.education.models.entities.Entrada;
import pe.edu.upc.education.models.repositories.EntradaRepository;

@Named
@ApplicationScoped
public class EntradaRepositoryImpl implements EntradaRepository, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "ModernEducationPU")
	private EntityManager em;
	
	@Override
	public Entrada save(Entrada entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Override
	public Entrada update(Entrada entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		Optional<Entrada> optional = findById(id);
		if(optional.isPresent()) {
			em.remove(optional.get());
		}	
	}

	@Override
	public Optional<Entrada> findById(Integer id) throws Exception {
		Optional<Entrada> optional = Optional.empty();
		String qlString = "SELECT e FROM Entrada e WHERE e.id = ?1";
		TypedQuery<Entrada> query = em.createQuery(qlString, Entrada.class);
		query.setParameter(1, id);
		Entrada entrada = query.getSingleResult();
		if(entrada != null) {
			optional = Optional.of(entrada);
		}		
		return optional;
	}

	@Override
	public List<Entrada> findAll() throws Exception {		
		List<Entrada> entradas = new ArrayList<Entrada>();
		String qlString = "SELECT e FROM Entrada e";	
		TypedQuery<Entrada> query = em.createQuery(qlString, Entrada.class);
		entradas = query.getResultList();		
		return entradas;
	}
}
