package io.github.davidrodrigues.localizacao;

import io.github.davidrodrigues.localizacao.domain.entity.Cidade;
import io.github.davidrodrigues.localizacao.domain.repository.CidadeRepository;
import io.github.davidrodrigues.localizacao.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

	@Autowired
	private CidadeService service;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Iniciando projeto!");

		service.findCidadePorNome();



	}

	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}

}
