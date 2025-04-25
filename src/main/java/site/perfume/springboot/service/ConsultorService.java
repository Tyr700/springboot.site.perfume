package site.perfume.springboot.service;


import org.springframework.stereotype.Service;
import site.perfume.springboot.errors.ConsultorJaExiste;
import site.perfume.springboot.model.Consultor;
import site.perfume.springboot.repository.IConsultorRepository;

import java.util.List;

@Service
public class ConsultorService {

    private final IConsultorRepository consultorRepository;

    public ConsultorService(IConsultorRepository consultorRepository) {
        this.consultorRepository = consultorRepository;
    }


    public Consultor criarConsultor(Consultor consultorModel) {
        var consultorExistente = consultorRepository.findByDocumento(consultorModel.getDocumento());
        if (consultorExistente != null) {
            throw new ConsultorJaExiste();
        }
        return null;
    }

    public List<Consultor> listarConsultores() {
        return consultorRepository.findAll();
    }

}
