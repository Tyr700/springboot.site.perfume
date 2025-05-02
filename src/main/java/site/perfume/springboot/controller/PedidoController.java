package site.perfume.springboot.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.perfume.springboot.model.Pedido;
import site.perfume.springboot.service.PedidoService;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping("/")
    public ResponseEntity<?> fazerPedido(@RequestBody Pedido pedido) {
        var order = pedidoService.fazerPedido(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }
}
