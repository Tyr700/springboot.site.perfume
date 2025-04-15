package site.perfume.springboot.model;


import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Entity(name = "Perfume")
@Data
public class Perfume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private UUID codigo;

    @Column(name = "nomep")
    private String nomep;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco")
    private double preco;

    public Perfume() {}
    public Perfume(UUID codigo, String nomep, String descricao, double preco) {
        this.codigo = codigo;
        this.nomep = nomep;
        this.descricao = descricao;
        this.preco = preco;
    }
}
