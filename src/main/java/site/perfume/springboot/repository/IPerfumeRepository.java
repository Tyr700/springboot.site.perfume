package site.perfume.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.perfume.springboot.model.Perfume;

import java.util.UUID;

public interface IPerfumeRepository extends JpaRepository <Perfume, UUID> {
    Perfume findByNomep(String nomep);
    void deleteByCodigo(UUID codigo);
}
