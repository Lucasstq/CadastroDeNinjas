package dev.java10x.CadastroDeNinjas.ninjas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {

    @GetMapping("/boasvindas") //Mapear uma requisição HTTP GET para um método
    public String boasVindas(){
        return "Essa é minha primeira API";
    }

}
