package site.perfume.springboot.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.UUID;


@Data
@Entity(name = "Usuario")
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @NotBlank
    @Column(name = "nome_usuario")
    private String nome;

    @NotBlank
    @Email
    @Column(name = "email_usuario", unique = true)
    private String email;

    @NotBlank
    @Min(8)
    @Column(name = "senha_usuario")
    private String senha;

    @CreationTimestamp
    @Column(name = "data_cadastro_usuario")
    private LocalDateTime dataCadastro;

}
