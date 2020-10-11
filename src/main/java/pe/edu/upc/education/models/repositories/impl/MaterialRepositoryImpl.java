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

import pe.edu.upc.education.models.entities.Material;
import pe.edu.upc.education.models.repositories.MaterialRepository;

@Named
@ApplicationScoped
public class MaterialRepositoryImpl implements MaterialRepository, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "ModernEducationPU")
	private EntityManager em;
	
	@Override
	public Material save(Material entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Override
	public Material update(Material entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		Optional<Material> optional = findById(id);
		if(optional.isPresent()) {
			em.remove(optional.get());
		}	
	}

	@Override
	public Optional<Material> findById(Integer id) throws Exception {
		Optional<Material> optional = Optional.empty();
		String qlString = "SELECT m FROM Material m WHERE m.id = ?1";
		TypedQuery<Material> query = em.createQuery(qlString, Material.class);
		query.setParameter(1, id);
		Material material = query.getResultList().stream().findFirst().orElse(null);
		if(material != null) {
			optional = Optional.of(material);
		}		
		return optional;
	}

	@Override
	public List<Material> findAll() throws Exception {		
		List<Material> materiales = new ArrayList<Material>();
		String qlString = "SELECT m FROM Material m";	
		TypedQuery<Material> query = em.createQuery(qlString, Material.class);
		materiales = query.getResultList();		
		return materiales;
	}

	@Override
	public List<Material> findByNombre(String nombre) throws Exception {
		List<Material> materiales = new ArrayList<Material>();
		String qlString = "SELECT m FROM Material m WHERE UPPER(m.nombre) LIKE ?1";	
		TypedQuery<Material> query = em.createQuery(qlString, Material.class);
		query.setParameter(1, "%" + nombre.toUpperCase() + "%");
		materiales = query.getResultList();		
		return materiales;
	}

}
