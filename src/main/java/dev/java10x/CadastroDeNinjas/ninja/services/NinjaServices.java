package dev.java10x.CadastroDeNinjas.ninja.services;

import dev.java10x.CadastroDeNinjas.ninja.dto.NinjaDto;
import dev.java10x.CadastroDeNinjas.ninja.mapper.NinjaMapper;
import dev.java10x.CadastroDeNinjas.ninja.ninjaModel.NinjaModel;
import dev.java10x.CadastroDeNinjas.ninja.repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//marcando a classe como um service
@Service
public class NinjaServices {
    //conectar a camada de serviço com a camada de repositório (injeção de dependências)
    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaServices(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //Listar todos meus ninjas
    public List<NinjaDto> listarTodosNinjas() {
        List<NinjaModel> ninjas = ninjaRepository.findAll(); //buscar todos os registros da tabela de ninjas.
        return ninjas.stream() //transforma a lista em um stream
                .map(ninjaMapper::map)  //para cada ninjaModel ele aplica o metodo map do meu ninjaMapper para transformar o model em DTO
                .collect(Collectors.toList()); //converte a stream novamente para lista
    }

    //Listar Ninjas por id
    public NinjaDto buscarPorId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.map(ninjaMapper::map).orElse(null);
    }

    //Adicionar novo Ninja
    public NinjaDto cadastrarNinja(NinjaDto ninja) {
        NinjaModel ninjaModel = ninjaMapper.map(ninja); //meu ninja model sendo mapeado recebendo o valor do ninja DTO
        return ninjaMapper.map(ninjaRepository.save(ninjaModel)); //e o map vai mapear que o ninja repository vai salvar meu ninja model
    }

    //deletar ninja
    public NinjaDto deletarporID(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        if (ninjaPorId.isPresent()) {
            ninjaRepository.deleteById(id);
            return ninjaMapper.map(ninjaPorId.get());
        }
        return null;
    }

    // Atualizar ninja
    public NinjaDto atualizarNinja(Long id, NinjaDto ninjaDTO) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        if (ninjaPorId.isPresent()) {
            NinjaModel ninjaAtual = ninjaMapper.map(ninjaDTO);
            ninjaAtual.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtual);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }

}
