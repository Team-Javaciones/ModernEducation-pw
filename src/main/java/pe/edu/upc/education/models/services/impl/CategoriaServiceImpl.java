package pe.edu.upc.education.models.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.upc.education.models.entities.Categoria;
import pe.edu.upc.education.models.repositories.CategoriaRepository;
import pe.edu.upc.education.models.services.CategoriaService;

@Named
@ApplicationScoped
public class CategoriaServiceImpl implements CategoriaService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CategoriaRepository categoriaRepository;
	
	@Transactional
	@Override
	public Categoria save(Categoria entity) throws Exception {
		return categoriaRepository.save(entity);
	}

	@Transactional
	@Override
	public Categoria update(Categoria entity) throws Exception {
		return categoriaRepository.update(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		categoriaRepository.deleteById(id);
	}

	@Override
	public Optional<Categoria> findById(Integer id) throws Exception {
		return categoriaRepository.findById(id);
	}

	@Override
	public List<Categoria> findAll() throws Exception {
		return categoriaRepository.findAll();
	}

	@Override
	public Optional<Categoria> findByNombre(String nombre) throws Exception {
		return categoriaRepository.findByNombre(nombre);
	}

}
