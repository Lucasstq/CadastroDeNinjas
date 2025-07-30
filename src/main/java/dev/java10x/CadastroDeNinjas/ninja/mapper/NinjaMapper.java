package dev.java10x.CadastroDeNinjas.ninja.mapper;

import dev.java10x.CadastroDeNinjas.ninja.dto.NinjaDto;
import dev.java10x.CadastroDeNinjas.ninja.ninjaModel.NinjaModel;
import org.springframework.stereotype.Component;

@Component //marca minha classe mapper como uma mapper
public class NinjaMapper {

    public NinjaModel map(NinjaDto ninjaDto) {
        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setId(ninjaDto.getId());
        ninjaModel.setNome(ninjaDto.getNome());
        ninjaModel.setEmail(ninjaDto.getEmail());
        ninjaModel.setIdade(ninjaDto.getIdade());
        ninjaModel.setRanking(ninjaDto.getRanking());
        ninjaModel.setMissoes(ninjaDto.getMissoes());

        return ninjaModel;
    }

    public NinjaDto map(NinjaModel ninjaModel) {
        NinjaDto ninjaDto = new NinjaDto();
        ninjaDto.setId(ninjaModel.getId());
        ninjaDto.setNome(ninjaModel.getNome());
        ninjaDto.setEmail(ninjaModel.getEmail());
        ninjaDto.setIdade(ninjaModel.getIdade());
        ninjaDto.setRanking(ninjaModel.getRanking());
        ninjaDto.setMissoes(ninjaModel.getMissoes());
        return ninjaDto;
    }


}
