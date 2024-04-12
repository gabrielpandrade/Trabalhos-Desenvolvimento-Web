package com.dw.trabalhos.trabalho1.repository;

import com.dw.trabalhos.trabalho1.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findById_funcionario(long id_funcionario);

    List<Pedido> findById_cliente(long id_cliente);
}
