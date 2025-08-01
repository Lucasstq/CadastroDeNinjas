package dev.java10x.CadastroDeNinjas.missoes.controller;

import dev.java10x.CadastroDeNinjas.missoes.dto.MissoesDto;
import dev.java10x.CadastroDeNinjas.missoes.services.MissoesServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //marcar a classe como um controlador
@RequestMapping("missoes") //mapear HTTP
public class MissoesController {

    private final MissoesServices missoesServices;

    public MissoesController(MissoesServices missoesServices) {
        this.missoesServices = missoesServices;
    }

    @PostMapping("/cadastrar") //anotação para o usuario mandar algo
    public ResponseEntity<String> cadastrarMissoes(@RequestBody MissoesDto missoes) {
        MissoesDto missaoCadastrada = missoesServices.cadastrarMissao(missoes);
        return ResponseEntity.ok("Missão cadastrada com sucesso!" + missaoCadastrada);
    }

    @GetMapping("/todos") //get usada quando o usuario tiver "pedindo" algo e nos devolvemos algo
    public ResponseEntity<List<MissoesDto>> listarMissoes() {
        List<MissoesDto> listaDeMissoes = missoesServices.listarMissoes();
        return ResponseEntity.ok(listaDeMissoes);
    }

    @RequestMapping("/listarporid/{id}")
    public ResponseEntity<?> listarMissoesPorId(@PathVariable Long id) {
        MissoesDto missoesPorId = missoesServices.listarMissoesPorId(id);
        if (missoesPorId != null) {
            return ResponseEntity.ok(missoesPorId);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao não encontrada!");
        }
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarMissoesPorId(@PathVariable Long id, @RequestBody MissoesDto missaoAtualizada) {
        MissoesDto missaoAtual = missoesServices.atualizarMissao(id, missaoAtualizada);
        if (missaoAtual != null) {
            return ResponseEntity.ok(missaoAtual);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão não encontrada!");
        }
    }

    @DeleteMapping("/deletarporid/{id}")
    public ResponseEntity<?> deleteMissoesPorId(@PathVariable Long id) {
        MissoesDto missaoDeletada = missoesServices.deleteMissoesPorId(id);
        if (missaoDeletada != null) {
            return ResponseEntity.ok(missaoDeletada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão não encontrada!");
        }
    }
}


