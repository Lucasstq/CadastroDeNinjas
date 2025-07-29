package dev.java10x.CadastroDeNinjas.missoes.controller;

import org.springframework.web.bind.annotation.*;

@RestController //marcar a classe como um controlador
@RequestMapping("missoes") //mapear HTTP
public class MissoesController {

    @PostMapping("/adicionar") //anotação para o usuario mandar algo
    public String criarMissoes() {
        return "Missão criada com sucesso";
    }

    @GetMapping("/todos") //get usada quando o usuario tiver "pedindo" algo e nos devolvemos algo
    public String mostrarMissoes() {
        return "Todas as missoes";
    }

    @PutMapping("/alterarporID")
    public String alterarMissoesPorId() {
        return "Missao alterada com sucesso";
    }

    @DeleteMapping("/deletarporID")
    public String deletarMissoesPorId() {
        return "Missao deletada com sucesso";
    }
}


