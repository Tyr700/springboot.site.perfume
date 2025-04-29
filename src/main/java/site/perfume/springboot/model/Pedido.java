package site.perfume.springboot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Pedido")
public class Pedido {

    @Id
    @GeneratedValue(generator = "Numero_Pedido")
    private Long numeroPedido;

    @Column(name = "endereço")
    private String endereco;

    @Column(name = "valor")
    private double valor;

    @Column(name = "data_pedido")
    private LocalDateTime dataPedido;

    @Column(name = "status_pedido")
    private String status;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}
