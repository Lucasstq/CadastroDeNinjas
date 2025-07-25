package dev.java10x.CadastroDeNinjas.missoes;

import dev.java10x.CadastroDeNinjas.ninjas.controller.services.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity //entidade para nosso banco de dados
@Table(name = "tb_missoes")
@Data //faz os getters e setters automaticamente
@NoArgsConstructor //faz pra mim um construtor vazio, automaticamente por baixo dos panos
@AllArgsConstructor //faz pra mim um construtor cheio, e se no futuro eu adicionar mais um atributo, ele irá adiconar automaticamente no construtor
public class MissoesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String missao;
    private String dificuldade;
    @OneToMany(mappedBy = "missoes") //modelo de um para muitos, uma missão para vários ninjas
    private List<NinjaModel> ninjas; //lista de ninjas que recebem alguma missão



}
