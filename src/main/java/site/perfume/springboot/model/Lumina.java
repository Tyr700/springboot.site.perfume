package site.perfume.springboot.model;


import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "Lumina")
public class Lumina extends Perfume {

    public Lumina() {
    }

    public Lumina(UUID codigo, String nomep, String descricao, double preco) {
        super(codigo, nomep, descricao, preco);
    }


}
