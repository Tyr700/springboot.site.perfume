package site.perfume.springboot.service;


import org.springframework.stereotype.Service;
import site.perfume.springboot.model.Pedido;
import site.perfume.springboot.repository.IPedidoRepository;

import java.util.List;
import java.util.UUID;

@Service
public class PedidoService {

    private IPedidoRepository pedidoRepository;

    public PedidoService(IPedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido criarPedido (Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
    public List<Pedido> listarPedidosPorUsuario(UUID id) {
        return pedidoRepository.findAllUsuarioId(id);
    }

}
