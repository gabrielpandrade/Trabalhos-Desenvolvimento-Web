package com.dw.trabalhos.trabalho1.repository;

import com.dw.trabalhos.trabalho1.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByFuncionario(long id_funcionario);

    List<Pedido> findByCliente(long id_cliente);
}
