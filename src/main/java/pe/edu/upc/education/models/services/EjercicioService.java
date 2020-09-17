package pe.edu.upc.education.models.services;

import java.util.List;

import pe.edu.upc.education.models.entities.Ejercicio;

public interface EjercicioService extends CrudService<Ejercicio, Integer> {
	List<Ejercicio> findByNombre(String nombre) throws Exception;

}
