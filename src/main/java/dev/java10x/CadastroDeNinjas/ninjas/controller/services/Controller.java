package dev.java10x.CadastroDeNinjas.ninjas.controller.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {

    @GetMapping("/boasvindas") //puxar informações
    public String boasVindas(){
        return "Essa é minha primeira API";
    }

}
