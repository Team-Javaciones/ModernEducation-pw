package pe.edu.upc.education.models.repositories;

import java.util.List;

import pe.edu.upc.education.models.entities.Foro;

public interface ForoRepository extends JpaRepository<Foro, Integer> {
	List<Foro> findByTema(String tema) throws Exception;
}
