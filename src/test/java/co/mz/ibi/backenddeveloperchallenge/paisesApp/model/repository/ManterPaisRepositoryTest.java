package co.mz.ibi.backenddeveloperchallenge.paisesApp.model.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import co.mz.ibi.backenddeveloperchallenge.paisesApp.model.entity.Pais;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ManterPaisRepositoryTest {

	@Autowired
	private ManterPaisRepository manterPaisRepository;

	@Autowired
	private ConsultarPaisRepository consultarPaisRepository;

	@Test
	public void registarPais() {

		final Pais pais = new Pais();
		pais.setNome("Tanzania");
		pais.setCapital("Tanzania");
		pais.setRegiao("Africa");
		pais.setSubRegiao("Africa Central");
		pais.setArea(Double.parseDouble("500000"));

		manterPaisRepository.save(pais);

		assertNotNull(pais.getId());

	}

	@Test
	public void actualizarPais() {

		final Optional<Pais> optPais = consultarPaisRepository.findById(1L);

		assertNotNull(optPais);

		final Pais pais = optPais.get();

		assertNotNull(pais.getId());

		pais.setArea(Double.parseDouble("900000"));

		manterPaisRepository.save(pais);

		assertEquals(Double.parseDouble("900000"), pais.getArea());

	}

	@Test
	public void removerPais() {

		final Optional<Pais> optPais = consultarPaisRepository.findById(2L);

		assertNotNull(optPais);

		final Pais pais = optPais.get();

		assertNotNull(pais.getId());

		manterPaisRepository.delete(pais);

		final List<Pais> paises = consultarPaisRepository.findAll();
		
		for (Pais pais2 : paises) {
			assertNotEquals("Angola", pais2.getNome());
			assertNotEquals("Luanda", pais2.getCapital());
		}


	}

}
