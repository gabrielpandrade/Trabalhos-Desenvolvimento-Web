package com.dw.trabalhos.trabalho1.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pedido_produto")
public class Pedido_Produto {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    @Column
    private int quantidade;

    @Column
    private float preco_unitario;

    @Column
    private float desconto;
}
