package pe.edu.upc.education.models.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.upc.education.models.entities.Ejercicio;
import pe.edu.upc.education.models.repositories.EjercicioRepository;
import pe.edu.upc.education.models.services.EjercicioService;

@Named
@ApplicationScoped
public class EjercicioServiceImpl implements EjercicioService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EjercicioRepository ejercicioRepository;
	
	@Transactional
	@Override
	public Ejercicio save(Ejercicio entity) throws Exception {
		return ejercicioRepository.save(entity);
	}

	@Transactional
	@Override
	public Ejercicio update(Ejercicio entity) throws Exception {
		return ejercicioRepository.update(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		ejercicioRepository.deleteById(id);
	}

	@Override
	public Optional<Ejercicio> findById(Integer id) throws Exception {
		return ejercicioRepository.findById(id);
	}

	@Override
	public List<Ejercicio> findAll() throws Exception {
		return ejercicioRepository.findAll();
	}

	@Override
	public List<Ejercicio> findByNombre(String nombre) throws Exception {
		return ejercicioRepository.findByNombre(nombre);
	}

}
