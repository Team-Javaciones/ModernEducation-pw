package pe.edu.upc.education.models.repositories;

import java.util.List;

import pe.edu.upc.education.models.entities.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
	List<Curso> findByNombre(String nombre) throws Exception; 
	List<Curso> findByPopularidad(Float popularidad) throws Exception; 
	List<Curso> findByPrecio(Float precio) throws Exception; 
}