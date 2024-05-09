package com.dw.trabalhos.trabalho1.repository;

import com.dw.trabalhos.trabalho1.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByCodigo(String codigo);
}
