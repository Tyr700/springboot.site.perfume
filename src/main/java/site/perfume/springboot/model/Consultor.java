package site.perfume.springboot.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.mapping.UniqueKey;

@Entity(name = "Consultor")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
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

    @Column(unique = true)
    private String documento;


}
