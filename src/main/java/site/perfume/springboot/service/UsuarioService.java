package site.perfume.springboot.service;

import java.util.Base64;
import java.util.List;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import site.perfume.springboot.errors.UsuarioJaExiste;
import site.perfume.springboot.model.Usuario;
import site.perfume.springboot.repository.IUsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import at.favre.lib.crypto.bcrypt.BCrypt;


@Service
public class UsuarioService {

    private final IUsuarioRepository usuarioRepository;

    public UsuarioService(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario criarUsuario(Usuario userModel) {
        var usuarioExistente = usuarioRepository.findByEmail(userModel.getEmail());
        if (usuarioExistente != null) {
            throw new UsuarioJaExiste();
        }
        return null;
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorEmail (String email) {
        usuarioRepository.findByEmail(email);
        return null;
    }

    @Transactional
    public void deletePorEmail (String email) {
        usuarioRepository.deleteByEmail(email);
    }

}
