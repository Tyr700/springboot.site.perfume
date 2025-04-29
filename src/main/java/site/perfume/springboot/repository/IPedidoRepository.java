package site.perfume.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.perfume.springboot.model.Pedido;

import java.util.List;
import java.util.UUID;

public interface IPedidoRepository extends JpaRepository <Pedido, Long> {
    Pedido findByNumeroPedido(Long numeroPedido);
    List<Pedido> findAllUsuarioId (UUID id);
}
