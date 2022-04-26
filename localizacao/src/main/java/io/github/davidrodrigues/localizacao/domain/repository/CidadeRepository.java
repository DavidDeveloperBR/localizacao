package io.github.davidrodrigues.localizacao.domain.repository;

import io.github.davidrodrigues.localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    //Busca pelo nome correto
    Cidade findByNome(String nome);

    //Busca pelo nome like
    @Query("select c from Cidade c where lower(c.nome) like lower(?1) ")
    List<Cidade> findByNomeLike(String nome);

    //começando por aquele pedaço
    List<Cidade> findByNomeStartingWith(String nome);

    //terminando por aquele pedaço
    List<Cidade>  findByNomeEndingWith(String nome);

    //contem aquele pedaço
    List<Cidade>  findByNomeContaining(String nome);

    Cidade findByHabitantes(Long habitantes);
}
