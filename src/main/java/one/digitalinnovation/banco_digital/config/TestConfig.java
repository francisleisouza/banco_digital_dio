package one.digitalinnovation.banco_digital.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import one.digitalinnovation.banco_digital.entities.Banco;
import one.digitalinnovation.banco_digital.repositories.BancoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	
	@Autowired
	private BancoRepository bancoRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		Banco b1 = new Banco(null,   1,"Banco do Brasil");
		Banco b2 = new Banco(null, 237,"Bradesco");
		Banco b3 = new Banco(null, 104,"Caixa Economica Federal");
		Banco b4 = new Banco(null, 756,"SICOOB");		
	
		bancoRepository.saveAll(Arrays.asList(b1,b2,b3,b4));	
	

	}

}
