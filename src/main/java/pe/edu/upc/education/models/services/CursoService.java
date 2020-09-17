package pe.edu.upc.education.models.services;

import java.util.List;

import pe.edu.upc.education.models.entities.Curso;

public interface CursoService extends CrudService<Curso, Integer> {
	List<Curso> findByNombre(String nombre) throws Exception; 
	List<Curso> findByPopularidad(Float popularidad) throws Exception; 
}
