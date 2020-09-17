package pe.edu.upc.education.models.services;

import java.util.List;

import pe.edu.upc.education.models.entities.Alumno;

public interface AlumnoService extends CrudService<Alumno, Integer> {
	List<Alumno> findByEntidadEducativa(String entidadEducativa) throws Exception; 

}
