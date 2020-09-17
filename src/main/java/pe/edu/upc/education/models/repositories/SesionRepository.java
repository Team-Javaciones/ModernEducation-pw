package pe.edu.upc.education.models.repositories;

import java.util.List;

import pe.edu.upc.education.models.entities.Sesion;

public interface SesionRepository extends JpaRepository<Sesion, Integer> {
	List<Sesion> findByTema(String tema) throws Exception;
}
