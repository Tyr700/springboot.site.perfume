package site.perfume.springboot.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@MappedSuperclass
@Data
public abstract class Perfume {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID codigo;

    @Column(name = "nome_produto")
    private String nomep;

    @Column(name = "descricao_produto")
    private String descricao;

    @Column(name = "preco_produto")
    private double preco;

    public Perfume() {
    }
    public Perfume(UUID codigo, String nomep, String descricao, double preco) {
        this.codigo = codigo;
        this.nomep = nomep;
        this.descricao = descricao;
        this.preco = preco;
    }
}
