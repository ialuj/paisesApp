package co.mz.ibi.backenddeveloperchallenge.paisesApp.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import co.mz.ibi.backenddeveloperchallenge.paisesApp.model.dto.PaisDTO;
import co.mz.ibi.backenddeveloperchallenge.paisesApp.model.dto.RequisicaoPais;

/**
 * 
 * @author Jose Julai Ritsure
 * 
 * Interface que disponibiliza metodos (Web Services) de registo
 * actualizacao e remocao de Paises
 *
 */
public interface IManterPaisWs {
	
	public ResponseEntity<PaisDTO> registarPais(@RequestBody RequisicaoPais requisicaoPais);
	
	public ResponseEntity<PaisDTO> actualizarPais(@RequestBody RequisicaoPais requisicaoPais);
	
	public ResponseEntity removerPais(@PathVariable("id") Long id);

}
