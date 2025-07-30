package dev.java10x.CadastroDeNinjas.missoes.mapper;

import dev.java10x.CadastroDeNinjas.missoes.dto.MissoesDto;
import dev.java10x.CadastroDeNinjas.missoes.model.MissoesModel;
import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {

    public MissoesModel map(MissoesDto missoesDto) {
        MissoesModel missoesModel = new MissoesModel();
        missoesModel.setId(missoesDto.getId());
        missoesModel.setNome(missoesDto.getNome());
        missoesModel.setDificuldade(missoesDto.getDificuldade());
        missoesModel.setNinjas(missoesDto.getNinjas());
        return missoesModel;
    }

    public MissoesDto map(MissoesModel missoesModel) {
        MissoesDto missoesDto = new MissoesDto();
        missoesDto.setId(missoesModel.getId());
        missoesDto.setNome(missoesModel.getNome());
        missoesDto.setDificuldade(missoesModel.getDificuldade());
        missoesDto.setNinjas(missoesModel.getNinjas());
        return missoesDto;
    }

}
