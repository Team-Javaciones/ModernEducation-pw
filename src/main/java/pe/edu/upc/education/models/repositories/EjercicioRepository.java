package pe.edu.upc.education.models.repositories;

import java.util.List;

import pe.edu.upc.education.models.entities.Ejercicio;

public interface EjercicioRepository extends JpaRepository<Ejercicio, Integer> {
	List<Ejercicio> findByNombre(String nombre) throws Exception;
}