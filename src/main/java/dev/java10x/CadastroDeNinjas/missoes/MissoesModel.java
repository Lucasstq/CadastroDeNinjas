package dev.java10x.CadastroDeNinjas.missoes;

import dev.java10x.CadastroDeNinjas.ninjas.controller.services.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity //entidade para nosso banco de dados
@Table(name = "tb_missoes")
public class MissoesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String missao;
    private String dificuldade;
    @OneToMany(mappedBy = "missoes") //modelo de um para muitos, uma missão para vários ninjas
    private List<NinjaModel> ninjas; //lista de ninjas que recebem alguma missão

    public MissoesModel() {
    }

    public MissoesModel(Long id, String missao, String dificuldade) {
        this.id = id;
        this.missao = missao;
        this.dificuldade = dificuldade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMissao() {
        return missao;
    }

    public void setMissao(String missao) {
        this.missao = missao;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }
}
