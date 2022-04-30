package io.github.davidrodrigues.localizacao;

import io.github.davidrodrigues.localizacao.domain.entity.Cidade;
import io.github.davidrodrigues.localizacao.domain.repository.CidadeRepository;
import io.github.davidrodrigues.localizacao.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.transform.sax.SAXSource;
import java.util.List;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

	@Autowired
	private CidadeService service;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Iniciando projeto!");

//		service.findCidadePorNome();
//		System.out.println("Filtro dinamico \n");
//		var cidade = new Cidade(null, "porto", null);
//		service.filtroDinamico(cidade).forEach(System.out::println);

		service.listarCidadesByNomeSpec();


	}

	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}

}
