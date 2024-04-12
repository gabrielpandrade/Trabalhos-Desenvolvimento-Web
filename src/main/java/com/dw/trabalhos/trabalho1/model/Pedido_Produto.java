package com.dw.trabalhos.trabalho1.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pedido_produto")
public class Pedido_Produto {

    @Id
    @Column
    @ManyToOne
    private Pedido pedido;

    @Id
    @Column
    @ManyToOne
    private Produto produto;

    @Column
    private int quantidade;

    @Column
    private float preco_unitario;

    @Column
    private float desconto;
}
