package pe.edu.upc.education.models.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.upc.education.models.entities.Solucion;
import pe.edu.upc.education.models.repositories.SolucionRepository;
import pe.edu.upc.education.models.services.SolucionService;

@Named
@ApplicationScoped
public class SolucionServiceImpl implements SolucionService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private SolucionRepository solucionRepository;
	
	@Transactional
	@Override
	public Solucion save(Solucion entity) throws Exception {
		return solucionRepository.save(entity);
	}

	@Transactional
	@Override
	public Solucion update(Solucion entity) throws Exception {
		return solucionRepository.update(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		solucionRepository.deleteById(id);
	}

	@Override
	public Optional<Solucion> findById(Integer id) throws Exception {
		return solucionRepository.findById(id);
	}

	@Override
	public List<Solucion> findAll() throws Exception {
		return solucionRepository.findAll();
	}

}
