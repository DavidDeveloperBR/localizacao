package io.github.davidrodrigues.localizacao.service;

import io.github.davidrodrigues.localizacao.domain.entity.Cidade;
import io.github.davidrodrigues.localizacao.domain.repository.CidadeRepository;
import io.github.davidrodrigues.localizacao.domain.repository.specs.CidadeSpecs;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

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

//        Pageable pageable = PageRequest.of(1, 2);
//        repository.findByNomeLike("%%%%", pageable).forEach(System.out::println);



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

    public List<Cidade> filtroDinamico(Cidade cidade){
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase("nome")
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING);
        Example<Cidade> example = Example.of(cidade, matcher);
        return repository.findAll(example);
    }

    public void listarCidadesByNomeSpec(){
        Specification<Cidade> specification = CidadeSpecs.nomeEqual("Rio de Janeiro")
                .or(CidadeSpecs.habitantesGreaterThan(400000L));
        repository.findAll(specification).forEach(System.out::println);
    }

    void listarCidadesSpecsFiltroDinamico(Cidade filtro){
        Specification<Cidade> specs = Specification.where((root, query, criteriaBuilder) -> criteriaBuilder.conjunction());

//        if(filtro.getId() != null){
//            specs = specs.and( idEqual(filtro.getId()));
//        }

        if(StringUtils.hasText(filtro.getNome())){
            specs = specs.and(CidadeSpecs.nomeLike(filtro.getNome()));
        }

        if(filtro.getHabitantes() != null){
            specs = specs.and(CidadeSpecs.habitantesGreaterThan(filtro.getHabitantes()));
        }

        repository.findAll(specs).forEach(System.out::println);
    }

}
