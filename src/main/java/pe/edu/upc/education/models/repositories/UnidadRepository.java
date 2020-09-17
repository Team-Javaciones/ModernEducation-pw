package pe.edu.upc.education.models.repositories;

import java.util.List;

import pe.edu.upc.education.models.entities.Unidad;

public interface UnidadRepository extends JpaRepository<Unidad, Integer> {
	List<Unidad> findByNombre(String nombre) throws Exception; 
}
