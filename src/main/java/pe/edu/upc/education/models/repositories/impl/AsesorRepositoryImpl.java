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

import pe.edu.upc.education.models.entities.Asesor;
import pe.edu.upc.education.models.repositories.AsesorRepository;

@Named
@ApplicationScoped
public class AsesorRepositoryImpl implements AsesorRepository, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "ModernEducationPU")
	private EntityManager em;
	
	@Override
	public Asesor save(Asesor entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Override
	public Asesor update(Asesor entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		Optional<Asesor> optional = findById(id);
		if(optional.isPresent()) {
			em.remove(optional.get());
		}	
	}

	@Override
	public Optional<Asesor> findById(Integer id) throws Exception {
		Optional<Asesor> optional = Optional.empty();
		String qlString = "SELECT a FROM Asesor a WHERE a.id = ?1";
		TypedQuery<Asesor> query = em.createQuery(qlString, Asesor.class);
		query.setParameter(1, id);
		Asesor asesor = query.getResultList().stream().findFirst().orElse(null);
		if(asesor != null) {
			optional = Optional.of(asesor);
		}		
		return optional;
	}

	@Override
	public List<Asesor> findAll() throws Exception {		
		List<Asesor> asesores = new ArrayList<Asesor>();
		String qlString = "SELECT a FROM Asesor a";	
		TypedQuery<Asesor> query = em.createQuery(qlString, Asesor.class);
		asesores = query.getResultList();		
		return asesores;
	}
}
