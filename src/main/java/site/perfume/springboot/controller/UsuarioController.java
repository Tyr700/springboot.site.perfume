package site.perfume.springboot.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.perfume.springboot.errors.UsuarioJaExiste;
import site.perfume.springboot.errors.UsuarioNaoEncontrado;
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

    @PostMapping("/")
    public ResponseEntity<?> criarUsuario(@RequestBody Usuario usuario) {
        try {
            var user = usuarioService.criarUsuario(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        } catch (UsuarioJaExiste e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMensagem());
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deletarUsuario(@RequestBody Usuario usuario) {
        try {
            usuarioService.deletePorEmail(usuario.getEmail());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (UsuarioNaoEncontrado e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getAviso());
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> buscarPorEmail (@RequestParam String email) {
        var user = usuarioService.buscarPorEmail(email);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario userModel) {
        boolean autenticado = usuarioService.autenticar(userModel.getEmail(), userModel.getSenha());
        if (autenticado) {
            return ResponseEntity.ok("Autenticação bem-sucedida");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha incorreta");
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Usuario>> getAllUsers() {
        var users = usuarioService.listarUsuarios();
        if (users.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(users);
    }



}
