package co.mz.ibi.backenddeveloperchallenge.paisesApp.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.mz.ibi.backenddeveloperchallenge.paisesApp.model.entity.Pais;

/**
 * 
 * @author Jose Julai Ritsure
 * 
 * Classe responsavel pela persistencia na Base de Dados
 *
 */
@Repository
public interface ManterPaisRepository extends JpaRepository<Pais, Long> {

}
