package site.perfume.springboot.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.perfume.springboot.errors.UsuarioJaExiste;
import site.perfume.springboot.model.Usuario;
import site.perfume.springboot.service.UsuarioService;
import java.util.List;



@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/criar")
    public ResponseEntity<?> criarUsuario(@RequestBody Usuario usuario) {
        try {
            var user = usuarioService.criarUsuario(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        } catch (UsuarioJaExiste e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMensagem());
        }
    }


}
