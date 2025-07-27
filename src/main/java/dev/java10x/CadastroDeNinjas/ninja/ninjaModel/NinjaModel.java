package dev.java10x.CadastroDeNinjas.ninja.ninjaModel;

import dev.java10x.CadastroDeNinjas.missoes.model.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity //cria uma entidade para o nosso banco de dados
@Table(name = "tb_cadastro") //da o nome da nossa tabela
@NoArgsConstructor //cria construtores automaticamente com o uso do lombok
@AllArgsConstructor
@Data //cria os getters e setters com o uso do lombok
public class NinjaModel {

    @Id //marca minha variavel como um id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //diz como vai gerar meus ids
    private Long id;

    private String nome;
    @Column(unique = true) //para que possamos identificar um ninja com alguma característica precisa
    private String email;

    private int idade;

    @ManyToOne //muitos ninjas para uma missao
    @JoinColumn(name = "missoes_id") //juntando uma tabela com outra com o nome missoes_id
    private MissoesModel missoes;

}
