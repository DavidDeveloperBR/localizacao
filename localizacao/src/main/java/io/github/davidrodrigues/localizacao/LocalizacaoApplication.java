package io.github.davidrodrigues.localizacao;

import io.github.davidrodrigues.localizacao.domain.entity.Cidade;
import io.github.davidrodrigues.localizacao.domain.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Iniciando projeto!");

		listarCidades();


	}
	@Transactional
	void salvarCidade(){


	}
	void listarCidades(){
		cidadeRepository.findAll().forEach(System.out::println);

	}

	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}

}
