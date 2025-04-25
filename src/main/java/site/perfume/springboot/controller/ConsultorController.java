package site.perfume.springboot.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.perfume.springboot.errors.ConsultorJaExiste;
import site.perfume.springboot.model.Consultor;
import site.perfume.springboot.service.ConsultorService;
import java.util.List;

@RestController
@RequestMapping("/consultor")
public class ConsultorController {

    private ConsultorService consultorService;

    public ConsultorController(ConsultorService consultorService) {
        this.consultorService = consultorService;
    }

    @PostMapping("/criar")
    public ResponseEntity<?> criarConsultor(@RequestBody Consultor consultor) {
        try {
            var consultant = consultorService.criarConsultor(consultor);
            return ResponseEntity.status(HttpStatus.CREATED).body(consultant);
        } catch (ConsultorJaExiste e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMensagemc());
        }
    }

    public ResponseEntity<List<Consultor>> getAllconsultants() {
        var consultants = consultorService.listarConsultores();
        if (consultants.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(consultants);
    }


}
