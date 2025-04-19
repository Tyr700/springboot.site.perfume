package site.perfume.springboot.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.Base64;



@Setter
@Getter
@Entity(name = "Usuario")
public class Usuario {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @NotBlank
    @Column(name = "nome_usuario")
    private String nome;

    @NotBlank
    @Email
    @Column(name = "email_usuario")
    private String email;

    @NotBlank
    @Min(8)
    @Column(name = "senha_usuario")
    private String senha;

    @CreationTimestamp
    @Column(name = "data_cadastro_usuario")
    private LocalDateTime dataCadastro;


    public Usuario() {
    }
    public Usuario(UUID id, String nome, String email, String senha, LocalDateTime dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataCadastro = dataCadastro;
    }



}
