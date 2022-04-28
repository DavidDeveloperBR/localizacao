package io.github.davidrodrigues.localizacao.service;

import io.github.davidrodrigues.localizacao.domain.repository.CidadeRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CidadeService {

    private CidadeRepository repository;

    public CidadeService(CidadeRepository repository){
        this.repository = repository;
    }

    @Transactional
    void salvarCidade(){

    }

    	void listarCidades(){
		repository.findAll().forEach(System.out::println);

	}

    public void findCidadePorNome(){
//        var cidade = repository.findByNome("Fortaleza");
//        System.out.println(cidade);
//
//        repository.findByNomeStartingWith("Sal").forEach(System.out::println);
//        System.out.println("\n");
//        repository.findByNomeEndingWith("leza").forEach(System.out::println);
//        System.out.println("\n");
//        repository.findByNomeContaining("to").forEach(System.out::println);
//        System.out.println("\n");
//        repository.findByNomeLike("%a%", Sort.by("habitantes")).forEach(System.out::println);

        Pageable pageable = PageRequest.of(1, 2);
        repository.findByNomeLike("%%%%", pageable).forEach(System.out::println);

    }

    public void findCidadePorHabitantes(){
        var cidade = repository.findByHabitantes(400000L);
        System.out.println(cidade);

    }

    public void listarCidadesPorQuantidadeHabitantes(){
        repository.findByHabitantesLessThan(800000L).forEach(System.out::println);
        repository.findByHabitantesGreaterThan(600000L).forEach(System.out::println);
        repository.findByHabitantesLessThanEqual(800000L).forEach(System.out::println);
        repository.findByHabitantesGreaterThanEqual(600000L).forEach(System.out::println);
    }

    public void listarCidadesPorHabitantesAndNome(){
        repository.findByHabitantesLessThanAndNomeLike(800000L,"Porto%").forEach(System.out::println);
    }

}
