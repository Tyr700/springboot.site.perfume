package site.perfume.springboot.service;

import java.util.List;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import site.perfume.springboot.errors.UsuarioJaExiste;
import site.perfume.springboot.model.Usuario;
import site.perfume.springboot.repository.IUsuarioRepository;


@Service
public class UsuarioService {

    private IUsuarioRepository usuarioRepository;

    public UsuarioService(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario criarUsuario(Usuario userModel) {
        var userExistente = usuarioRepository.findByEmail(userModel.getEmail());
        if (userExistente != null) {
            throw new UsuarioJaExiste();
        }
        return userExistente;
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
