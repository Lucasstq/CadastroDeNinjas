package dev.java10x.CadastroDeNinjas.ninjas.controller.services;
import java.util.List;
import dev.java10x.CadastroDeNinjas.missoes.MissoesModel;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_cadastro")
public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //cria id automatico o type.IDENTITY quer dizer que esses ids serão: 1, 2,3....
    private Long id;
    private String nome;
    private String email;
    private int idade;
    @ManyToOne // muitos ninjas para uma missao
    @JoinColumn(name = "missoes_id") //junção de uma tabela com a outra, fazendo uma nova coluna na tabela, chave estrangeira
    private MissoesModel missoes;

    public NinjaModel() {
    }

    public NinjaModel(Long id, String nome, String email, int idade) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
