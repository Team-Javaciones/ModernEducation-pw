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

import pe.edu.upc.education.models.entities.Unidad;
import pe.edu.upc.education.models.repositories.UnidadRepository;

@Named
@ApplicationScoped
public class UnidadRepositoryImpl implements UnidadRepository, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "ModernEducationPU")
	private EntityManager em;
	
	@Override
	public Unidad save(Unidad entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Override
	public Unidad update(Unidad entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		Optional<Unidad> optional = findById(id);
		if(optional.isPresent()) {
			em.remove(optional.get());
		}	
	}

	@Override
	public Optional<Unidad> findById(Integer id) throws Exception {
		Optional<Unidad> optional = Optional.empty();
		String qlString = "SELECT u FROM Unidad u WHERE u.id = ?1";
		TypedQuery<Unidad> query = em.createQuery(qlString, Unidad.class);
		query.setParameter(1, id);
		Unidad unidad = query.getResultList().stream().findFirst().orElse(null);
		if(unidad != null) {
			optional = Optional.of(unidad);
		}		
		return optional;
	}

	@Override
	public List<Unidad> findAll() throws Exception {		
		List<Unidad> unidades = new ArrayList<Unidad>();
		String qlString = "SELECT u FROM Unidad u";	
		TypedQuery<Unidad> query = em.createQuery(qlString, Unidad.class);
		unidades = query.getResultList();		
		return unidades;
	}

	@Override
	public List<Unidad> findByNombre(String nombre) throws Exception {
		List<Unidad> unidades = new ArrayList<Unidad>();
		String qlString = "SELECT u FROM Unidad u WHERE UPPER(u.nombre) LIKE ?1";	
		TypedQuery<Unidad> query = em.createQuery(qlString, Unidad.class);
		query.setParameter(1, "%" + nombre.toUpperCase() + "%");
		unidades = query.getResultList();		
		return unidades;
	}
}
