package one.digitalinnovation.banco_digital.config;

import java.util.Arrays;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import one.digitalinnovation.banco_digital.entities.Agencia;
import one.digitalinnovation.banco_digital.entities.Banco;
import one.digitalinnovation.banco_digital.entities.Cliente;
import one.digitalinnovation.banco_digital.repositories.AgenciaRepository;
import one.digitalinnovation.banco_digital.repositories.BancoRepository;
import one.digitalinnovation.banco_digital.repositories.ClienteRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	
	@Autowired
	private BancoRepository bancoRepository;
	
	@Autowired
	private AgenciaRepository agenciaRepository;
	
	
	
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		Locale.setDefault(Locale.US);
		
		Banco b1 = new Banco(null,   1,"Banco do Brasil");
		Banco b2 = new Banco(null, 237,"Bradesco");
		Banco b3 = new Banco(null, 104,"Caixa Economica Federal");
		Banco b4 = new Banco(null, 756,"SICOOB");		
	
		bancoRepository.saveAll(Arrays.asList(b1,b2,b3,b4));		
		
		Agencia ag1 = new Agencia(null, 161,"Centro - Uberlândia", b3);
		Agencia ag2 = new Agencia(null, 3873, "Centro- São Joaquim de Bicas", b1);
				
		agenciaRepository.saveAll(Arrays.asList(ag1, ag2));
		
		
		
		
		Cliente cli1 = new Cliente(null, "936.555.666-89","João Carlos Sampaio", 5600.00);
		Cliente cli2 = new Cliente(null, "485.896.436-34","Pedro Marques da Silva", 4500.00);
				
		clienteRepository.saveAll(Arrays.asList(cli1, cli2));
	
	

	}

}
