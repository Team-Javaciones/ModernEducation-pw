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

import pe.edu.upc.education.models.entities.Foro;
import pe.edu.upc.education.models.repositories.ForoRepository;

@Named
@ApplicationScoped
public class ForoRepositoryImpl implements ForoRepository, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "ModernEducationPU")
	private EntityManager em;
	
	@Override
	public Foro save(Foro entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Override
	public Foro update(Foro entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		Optional<Foro> optional = findById(id);
		if(optional.isPresent()) {
			em.remove(optional.get());
		}	
	}

	@Override
	public Optional<Foro> findById(Integer id) throws Exception {
		Optional<Foro> optional = Optional.empty();
		String qlString = "SELECT f FROM Foro f WHERE f.id = ?1";
		TypedQuery<Foro> query = em.createQuery(qlString, Foro.class);
		query.setParameter(1, id);
		Foro foro = query.getResultList().stream().findFirst().orElse(null);
		if(foro != null) {
			optional = Optional.of(foro);
		}		
		return optional;
	}

	@Override
	public List<Foro> findAll() throws Exception {		
		List<Foro> foros = new ArrayList<Foro>();
		String qlString = "SELECT f FROM Foro f";	
		TypedQuery<Foro> query = em.createQuery(qlString, Foro.class);
		foros = query.getResultList();		
		return foros;
	}

	@Override
	public List<Foro> findByTema(String tema) throws Exception {
		List<Foro> foros = new ArrayList<Foro>();
		String qlString = "SELECT f FROM Foro f WHERE UPPER(f.tema) LIKE ?1";	
		TypedQuery<Foro> query = em.createQuery(qlString, Foro.class);
		query.setParameter(1, "%" + tema.toUpperCase() + "%");
		foros = query.getResultList();		
		return foros;
	}

}
