package dev.java10x.CadastroDeNinjas.ninja.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //marcar classes como controladores Rest
@RequestMapping //mapear URLs específicas para métodos dentro dos controladores
public class Controller {

    @GetMapping("/boasvindas")
    public String boasvindas() {
        return "Cadastro de Ninjas";
    }

}
