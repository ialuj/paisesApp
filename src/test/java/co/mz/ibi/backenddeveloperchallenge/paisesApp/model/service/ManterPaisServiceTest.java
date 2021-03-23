package co.mz.ibi.backenddeveloperchallenge.paisesApp.model.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.TransactionSystemException;

import co.mz.ibi.backenddeveloperchallenge.paisesApp.model.entity.Pais;
import co.mz.ibi.backenddeveloperchallenge.paisesApp.model.exception.NegocioException;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ManterPaisServiceTest {

	@Autowired
	private IManterPaisService manterPaisService;

	@Autowired
	private IConsultarPaisService consultarPaisService;

	@Test
	public void registarPais() {

		final Pais pais = new Pais();
		pais.setNome("Eswathini");
		pais.setCapital("Lesotho");
		pais.setRegiao("Africa");
		pais.setSubRegiao("Africa Austral");
		pais.setArea(Double.parseDouble("415000"));

		final Pais paisRegistado = manterPaisService.registarPais(pais);

		assertNotNull(paisRegistado.getId());

	}

	@Test
	public void actualizarPais() {

		final Long id = 3L;

		try {
			final Pais pais = consultarPaisService.pesquisarPaisPorId(id);

			assertNotNull(pais);

			assertNotNull(pais.getId());

			pais.setArea(Double.parseDouble("900000"));

			final Pais paisActualizado = manterPaisService.actualizarPais(pais);

			assertEquals(Double.parseDouble("900000"), paisActualizado.getArea());
		} catch (final NegocioException negocioException) {
			assertEquals("País com ID: " + id + " não existe!", negocioException.getMessage());
		}

	}

	@Test
	public void removerPais() {

		final Long id = 5L;

		try {
			final Pais pais = consultarPaisService.pesquisarPaisPorId(id);

			assertNotNull(pais);

			assertNotNull(pais.getId());

			manterPaisService.removerPais(id);

			final List<Pais> paises = consultarPaisService.listarPaises();

			for (Pais pais2 : paises) {
				assertNotEquals("Eswathini", pais2.getNome());
				assertNotEquals("Lesotho", pais2.getCapital());
			}

		} catch (final NegocioException negocioException) {
			assertEquals("Pais com ID: " + id + " nao existe!", negocioException.getMessage());
		}

	}

	@Test
	public void falhaAoRegistarPais() {

		final Pais pais = new Pais();
		pais.setNome("Eswathini");
		pais.setCapital("Lesotho");
		pais.setRegiao("Africa");
		pais.setSubRegiao("Africa Austral");

		try {
			manterPaisService.registarPais(pais);
		} catch (final NegocioException negocioException) {
			assertEquals("Verifique a informação submetida, Indique a área do País", negocioException.getMessage());
		}

	}

	@Test
	public void falhaAoActualizarPais() {

		final Long id = 1L;

		final Pais pais = consultarPaisService.pesquisarPaisPorId(id);

		assertNotNull(pais);

		assertNotNull(pais.getId());

		pais.setArea(Double.parseDouble("900000"));

		pais.setCapital("");

		try {
			manterPaisService.actualizarPais(pais);
		} catch (final NegocioException negocioException) {
			assertEquals("Verifique a informação submetida, Indique o Nome do País", negocioException.getMessage());
		} catch (final TransactionSystemException transactionSystemException) {
			assertEquals(TransactionSystemException.class, transactionSystemException.getClass());
		}

	}

}
