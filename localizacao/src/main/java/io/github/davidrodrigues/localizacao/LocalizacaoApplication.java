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

		//listarCidades();
		findCidadePorNome();
		System.out.println("\n");
		findCidadePorHabitantes();


	}
	@Transactional
	void salvarCidade(){

	}
	void findCidadePorNome(){
		var cidade = cidadeRepository.findByNome("Fortaleza");
		System.out.println(cidade);

		cidadeRepository.findByNomeStartingWith("Sal").forEach(System.out::println);
		System.out.println("\n");
		cidadeRepository.findByNomeEndingWith("leza").forEach(System.out::println);
		System.out.println("\n");
		cidadeRepository.findByNomeContaining("to").forEach(System.out::println);
		System.out.println("\n");
		cidadeRepository.findByNomeLike("%a%").forEach(System.out::println);

	}

	void findCidadePorHabitantes(){
		var cidade = cidadeRepository.findByHabitantes(400000L);
		System.out.println(cidade);

	}



//	void listarCidades(){
//		cidadeRepository.findAll().forEach(System.out::println);
//
//	}

	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}

}
