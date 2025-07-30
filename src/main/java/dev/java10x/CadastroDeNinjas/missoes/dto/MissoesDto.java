package dev.java10x.CadastroDeNinjas.missoes.dto;

import dev.java10x.CadastroDeNinjas.ninja.ninjaModel.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissoesDto {

    private Long id;
    private String nome;
    private String dificuldade;
    private List<NinjaModel> ninjas;
}
