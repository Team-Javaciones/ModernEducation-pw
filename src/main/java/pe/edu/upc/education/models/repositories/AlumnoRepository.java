package pe.edu.upc.education.models.repositories;

import java.util.List;

import pe.edu.upc.education.models.entities.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer>{
	List<Alumno> findByEntidadEducativa(String entidadEducativa) throws Exception; 
}