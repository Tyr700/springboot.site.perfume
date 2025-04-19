package site.perfume.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.perfume.springboot.model.Usuario;

import java.util.UUID;

public interface IUsuarioRepository extends JpaRepository<Usuario, UUID> {
    Usuario findByEmail(String email);
    void deleteByEmail(String email);
}
