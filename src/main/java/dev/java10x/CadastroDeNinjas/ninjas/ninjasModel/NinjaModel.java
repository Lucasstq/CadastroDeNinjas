package dev.java10x.CadastroDeNinjas.ninjas.ninjasModel;
import dev.java10x.CadastroDeNinjas.missoes.missoesModel.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //cria id automatico o type.IDENTITY quer dizer que esses ids serão: 1, 2,3....
    private Long id;
    private String nome;
    @Column(unique =true) //diz que esse atributo no nosso banco de dados vai ser algo unico, ngm pode ter repetido
    private String email;
    private int idade;
    @ManyToOne // muitos ninjas para uma missao
    @JoinColumn(name = "missoes_id") //junção de uma tabela com a outra, fazendo uma nova coluna na tabela, chave estrangeira
    private MissoesModel missoes;




}
