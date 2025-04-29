package site.perfume.springboot.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Entity(name = "perfume")
@Data
public  class Perfume {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID codigo;

    @Column(name = "nome_produto")
    private String nomep;

    @Column(name = "descricao_produto")
    private String descricao;

    @Column(name = "preco_produto")
    private double preco;

    @Column(name = "tipo_do_perfume")
    private String tipoPerfume;

    public Perfume() {
    }
    public Perfume(UUID codigo, String nomep, String descricao, double preco, String tipoPerfume) {
        this.codigo = codigo;
        this.nomep = nomep;
        this.descricao = descricao;
        this.preco = preco;
        this.tipoPerfume = tipoPerfume;
    }
}
