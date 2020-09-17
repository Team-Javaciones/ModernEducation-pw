package pe.edu.upc.education.models.services;

import java.util.List;

import pe.edu.upc.education.models.entities.Entrada;

public interface EntradaService extends CrudService<Entrada, Integer> {
	List<Entrada> findByTitulo(String titulo) throws Exception; 
}
