package site.perfume.springboot.service;


import org.springframework.stereotype.Service;
import site.perfume.springboot.repository.ILuminaRepository;

@Service
public class LuminaService {

    private ILuminaRepository iLuminaRepository;

    public LuminaService(ILuminaRepository iLuminaRepository) {
        this.iLuminaRepository = iLuminaRepository;
    }


}
