package site.perfume.springboot.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.perfume.springboot.service.ConsultorService;

@RestController
@RequestMapping("/consultor")
public class ConsultorController {

    private ConsultorService consultorService;

    public ConsultorController(ConsultorService consultorService) {
        this.consultorService = consultorService;
    }


}
