package dev.java10x.CadastroDeNinjas.ninja.services;

import dev.java10x.CadastroDeNinjas.ninja.ninjaModel.NinjaModel;
import dev.java10x.CadastroDeNinjas.ninja.repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    //Listar Ninjas por id
    public NinjaModel buscarPorId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    //Adicionar novo Ninja
    public NinjaModel cadastrarNinja(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }

    //deletar ninja
    public NinjaModel deletarporID(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        if (ninjaPorId.isPresent()) {
            ninjaRepository.deleteById(id);
        }
        return ninjaPorId.orElse(null);
    }

    // Atualizar ninja
    public NinjaModel atualizarNinja(Long id, NinjaModel ninjaAtualizado) {
        if (ninjaRepository.existsById(id)) {
            ninjaAtualizado.setId(id);
            return ninjaRepository.save(ninjaAtualizado);
        }
        return null;
    }

}
