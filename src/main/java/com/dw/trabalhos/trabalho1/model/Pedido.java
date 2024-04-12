package com.dw.trabalhos.trabalho1.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Set;


@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_pedido;

    @Column
    private int id_funcionario;

    @Column
    private int id_cliente;

    @Column
    @Temporal(TemporalType.DATE)
    private Date data_pedido;

    @Column
    @Temporal(TemporalType.DATE)
    private Date data_remessa;

    public Pedido() {

    }

    public Pedido(int id_funcionario, int id_cliente, Date data_pedido, Date data_remessa) {
        this.id_funcionario = id_funcionario;
        this.id_cliente = id_cliente;
        this.data_pedido = data_pedido;
        this.data_remessa = data_remessa;
    }

    public long getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(long id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Date getData_pedido() {
        return data_pedido;
    }

    public void setData_pedido(Date data_pedido) {
        this.data_pedido = data_pedido;
    }

    public Date getData_remessa() {
        return data_remessa;
    }

    public void setData_remessa(Date data_remessa) {
        this.data_remessa = data_remessa;
    }
}
