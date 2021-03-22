package co.mz.ibi.backenddeveloperchallenge.paisesApp.api;

import java.util.List;

import org.springframework.http.ResponseEntity;

import co.mz.ibi.backenddeveloperchallenge.paisesApp.model.dto.PaisDTO;

/**
 * 
 * @author Jose Julai Ritsure
 * 
 * Interface com os metodos do Web Service de Consultas
 *
 */
public interface IConsultarPaisWs {
	
	public ResponseEntity<List<PaisDTO>> listarPaises();
	
	public ResponseEntity<List<PaisDTO>> ordenarPaisesPorId();
	
	public ResponseEntity<List<PaisDTO>> ordenarPaisesPorNome();
	
	public ResponseEntity<List<PaisDTO>> ordenarPaisesPorCapital();
	
	public ResponseEntity<List<PaisDTO>> ordenarPaisesPorRegiao();
	
	public ResponseEntity<List<PaisDTO>> ordenarPaisesPorSubRegiao();
	
	public ResponseEntity<List<PaisDTO>> ordenarPaisesPorArea();

}
