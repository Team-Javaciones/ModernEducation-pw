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

import pe.edu.upc.education.models.entities.Usuario;
import pe.edu.upc.education.models.repositories.UsuarioRepository;

@Named
@ApplicationScoped
public class UsuarioRepositoryImpl implements UsuarioRepository, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "ModernEducationPU")
	private EntityManager em;
	
	@Override
	public Usuario save(Usuario entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Override
	public Usuario update(Usuario entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		Optional<Usuario> optional = findById(id);
		if(optional.isPresent()) {
			em.remove(optional.get());
		}	
	}

	@Override
	public Optional<Usuario> findById(Integer id) throws Exception {
		Optional<Usuario> optional = Optional.empty();
		String qlString = "SELECT u FROM Usuario u WHERE u.id = ?1";
		TypedQuery<Usuario> query = em.createQuery(qlString, Usuario.class);
		query.setParameter(1, id);
		Usuario usuario = query.getResultList().stream().findFirst().orElse(null);
		if(usuario != null) {
			optional = Optional.of(usuario);
		}		
		return optional;
	}

	@Override
	public List<Usuario> findAll() throws Exception {		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		String qlString = "SELECT u FROM Usuario u";	
		TypedQuery<Usuario> query = em.createQuery(qlString, Usuario.class);
		usuarios = query.getResultList();		
		return usuarios;
	}

	@Override
	public List<Usuario> findByNombre(String nombre) throws Exception {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		String qlString = "SELECT u FROM Usuario u WHERE UPPER(u.nombre) LIKE ?1";	
		TypedQuery<Usuario> query = em.createQuery(qlString, Usuario.class);
		query.setParameter(1, "%" + nombre.toUpperCase() + "%");
		usuarios = query.getResultList();		
		return usuarios;
	}

	@Override
	public List<Usuario> findByApellido(String apellido) throws Exception {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		String qlString = "SELECT u FROM Usuario u WHERE UPPER(u.apellido) LIKE ?1";	
		TypedQuery<Usuario> query = em.createQuery(qlString, Usuario.class);
		query.setParameter(1, "%" + apellido.toUpperCase() + "%");
		usuarios = query.getResultList();		
		return usuarios;
	}

	@Override
	public Optional<Usuario> findByUsername(String username) throws Exception {
		Optional<Usuario> optional = Optional.empty();
		String qlString = "SELECT u FROM Usuario u WHERE u.username = ?1";
		TypedQuery<Usuario> query = em.createQuery(qlString, Usuario.class);
		query.setParameter(1, username);
		Usuario usuario = query.getResultList().stream().findFirst().orElse(null);
		if(usuario != null) {
			optional = Optional.of(usuario);
		}		
		return optional;
	}

}
