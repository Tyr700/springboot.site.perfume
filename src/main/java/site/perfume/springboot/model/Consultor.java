package site.perfume.springboot.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;


@Entity(name = "Consultor")
@Data
public class Consultor {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID cid;

    @Column(name = "nome_consultor")
    @NotBlank
    private String nome;

    @Column(name = "email_consultor", unique = true)
    @Email
    @NotBlank
    private String email;

    @Column(name = "documento", unique = true)
    private String documento;

    @Column(name = "numero_unico", unique = true)
    @Min(8)
    private String numeroUnico;

}
