package pe.edu.upc.education.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.upc.education.models.entities.Asesor;
import pe.edu.upc.education.models.repositories.AsesorRepository;
import pe.edu.upc.education.services.AsesorService;

@Named
@ApplicationScoped
public class AsesorServiceImpl implements AsesorService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private AsesorRepository asesorRepository;
	
	@Transactional
	@Override
	public Asesor save(Asesor entity) throws Exception {
		return asesorRepository.save(entity);
	}

	@Transactional
	public Asesor update(Asesor entity) throws Exception {
		return asesorRepository.update(entity);
	}

	@Transactional
	public void deleteById(Integer id) throws Exception {
		asesorRepository.deleteById(id);
	}

	@Override
	public Optional<Asesor> findById(Integer id) throws Exception {
		return asesorRepository.findById(id);
	}

	@Override
	public List<Asesor> findAll() throws Exception {
		return asesorRepository.findAll();
	}

	@Override
	public List<Asesor> findByNombreCompleto(String nombreCompleto) throws Exception {
		return asesorRepository.findByNombreCompleto(nombreCompleto);
	}

	@Override
	public Optional<Asesor> findByUsername(String username) throws Exception {
		return asesorRepository.findByUsername(username);
	}

}
