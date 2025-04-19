package site.perfume.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.perfume.springboot.model.Consultor;

public interface IConsultorRepository  extends JpaRepository<Consultor, Long> {
}
