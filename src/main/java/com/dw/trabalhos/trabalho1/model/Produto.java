package com.dw.trabalhos.trabalho1.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_produto")
    private long id;

    @Column
    private String codigo;

    @Column
    private String descricao;

    @Column
    private float valor_custo;

    @Column
    private float valor_venda;

    public Produto() {

    }

    public Produto(String codigo, String descricao, float valor_custo, float valor_venda) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valor_custo = valor_custo;
        this.valor_venda = valor_venda;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor_custo() {
        return valor_custo;
    }

    public void setValor_custo(float valor_custo) {
        this.valor_custo = valor_custo;
    }

    public float getValor_venda() {
        return valor_venda;
    }

    public void setValor_venda(float valor_venda) {
        this.valor_venda = valor_venda;
    }
}
