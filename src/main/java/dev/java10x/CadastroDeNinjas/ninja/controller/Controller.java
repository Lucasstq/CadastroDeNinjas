package dev.java10x.CadastroDeNinjas.ninja.controller;

import org.springframework.web.bind.annotation.*;

@RestController //marcar classes como controladores Rest
@RequestMapping //mapear URLs específicas para métodos dentro dos controladores
public class Controller {

    //Serve para mostrar
    @GetMapping("/boasvindas")
    public String boasvindas() {
        return "Cadastro de Ninjas";
    }

    //Criar endpoints (requisições)

    // Adicionar um ninja  (Create)
    @PostMapping("/adicionar")
    public String cadastrarNinja() {
        return "Ninja Criado";
    }

    // Mostrar todos os ninjas (Read)
    @GetMapping("/todos")
    public String mostrarTodosOsNinjas() {
        return "Ninjas: ";
    }

    // Procurar ninja por id  (Read)
    @GetMapping("/procurarid")
    public String mostrarNinjasPorId(){
        return "Ninja por ID: ";
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
