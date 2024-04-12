package com.dw.trabalhos.trabalho1.control;

import com.dw.trabalhos.trabalho1.model.Pedido;
import com.dw.trabalhos.trabalho1.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PedidoController {
    @Autowired
    PedidoRepository rep;

    /*
     * GET /api/pedidos : listar todos os pedidos
     */
    @GetMapping("/pedidos")
    public ResponseEntity<List<Pedido>> getAllPedidos() {
        try {
            List<Pedido> la = new ArrayList<>();

            la.addAll(rep.findAll());

            if (la.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(la, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*
     * POST /api/pedidos : criar pedidos
     */
    @PostMapping("/pedidos")
    public ResponseEntity<Pedido> createPedido(@RequestBody Pedido pedido) {
        try {
            Pedido _p = rep.save(new Pedido(
                    pedido.getId_funcionario(),
                    pedido.getId_cliente(),
                    pedido.getData_pedido(),
                    pedido.getData_remessa()
            ));

            return new ResponseEntity<>(_p, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*
     * PUT /api/pedidos/:id : atualizar pedidos dado um id
     */
    @PutMapping("/artigos/{id_pedido}")
    public ResponseEntity<Pedido> updatePedido(@PathVariable("id_pedido") long id_pedido, @RequestBody Pedido pedido) {
        Optional<Pedido> data = rep.findById(id_pedido);

        if (data.isPresent())
        {
            Pedido pr = data.get();
            pr.setId_funcionario(pedido.getId_funcionario());
            pr.setId_cliente(pedido.getId_cliente());
            pr.setData_pedido(pedido.getData_pedido());
            pr.setData_remessa(pedido.getData_remessa());

            return new ResponseEntity<>(rep.save(pr), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    /*
     * GET /api/pedidos/:id_pedido : listar pedidos dado um id
     */
    @GetMapping("/pedidos/{id_pedido}")
    public ResponseEntity<Pedido> getPedidooById(@PathVariable("id_pedido") long id_pedido) {
        Optional<Pedido> data = rep.findById(id_pedido);

        if (data.isPresent())
            return new ResponseEntity<>(data.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /*
     * GET /api/pedidos/funcionario?:id_funcionario : listar pedidos dado um id_funcionario
     */
    @GetMapping("/pedidos/funcionario?{id_funcionario}")
    public ResponseEntity<List<Pedido>> getPedidooByIdFuncionario(@PathVariable("id_funcionario") long id_funcionario) {
        Optional<List<Pedido>> data = Optional.ofNullable(rep.findById_funcionario(id_funcionario));

        if (data.isPresent())
            return new ResponseEntity<>(data.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /*
     * GET /api/pedidos/cliente?:id_cliente : listar pedidos dado um id_cliente
     */
    @GetMapping("/pedidos/cliente?{id_cliente}")
    public ResponseEntity<List<Pedido>> getPedidoByIdCliente(@PathVariable("id_cliente") long id_cliente) {
        Optional<List<Pedido>> data = Optional.ofNullable(rep.findById_cliente(id_cliente));

        if (data.isPresent())
            return new ResponseEntity<>(data.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //TODO PUT

    /*
     * DEL /api/pedidos/:id : remover pedido dado um id
     */
    @DeleteMapping("/pedidos/{id_pedido}")
    public ResponseEntity<HttpStatus> deletePedido(@PathVariable("id_pedido") long id_pedido)
    {
        try {
            rep.deleteById(id_pedido);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /*
     * DEL /api/pedidos : remover todos os pedidos
     */
    @DeleteMapping("/pedidos")
    public ResponseEntity<HttpStatus> deleteAllPedido()
    {
        try {
            rep.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
