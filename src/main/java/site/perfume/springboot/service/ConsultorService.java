package site.perfume.springboot.service;


import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import site.perfume.springboot.errors.ConsultorJaExiste;
import site.perfume.springboot.model.Consultor;
import site.perfume.springboot.model.Usuario;
import site.perfume.springboot.repository.IConsultorRepository;

import java.util.List;

@Service
public class ConsultorService {

    private final IConsultorRepository consultorRepository;


    public ConsultorService(IConsultorRepository consultorRepository) {
        this.consultorRepository = consultorRepository;
    }


    public Consultor criarConsultor(Consultor consultor) {
        var consultorExistente = consultorRepository.findByDocumento(consultor.getDocumento());
        if (consultorExistente != null) {
            throw new ConsultorJaExiste();
        }
        String numeroUnicoCriptografado = BCrypt.withDefaults().hashToString(12, consultor.getNumeroUnico().toCharArray());
        consultor.setNumeroUnico(numeroUnicoCriptografado);

        return consultorRepository.save(consultor);
    }

    public List<Consultor> listarConsultores() {
        return consultorRepository.findAll();
    }

    public Usuario buscarPorDocumento (String documento) {
        consultorRepository.findByDocumento(documento);
        return null;
    }

    @Transactional
    public void deletePorDocumento (String documento) {
        consultorRepository.deleteByDocumento(documento);
    }

}
