package dev.java10x.CadastroDeNinjas.missoes.controller;

import dev.java10x.CadastroDeNinjas.missoes.mapper.MissoesMapper;
import dev.java10x.CadastroDeNinjas.missoes.model.MissoesModel;
import dev.java10x.CadastroDeNinjas.missoes.services.MissoesServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //marcar a classe como um controlador
@RequestMapping("missoes") //mapear HTTP
public class MissoesController {

    MissoesServices missoesServices;

    public MissoesController(MissoesServices missoesServices) {
        this.missoesServices = missoesServices;
    }

    @PostMapping("/cadastrar") //anotação para o usuario mandar algo
    public MissoesModel cadastrarMissoes(@RequestBody MissoesModel missoes) {
        return missoesServices.cadastrarMissao(missoes);
    }

    @GetMapping("/todos") //get usada quando o usuario tiver "pedindo" algo e nos devolvemos algo
    public List<MissoesModel> listarMissoes() {
        return missoesServices.listarMissoes();
    }

    @RequestMapping("/listarporid/{id}")
    public MissoesModel listarMissoesPorId(@PathVariable Long id) {
        return missoesServices.listarMissoesPorId(id);
    }

    @PutMapping("/alterar/{id}")
    public MissoesModel alterarMissoesPorId(@PathVariable Long id, @RequestBody MissoesModel missaoAtualizada) {
        return missoesServices.atualizarMissao(id, missaoAtualizada);
    }

    @DeleteMapping("/deletarporid/{id}")
    public MissoesModel deletarMissoesPorId(@PathVariable Long id) {
        return missoesServices.deleteMissoesPorId(id);
    }
}


