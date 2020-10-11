package pe.edu.upc.education.models.repositories;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.education.models.entities.Asesor;

public interface AsesorRepository extends JpaRepository<Asesor, Integer> {
	List<Asesor> findByNombreCompleto(String nombreCompleto) throws Exception;
	Optional<Asesor> findByUsername(String username) throws Exception;
}
