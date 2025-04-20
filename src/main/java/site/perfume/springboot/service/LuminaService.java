package site.perfume.springboot.service;


import org.springframework.stereotype.Service;
import site.perfume.springboot.model.Usuario;
import site.perfume.springboot.repository.ILuminaRepository;

import java.util.List;

@Service
public class LuminaService {

    private final ILuminaRepository iLuminaRepository;

    public LuminaService(ILuminaRepository iLuminaRepository) {
        this.iLuminaRepository = iLuminaRepository;
    }


}
