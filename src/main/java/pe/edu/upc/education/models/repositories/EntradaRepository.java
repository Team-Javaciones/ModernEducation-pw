package pe.edu.upc.education.models.repositories;

import java.util.List;

import pe.edu.upc.education.models.entities.Entrada;

public interface EntradaRepository extends JpaRepository<Entrada, Integer> {
	List<Entrada> findByTitulo(String titulo) throws Exception; 
}
