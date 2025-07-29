package dev.java10x.CadastroDeNinjas.ninja.services;

import dev.java10x.CadastroDeNinjas.ninja.ninjaModel.NinjaModel;
import dev.java10x.CadastroDeNinjas.ninja.repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

//marcando a classe como um service
@Service
public class NinjaServices {
    //conectar a camada de serviço com a camada de repositório (injeção de dependências)
    private NinjaRepository ninjaRepository;

    public NinjaServices(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //Listar todos meus ninjas
    public List<NinjaModel> listarTodosNinjas() {
        return ninjaRepository.findAll();
    }

}
