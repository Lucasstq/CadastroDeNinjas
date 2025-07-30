package dev.java10x.CadastroDeNinjas.ninja.controller;

import dev.java10x.CadastroDeNinjas.ninja.dto.NinjaDto;
import dev.java10x.CadastroDeNinjas.ninja.services.NinjaServices;
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
    public NinjaDto cadastrarNinja(@RequestBody NinjaDto ninja) {
        return ninjaServices.cadastrarNinja(ninja);
    }

    // Mostrar todos os ninjas (Read)
    @GetMapping("/todos")
    public List<NinjaDto> listarTodosNinjas() {
        return ninjaServices.listarTodosNinjas();
    }

    // Procurar ninja por id  (Read)
    @GetMapping("/procurarid/{id}")
    public NinjaDto mostrarNinjasPorId(@PathVariable Long id) {
        return ninjaServices.buscarPorId(id);
    }

    // Alterar dados dos ninjas (Update)
    @PutMapping("/atualizar/{id}")
    public NinjaDto alterarNinjaPorID(@PathVariable Long id, @RequestBody NinjaDto ninjaAtualizado) {
        return ninjaServices.atualizarNinja(id, ninjaAtualizado);
    }

    // Deletar ninjas (Delete)
    @DeleteMapping("/deletarporID/{id}")
    public NinjaDto deletarNinjaPorID(@PathVariable Long id) {
        return ninjaServices.deletarporID(id);
    }
}
