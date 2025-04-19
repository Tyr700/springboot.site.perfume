package site.perfume.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.perfume.springboot.model.Lumina;
import java.util.UUID;

public interface ILuminaRepository extends JpaRepository<Lumina, UUID> {
    Lumina findByNomep(String nomep);
    void deleteByNomep(String nomep);
}
