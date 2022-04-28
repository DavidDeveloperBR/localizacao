package io.github.davidrodrigues.localizacao.domain.repository;

import io.github.davidrodrigues.localizacao.domain.entity.Cidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.ejb.access.SimpleRemoteSlsbInvokerInterceptor;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    //Busca pelo nome correto
    Cidade findByNome(String nome);

    //Busca pelo nome like ordenado
    @Query("select c from Cidade c where lower(c.nome) like lower(?1) ")
    List<Cidade> findByNomeLike(String nome, Sort sort);

    //Busca pelo nome like paginado
    @Query("select c from Cidade c where lower(c.nome) like lower(?1) ")
    Page<Cidade> findByNomeLike(String nome, Pageable pageable);

    //começando por aquele pedaço
    List<Cidade> findByNomeStartingWith(String nome);

    //terminando por aquele pedaço
    List<Cidade>  findByNomeEndingWith(String nome);

    //contem aquele pedaço
    List<Cidade>  findByNomeContaining(String nome);

    //Busca pela quantidade exata
    Cidade findByHabitantes(Long habitantes);
    //Busca por abaixo do que o valor inserido
    List<Cidade> findByHabitantesLessThan(Long habitantes);

    //Busca por abaixo ou igual ao valor inserido
    List<Cidade> findByHabitantesLessThanEqual(Long habitantes);

    //Busca por maior do que o valor inserido
    List<Cidade> findByHabitantesGreaterThan(Long habitantes);

    //Busca por maior ou igual ao valor inserido
    List<Cidade> findByHabitantesGreaterThanEqual(Long habitantes);

    //Buscar por menor quantidade e nome like
    List<Cidade> findByHabitantesLessThanAndNomeLike(Long habitantes, String nome);

}
