package pe.edu.upc.education.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.upc.education.models.entities.Foro;
import pe.edu.upc.education.models.repositories.ForoRepository;
import pe.edu.upc.education.services.ForoService;

@Named
@ApplicationScoped
public class ForoServiceImpl implements ForoService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ForoRepository foroRepository;
	
	@Transactional
	@Override
	public Foro save(Foro entity) throws Exception {
		return foroRepository.save(entity);
	}

	@Transactional
	@Override
	public Foro update(Foro entity) throws Exception {
		return foroRepository.update(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		foroRepository.deleteById(id);
	}

	@Override
	public Optional<Foro> findById(Integer id) throws Exception {
		return foroRepository.findById(id);
	}

	@Override
	public List<Foro> findAll() throws Exception {
		return foroRepository.findAll();
	}

	@Override
	public List<Foro> findByTema(String tema) throws Exception {
		return foroRepository.findByTema(tema);
	}

}
