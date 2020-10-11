package pe.edu.upc.education.models.repositories;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.education.models.entities.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer>{
	List<Alumno> findByEntidadEducativa(String entidadEducativa) throws Exception; 
	List<Alumno> findByNombreCompleto(String nombreCompleto) throws Exception;
	Optional<Alumno> findByUsername(String username) throws Exception;
}