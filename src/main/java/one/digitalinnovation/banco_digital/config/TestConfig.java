package one.digitalinnovation.banco_digital.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import one.digitalinnovation.banco_digital.entities.Agencia;
import one.digitalinnovation.banco_digital.entities.Banco;
import one.digitalinnovation.banco_digital.repositories.AgenciaRepository;
import one.digitalinnovation.banco_digital.repositories.BancoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	
	@Autowired
	private BancoRepository bancoRepository;
	
	@Autowired
	private AgenciaRepository agenciaRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		Banco b1 = new Banco(null,   1,"Banco do Brasil");
		Banco b2 = new Banco(null, 237,"Bradesco");
		Banco b3 = new Banco(null, 104,"Caixa Economica Federal");
		Banco b4 = new Banco(null, 756,"SICOOB");		
	
		bancoRepository.saveAll(Arrays.asList(b1,b2,b3,b4));		
		
		Agencia ag1 = new Agencia(null, 161,"Centro - Uberlândia", b3);
		Agencia ag2 = new Agencia(null, 3873, "Centro- São Joaquim de Bicas", b1);
				
		agenciaRepository.saveAll(Arrays.asList(ag1, ag2));
	

	}

}
