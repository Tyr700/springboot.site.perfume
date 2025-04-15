package site.perfume.springboot.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.util.UUID;

@Data
@Entity(name = "Usuario")
public class Usuario {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @NotBlank
    @Column(name = "nome")
    private String nome;

    @NotBlank
    @Email
    @Column(name = "email")
    private String email;

    @NotBlank
    @Min(8)
    @Column(name = "senha")
    private String senha;

    public Usuario() {}
    public Usuario(UUID id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }



}
