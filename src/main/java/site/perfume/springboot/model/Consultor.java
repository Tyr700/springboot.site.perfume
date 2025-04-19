package site.perfume.springboot.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.mapping.UniqueKey;

@Entity(name = "Consultor")
@Setter
@Getter
public class Consultor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid")
    private Long cid;

    @Column(name = "nome_consultor")
    @NotBlank
    private String nome;

    @Column(name = "email_consultor")
    @Email
    @NotBlank
    private String email;

    @Column(name = "cpf")
    private UniqueKey cpf;

    public Consultor() {
    }
    public Consultor(Long cid, String nome, String email, UniqueKey cpf) {
        this.cid = cid;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;

    }
}
