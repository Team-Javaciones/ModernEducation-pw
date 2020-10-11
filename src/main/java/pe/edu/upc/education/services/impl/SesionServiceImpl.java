package pe.edu.upc.education.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.upc.education.models.entities.Sesion;
import pe.edu.upc.education.models.repositories.SesionRepository;
import pe.edu.upc.education.services.SesionService;

@Named
@ApplicationScoped
public class SesionServiceImpl implements SesionService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private SesionRepository sesionRepository;
	
	@Transactional
	@Override
	public Sesion save(Sesion entity) throws Exception {
		return sesionRepository.save(entity);
	}

	@Transactional
	@Override
	public Sesion update(Sesion entity) throws Exception {
		return sesionRepository.update(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		sesionRepository.deleteById(id);
	}

	@Override
	public Optional<Sesion> findById(Integer id) throws Exception {
		return sesionRepository.findById(id);
	}

	@Override
	public List<Sesion> findAll() throws Exception {
		return sesionRepository.findAll();
	}

	@Override
	public List<Sesion> findByTema(String tema) throws Exception {
		return sesionRepository.findByTema(tema);
	}

}
