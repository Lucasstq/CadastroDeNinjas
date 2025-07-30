package dev.java10x.CadastroDeNinjas.missoes.services;

import dev.java10x.CadastroDeNinjas.missoes.dto.MissoesDto;
import dev.java10x.CadastroDeNinjas.missoes.mapper.MissoesMapper;
import dev.java10x.CadastroDeNinjas.missoes.model.MissoesModel;
import dev.java10x.CadastroDeNinjas.missoes.repository.MissoesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesServices {
    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesServices(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    //listar as missoes
    public List<MissoesDto> listarMissoes() {
        List<MissoesModel> listaDeMissoes = missoesRepository.findAll();
        return listaDeMissoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    //listar missao por ID
    public MissoesDto listarMissoesPorId(Long id) {
        Optional<MissoesModel> missoesPorId = missoesRepository.findById(id);
        return missoesPorId.map(missoesMapper::map).orElse(null);
    }

    //adcionar missoes
    public MissoesDto cadastrarMissao(MissoesDto missao) {
        MissoesModel missoesModel = missoesMapper.map(missao);
        return missoesMapper.map(missoesRepository.save(missoesModel));
    }

    //deletar missao por id
    public MissoesDto deleteMissoesPorId(Long id) {
        Optional<MissoesModel> missoesPorId = missoesRepository.findById(id);
        if (missoesPorId.isPresent()) {
            missoesRepository.deleteById(id);
            return missoesMapper.map(missoesPorId.get());
        }
        return null;
    }

    //Alterar missoes
    public MissoesDto atualizarMissao(Long id, MissoesDto missaoAtualizada) {
        Optional<MissoesModel> missoesPorId = missoesRepository.findById(id);
        if (missoesPorId.isPresent()) {
            MissoesModel missaoAtual = missoesMapper.map(missaoAtualizada);
            MissoesModel missaoSalvo = missoesRepository.save(missaoAtual);
            return missoesMapper.map(missaoSalvo);
        }
        return null;
    }

}
