package pe.edu.upc.education.models.repositories;

import java.util.Optional;

import pe.edu.upc.education.models.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
	Optional<Categoria> findByNombre(String nombre) throws Exception; 	
}

