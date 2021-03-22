package co.mz.ibi.backenddeveloperchallenge.paisesApp.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.mz.ibi.backenddeveloperchallenge.paisesApp.model.entity.Pais;

/**
 * 
 * @author Jose Julai Ritsure
 * 
 * Classe responsavel pelas consultas na Base de Dados
 *
 */
@Repository
public interface ConsultarPaisRepository extends JpaRepository<Pais, Long> {

	@Query("select p from Pais p order by p.id asc")
	public List<Pais> ordenarPaisesPorId();

	@Query("select p from Pais p order by p.nome")
	public List<Pais> ordenarPaisesPorNome();

	@Query("select p from Pais p order by p.capital")
	public List<Pais> ordenarPaisesPorCapital();

	@Query("select p from Pais p order by p.regiao")
	public List<Pais> ordenarPaisesPorRegiao();

	@Query("select p from Pais p order by p.subRegiao")
	public List<Pais> ordenarPaisesPorSubRegiao();

	@Query("select p from Pais p order by p.area")
	public List<Pais> ordenarPaisesPorArea();

}
