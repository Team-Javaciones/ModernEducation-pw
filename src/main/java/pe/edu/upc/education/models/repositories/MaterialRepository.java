package pe.edu.upc.education.models.repositories;

import java.util.List;

import pe.edu.upc.education.models.entities.Material;

public interface MaterialRepository extends JpaRepository<Material, Integer> {
	List<Material> findByNombre(String nombre) throws Exception; 
}
