package co.mz.ibi.backenddeveloperchallenge.paisesApp.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import co.mz.ibi.backenddeveloperchallenge.paisesApp.model.dto.PaisDTO;
import co.mz.ibi.backenddeveloperchallenge.paisesApp.model.entity.Pais;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ManterPaisWsTest {

	@MockBean
	private IManterPaisWs manterPaisWs;

	@MockBean
	private IConsultarPaisWs consultarPaisWs;

	@Test
	public void registarPais() {

		final Pais pais = new Pais();
		pais.setNome("Zimbabwe");
		pais.setCapital("Harare");
		pais.setRegiao("Africa");
		pais.setSubRegiao("Africa Austral");
		pais.setArea(Double.parseDouble("750000"));

		final PaisDTO dto = new PaisDTO(pais);

		ResponseEntity<PaisDTO> response = new ResponseEntity<PaisDTO>(dto, HttpStatus.OK);

		when(manterPaisWs.registarPais(dto)).thenReturn(response);

		assertEquals(HttpStatus.OK, manterPaisWs.registarPais(dto).getStatusCode());

	}

	@Test
	public void actualizarPais() {

		final Pais pais = new Pais();
		pais.setId(1L);
		pais.setNome("Mozambique");
		pais.setCapital("Maputo");
		pais.setRegiao("Africa");
		pais.setSubRegiao("Africa Austral");
		pais.setArea(Double.parseDouble("815000"));

		final PaisDTO dto = new PaisDTO(pais);

		assertNotNull(dto);

		List<PaisDTO> paisDTOs = new ArrayList<PaisDTO>(0);
		paisDTOs.add(dto);
		assertFalse(paisDTOs.isEmpty());

		ResponseEntity<List<PaisDTO>> responseOk = new ResponseEntity<List<PaisDTO>>(paisDTOs, HttpStatus.OK);
		assertNotNull(responseOk);

		when(consultarPaisWs.listarPaises()).thenReturn(responseOk);

		// Dados por actualizar
		pais.setSubRegiao("Africa Ocidental");
		pais.setArea(Double.parseDouble("955555"));
		
		final PaisDTO dtoRegistado = new PaisDTO(pais);

		ResponseEntity<PaisDTO> response = new ResponseEntity<PaisDTO>(dtoRegistado, HttpStatus.OK);

		when(manterPaisWs.actualizarPais(dtoRegistado)).thenReturn(response);
		
		assertEquals(HttpStatus.OK, manterPaisWs.actualizarPais(dtoRegistado).getStatusCode());
		assertEquals("Africa Ocidental", manterPaisWs.actualizarPais(dtoRegistado).getBody().getSubRegiao());
		assertEquals(Double.parseDouble("955555"), manterPaisWs.actualizarPais(dtoRegistado).getBody().getArea());

	}

	@Test
	public void removerPais() {
		
		final Pais pais = new Pais();
		pais.setId(1L);
		pais.setNome("Mozambique");
		pais.setCapital("Maputo");
		pais.setRegiao("Africa");
		pais.setSubRegiao("Africa Austral");
		pais.setArea(Double.parseDouble("815000"));

		final PaisDTO dto = new PaisDTO(pais);
		assertNotNull(dto);

		List<PaisDTO> paisDTOs = new ArrayList<PaisDTO>(0);
		paisDTOs.add(dto);
		assertFalse(paisDTOs.isEmpty());

		ResponseEntity<List<PaisDTO>> responseOk = new ResponseEntity<List<PaisDTO>>(paisDTOs, HttpStatus.OK);
		assertNotNull(responseOk);

		when(consultarPaisWs.ordenarPaisesPorId()).thenReturn(responseOk);
		
		ResponseEntity response = new ResponseEntity(HttpStatus.OK);
		
		when(manterPaisWs.removerPais(1L)).thenReturn(response);
		assertEquals(HttpStatus.OK, manterPaisWs.removerPais(1L).getStatusCode());

	}

}
