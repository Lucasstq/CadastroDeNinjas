package dev.java10x.CadastroDeNinjas.ninja.controller;

import dev.java10x.CadastroDeNinjas.ninja.dto.NinjaDto;
import dev.java10x.CadastroDeNinjas.ninja.services.NinjaServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //marcar classes como controladores Rest
@RequestMapping("ninjas") //mapear URLs específicas para métodos dentro dos controladores
public class Controller {

    // injetar dependencia do meu service
    private NinjaServices ninjaServices;

    public Controller(NinjaServices ninjaServices) {
        this.ninjaServices = ninjaServices;
    }

    //Criar endpoints (requisições)

    // Adicionar um ninja  (Create)
    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarNinja(@RequestBody NinjaDto ninja) {
        NinjaDto ninjaCadastrado = ninjaServices.cadastrarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED) //resposta para o servidor dizendo que foi criado
                .body("Ninja cadastrado com sucesso! " + ninjaCadastrado.getNome() + " ID do ninaja: " + ninjaCadastrado.getId()); //resposta para o úsuario

    }

    // Mostrar todos os ninjas (Read)
    @GetMapping("/todos")
    public ResponseEntity<List<NinjaDto>> listarTodosNinjas() {
        List<NinjaDto> ninjas = ninjaServices.listarTodosNinjas();
        return ResponseEntity.ok(ninjas);
    }

    // Procurar ninja por id  (Read)
    @GetMapping("/procurarid/{id}")
    // <?> passa um valor generico ao meu response entity
    public ResponseEntity<?> mostrarNinjasPorId(@PathVariable Long id) {
        NinjaDto ninjaEncotrado = ninjaServices.buscarPorId(id);
        if (ninjaEncotrado != null) {
            return ResponseEntity.ok(ninjaEncotrado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja não encontrado");
        }
    }

    // Alterar dados dos ninjas (Update)
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> alterarNinjaPorID(@PathVariable Long id, @RequestBody NinjaDto ninjaAtualizado) {
        NinjaDto ninjaAlterado = ninjaServices.atualizarNinja(id, ninjaAtualizado);
        if (ninjaAlterado != null) {
            return ResponseEntity.ok(ninjaAlterado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Id de ninja não encontrado para atualização");
        }
    }

    // Deletar ninjas (Delete)
    @DeleteMapping("/deletarporID/{id}")
    public ResponseEntity<?> deletarNinjaPorID(@PathVariable Long id) {
        NinjaDto ninjaDeletado = ninjaServices.deletarporID(id);
        if (ninjaDeletado != null) {
            return ResponseEntity.ok(ninjaDeletado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O id informado: " + id + " não existe, nenhum ninja deletado.");
        }
    }
}
