package dev.java10x.CadastroDeNinjas.missoes.model;

import dev.java10x.CadastroDeNinjas.ninja.ninjaModel.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_missoes")
    private Long id;

    @Column(name = "nome_missoes")
    private String nome;

    @Column(name = "dificuldade_missao")
    private String dificuldade;

    @OneToMany(mappedBy = "missoes") //modelo de uma missao para muitos ninjas
    private List<NinjaModel> ninjas;
}
