package dev.java10x.CadastroDeNinjas.ninja.controller;

import dev.java10x.CadastroDeNinjas.ninja.ninjaModel.NinjaModel;
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
    public NinjaModel cadastrarNinja(@RequestBody NinjaModel ninja) {
        return ninjaServices.cadastrarNinja(ninja);
    }

    // Mostrar todos os ninjas (Read)
    @GetMapping("/todos")
    public List<NinjaModel> listarTodosNinjas() {
        return ninjaServices.listarTodosNinjas();
    }

    // Procurar ninja por id  (Read)
    @GetMapping("/procurarid/{id}")
    public NinjaModel mostrarNinjasPorId(@PathVariable Long id) {
        return ninjaServices.buscarPorId(id);
    }

    // Alterar dados dos ninjas (Update)
    @PutMapping("/alterardadosporID")
    public String alterarNinjaPorID() {
        return "Alterar ninja por ID ";
    }

    // Deletar ninjas (Delete)
    @DeleteMapping("/deletarporID")
    public String deletarNinjaPorID() {
        return "Deletar ninja por ID ";
    }
}
