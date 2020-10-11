package pe.edu.upc.education.services;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.education.models.entities.Usuario;

public interface UsuarioService extends CrudService<Usuario, Integer> {
	List<Usuario> findByNombre(String nombre) throws Exception; 
	List<Usuario> findByApellido(String apellido) throws Exception; 
	Optional<Usuario> findByUsername(String username) throws Exception;
}
