package dev.java10x.CadastroDeNinjas.missoes.services;

import dev.java10x.CadastroDeNinjas.missoes.model.MissoesModel;
import dev.java10x.CadastroDeNinjas.missoes.repository.MissoesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesServices {
    private MissoesRepository missoesRepository;

    public MissoesServices(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    //listar as missoes
    public List<MissoesModel> listarMissoes() {
        return missoesRepository.findAll();
    }

    //listar missao por ID
    public MissoesModel listarMissoesPorId(Long id) {
        Optional<MissoesModel> missoesPorId = missoesRepository.findById(id);
        return missoesPorId.orElse(null);
    }

    //adcionar missoes
    public MissoesModel cadastrarMissao(MissoesModel missao) {
        return missoesRepository.save(missao);
    }

    //deletar missao por id
    public MissoesModel deleteMissoesPorId(Long id) {
        Optional<MissoesModel> missoesPorId = missoesRepository.findById(id);
        if (missoesPorId.isPresent()) {
            missoesRepository.deleteById(id);
        }
        return missoesPorId.orElse(null);
    }

    //Alterar missoes
    public MissoesModel atualizarMissao(Long id, MissoesModel missaoAtualizada) {
        if (missoesRepository.existsById(id)) {
            missaoAtualizada.setId(id);
            return missoesRepository.save(missaoAtualizada);
        }
        return null;
    }

}
