package site.perfume.springboot.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.perfume.springboot.model.Pedido;
import site.perfume.springboot.service.PedidoService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<Pedido>> listarPedidosPorUsuario(@PathVariable UUID id) {
        List <Pedido> pedidos = pedidoService.listarPedidosPorUsuario(id);
        return ResponseEntity.ok(pedidos);
    }


    @GetMapping("/numero/{numeroPedido}")
    public ResponseEntity<?> buscarPorNumero(@PathVariable Long numeroPedido) {
        Optional<Pedido> pedido = pedidoService.buscarPorNumeroPedido(numeroPedido);
        if (pedido.isPresent()) {
            return ResponseEntity.ok(pedido.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não encontrado");
        }
    }
}
