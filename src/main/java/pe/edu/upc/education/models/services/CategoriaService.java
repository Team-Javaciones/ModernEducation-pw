package pe.edu.upc.education.models.services;

import java.util.Optional;

import pe.edu.upc.education.models.entities.Categoria;

public interface CategoriaService extends CrudService<Categoria, Integer> {
	Optional<Categoria> findByNombre(String nombre) throws Exception; 	

}
