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

import pe.edu.upc.education.models.entities.AlumnoCurso;
import pe.edu.upc.education.models.repositories.AlumnoCursoRepository;

@Named
@ApplicationScoped
public class AlumnoCursoRepositoryImpl implements AlumnoCursoRepository, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "ModernEducationPU")
	private EntityManager em;

	@Override
	public AlumnoCurso save(AlumnoCurso entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Override
	public AlumnoCurso update(AlumnoCurso entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		Optional<AlumnoCurso> optional = findById(id);
		if(optional.isPresent()) {
			em.remove(optional.get());
		}	
	}

	@Override
	public Optional<AlumnoCurso> findById(Integer id) throws Exception {
		Optional<AlumnoCurso> optional = Optional.empty();
		String qlString = "SELECT ac FROM AlumnoCurso ac WHERE ac.id = ?1";
		TypedQuery<AlumnoCurso> query = em.createQuery(qlString, AlumnoCurso.class);
		query.setParameter(1, id);
		AlumnoCurso alumnoCurso = query.getResultList().stream().findFirst().orElse(null);
		if(alumnoCurso != null) {
			optional = Optional.of(alumnoCurso);
		}		
		return optional;
	}

	@Override
	public List<AlumnoCurso> findAll() throws Exception {		
		List<AlumnoCurso> alumnoCursos = new ArrayList<AlumnoCurso>();
		String qlString = "SELECT ac FROM AlumnoCurso ac";	
		TypedQuery<AlumnoCurso> query = em.createQuery(qlString, AlumnoCurso.class);
		alumnoCursos = query.getResultList();		
		return alumnoCursos;
	}

}
