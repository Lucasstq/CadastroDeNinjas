package dev.java10x.CadastroDeNinjas.ninja.dto;

import dev.java10x.CadastroDeNinjas.missoes.model.MissoesModel;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaDto {

    private Long id;
    private String nome;
    private int idade;
    private String email;
    private String ranking;
    private MissoesModel missoes;

}
