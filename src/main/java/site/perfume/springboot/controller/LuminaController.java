package site.perfume.springboot.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.perfume.springboot.service.LuminaService;

@RestController
@RequestMapping("/Lumina")
public class LuminaController {

    private LuminaService luminaService;

    public LuminaController(LuminaService luminaService) {
        this.luminaService = luminaService;
    }
}
