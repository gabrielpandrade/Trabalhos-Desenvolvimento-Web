package com.dw.trabalhos.trabalho1.model;

import jakarta.persistence.*;

import java.sql.Date;


@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_pedido")
    private long id;

    @Column
    private long funcionario;

    @Column
    private long cliente;

    @Column
    @Temporal(TemporalType.DATE)
    private Date data_pedido;

    @Column
    @Temporal(TemporalType.DATE)
    private Date data_remessa;

    public Pedido() {
    }

    public Pedido(long id_funcionario, long id_cliente, Date data_pedido, Date data_remessa) {
        this.funcionario = id_funcionario;
        this.cliente = id_cliente;
        this.data_pedido = data_pedido;
        this.data_remessa = data_remessa;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(long id_funcionario) {
        this.funcionario = id_funcionario;
    }

    public long getCliente() {
        return cliente;
    }

    public void setCliente(long id_cliente) {
        this.cliente = id_cliente;
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
