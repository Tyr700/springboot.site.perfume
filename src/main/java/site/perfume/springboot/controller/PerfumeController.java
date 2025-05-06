package site.perfume.springboot.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.perfume.springboot.errors.PerfumeJaExiste;
import site.perfume.springboot.errors.PerfumeNaoEncontrado;

import site.perfume.springboot.model.Perfume;

import site.perfume.springboot.service.PerfumeService;

import java.util.List;

@RestController
@RequestMapping("/perfumes")
public class PerfumeController {

    private PerfumeService perfumeService;

    public PerfumeController(PerfumeService perfumeService) {
        this.perfumeService = perfumeService;
    }

    @PostMapping("/")
    public ResponseEntity<?> criarPerfume(@RequestBody Perfume perfume) {
        try {
            var perfumer = perfumeService.criarPerfume(perfume);
            return ResponseEntity.status(HttpStatus.CREATED).body(perfumer);
        } catch (PerfumeJaExiste e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMensagemp());
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deletarPerfume(@RequestBody Perfume perfume) {
        try {
            perfumeService.deletePorCodigo(perfume.getCodigo());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (PerfumeNaoEncontrado e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getAvisop());
        }
    }
    @GetMapping("/")
    public ResponseEntity<?> buscarPorNome (@RequestBody Perfume perfume) {
        try {
            perfumeService.buscarPorNome(perfume.getNomep());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (PerfumeNaoEncontrado e) {
            return ResponseEntity.ok(perfume);
        }
    }


    @GetMapping("/todos")
    public ResponseEntity<List<Perfume>> getAllPerfumes () {
        var perfumer = perfumeService.listarPerfumes();
        if (perfumer.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(perfumer);
    }


}
