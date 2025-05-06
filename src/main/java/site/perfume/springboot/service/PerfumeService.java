package site.perfume.springboot.service;


import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import site.perfume.springboot.errors.PerfumeJaExiste;
import site.perfume.springboot.model.Perfume;
import site.perfume.springboot.repository.IPerfumeRepository;

import java.util.List;
import java.util.UUID;

@Service
public class PerfumeService {

    private IPerfumeRepository perfumeRepository;

    public PerfumeService(IPerfumeRepository perfumeRepository) {
        this.perfumeRepository = perfumeRepository;
    }

    public Perfume criarPerfume (Perfume perfume) {
        var perfumeExistente = perfumeRepository.findByNomep(perfume.getNomep());
        if (perfumeExistente != null) {
            throw new PerfumeJaExiste();
        }
        return perfumeRepository.save(perfume);
    }
    public Perfume buscarPorNome (String nomep) {
        perfumeRepository.findByNomep(nomep);
        return null;
    }

    public List<Perfume> listarPerfumes() {
        return perfumeRepository.findAll();
    }

    @Transactional
    public void deletePorCodigo (UUID codigo) {
        perfumeRepository.deleteByCodigo(codigo);
    }


}
