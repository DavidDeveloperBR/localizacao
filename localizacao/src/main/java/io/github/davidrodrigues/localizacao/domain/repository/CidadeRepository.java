package io.github.davidrodrigues.localizacao.domain.repository;

import io.github.davidrodrigues.localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {


}
