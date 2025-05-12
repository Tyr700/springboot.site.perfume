package site.perfume.springboot.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import site.perfume.springboot.model.Consultor;

public interface IConsultorRepository  extends JpaRepository<Consultor, UUID> {
    Consultor findByDocumento(String documento);
    void deleteByDocumento(String documento);
}
