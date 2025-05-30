package site.perfume.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.perfume.springboot.model.Pedido;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IPedidoRepository extends JpaRepository <Pedido, Long> {
    Optional<Pedido> findByNumeroPedido(Long numeroPedido);

    // ATENÇÃO: renomear para:
    List<Pedido> findAllByUsuarioId(UUID usuarioId);

}
