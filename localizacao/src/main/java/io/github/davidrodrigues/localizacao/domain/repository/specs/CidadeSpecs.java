package io.github.davidrodrigues.localizacao.domain.repository.specs;

import io.github.davidrodrigues.localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.domain.Specification;

public abstract class CidadeSpecs {

    public static Specification<Cidade> nomeEqual(String nome){
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("nome"), nome );
    }

    public static Specification<Cidade> habitantesGreaterThan(Long habitantes){
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("habitantes"), habitantes );
    }

    public static Specification<Cidade> habitantesBetwenn(Long min, Long max){
        return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("habitantes"),min, max );
    }

    public static Specification<Cidade> nomeLike(String nome){
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.upper(root.get("nome")), "%"+nome+"%".toUpperCase());
    }
}
