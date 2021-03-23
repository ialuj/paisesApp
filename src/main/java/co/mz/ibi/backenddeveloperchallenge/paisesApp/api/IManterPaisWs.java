package co.mz.ibi.backenddeveloperchallenge.paisesApp.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import co.mz.ibi.backenddeveloperchallenge.paisesApp.model.dto.PaisDTO;

/**
 * 
 * @author Jose Julai Ritsure
 * 
 * Interface que disponibiliza metodos (Web Services) de registo
 * actualizacao e remocao de Paises
 *
 */
public interface IManterPaisWs {
	
	public ResponseEntity<PaisDTO> registarPais(@RequestBody PaisDTO paisDTO);
	
	public ResponseEntity<PaisDTO> actualizarPais(@RequestBody PaisDTO paisDTO);
	
	public ResponseEntity removerPais(@RequestBody Long id);

}
