package co.mz.ibi.backenddeveloperchallenge.paisesApp.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import co.mz.ibi.backenddeveloperchallenge.paisesApp.model.dto.PaisDTO;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ConsultarPaisWsTest {

	@Autowired
	private IConsultarPaisWs consultarPaisWs;

	@Test
	public void listarPaises() {

		final ResponseEntity<List<PaisDTO>> response = consultarPaisWs.listarPaises();
		assertNotNull(response);

		final HttpStatus httpStatus = response.getStatusCode();
		assertNotNull(httpStatus);
		assertEquals(HttpStatus.OK, httpStatus);

		final List<PaisDTO> dtos = response.getBody();
		assertFalse(dtos.isEmpty());
	}

	@Test
	public void ordenarPaisesPorId() {
		final ResponseEntity<List<PaisDTO>> response = consultarPaisWs.ordenarPaisesPorId();
		assertNotNull(response);

		final HttpStatus httpStatus = response.getStatusCode();
		assertNotNull(httpStatus);
		assertEquals(HttpStatus.OK, httpStatus);

		final List<PaisDTO> dtos = response.getBody();
		assertFalse(dtos.isEmpty());
		
		final PaisDTO dto = dtos.get(0);
		assertNotNull(dto.getId());
		assertEquals("Mozambique", dto.getNome());

	}
	
	@Test
	public void ordenarPaisesPorNome() {
		final ResponseEntity<List<PaisDTO>> response = consultarPaisWs.ordenarPaisesPorNome();
		assertNotNull(response);

		final HttpStatus httpStatus = response.getStatusCode();
		assertNotNull(httpStatus);
		assertEquals(HttpStatus.OK, httpStatus);

		final List<PaisDTO> dtos = response.getBody();
		assertFalse(dtos.isEmpty());
		
		final PaisDTO dto = dtos.get(0);
		assertNotNull(dto.getId());
		assertEquals("Africa do Sul", dto.getNome());

	}
	
	@Test
	public void ordenarPaisesPorCapital() {
		final ResponseEntity<List<PaisDTO>> response = consultarPaisWs.ordenarPaisesPorCapital();
		assertNotNull(response);

		final HttpStatus httpStatus = response.getStatusCode();
		assertNotNull(httpStatus);
		assertEquals(HttpStatus.OK, httpStatus);

		final List<PaisDTO> dtos = response.getBody();
		assertFalse(dtos.isEmpty());
		
		final PaisDTO dto = dtos.get(0);
		assertNotNull(dto.getId());
		assertEquals("Maputo", dto.getCapital());

	}
	
	@Test
	public void ordenarPaisesPorRegiao() {
		final ResponseEntity<List<PaisDTO>> response = consultarPaisWs.ordenarPaisesPorRegiao();
		assertNotNull(response);

		final HttpStatus httpStatus = response.getStatusCode();
		assertNotNull(httpStatus);
		assertEquals(HttpStatus.OK, httpStatus);

		final List<PaisDTO> dtos = response.getBody();
		assertFalse(dtos.isEmpty());
		
		final PaisDTO dto = dtos.get(0);
		assertNotNull(dto.getId());
		assertEquals("Africa", dto.getRegiao());

	}
	
	@Test
	public void ordenarPaisesPorSubRegiao() {
		final ResponseEntity<List<PaisDTO>> response = consultarPaisWs.ordenarPaisesPorSubRegiao();
		assertNotNull(response);

		final HttpStatus httpStatus = response.getStatusCode();
		assertNotNull(httpStatus);
		assertEquals(HttpStatus.OK, httpStatus);

		final List<PaisDTO> dtos = response.getBody();
		assertFalse(dtos.isEmpty());
		
		final PaisDTO dto = dtos.get(0);
		assertNotNull(dto.getId());
		assertEquals("Africa Austral", dto.getSubRegiao());

	}
	
	@Test
	public void ordenarPaisesPorArea() {
		final ResponseEntity<List<PaisDTO>> response = consultarPaisWs.ordenarPaisesPorArea();
		assertNotNull(response);

		final HttpStatus httpStatus = response.getStatusCode();
		assertNotNull(httpStatus);
		assertEquals(HttpStatus.OK, httpStatus);

		final List<PaisDTO> dtos = response.getBody();
		assertFalse(dtos.isEmpty());		
	}

}
