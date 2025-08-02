package dev.java10x.CadastroDeNinjas.ninja;

import dev.java10x.CadastroDeNinjas.ninja.dto.NinjaDto;
import dev.java10x.CadastroDeNinjas.ninja.services.NinjaServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUi {

    private final NinjaServices ninjaServices;

    public NinjaControllerUi(NinjaServices ninjaServices) {
        this.ninjaServices = ninjaServices;
    }

    @GetMapping("/todos")
    public String listarTodosNinjas(Model model) {
        List<NinjaDto> ninjas = ninjaServices.listarTodosNinjas();
        model.addAttribute("ninjas", ninjas);
        return "listarNinjas";
    }

    @GetMapping("/cadastrar")
    public String mostrarFormularioAdicionarNinja(Model model) {
        model.addAttribute("ninja", new NinjaDto());
        return "adicionarNinja";
    }

    @GetMapping("/deletarporID/{id}")
    public String deletarNinjaPorID(@PathVariable Long id) {
        ninjaServices.deletarporID(id);
        return "redirect:/ninjas/ui/todos";
    }

    @GetMapping("/procurarid/{id}")
    public String listarNinjasPorId(@PathVariable Long id, Model model) {
        NinjaDto ninja = ninjaServices.buscarPorId(id);
        if (ninja != null) {
            model.addAttribute("ninja", ninja);
            return "detalhesNinja";
        } else {
            model.addAttribute("mensagem", "Ninja não encontrado");
            return "listarNinjas";
        }
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicao(@PathVariable Long id, Model model) {
        NinjaDto ninja = ninjaServices.buscarPorId(id);
        if (ninja == null) {
            model.addAttribute("mensagem", "Ninja não encontrado para edição.");
            return "redirect:/ninjas/ui/todos";
        }
        model.addAttribute("ninja", ninja);
        return "editarNinja";
    }

    // Atualizar ninja (POST para evitar problemas com formulário PUT)
    @PostMapping("/atualizar/{id}")
    public String atualizarNinja(@PathVariable Long id, @ModelAttribute("ninja") NinjaDto ninjaAtualizado, RedirectAttributes redirectAttributes) {
        NinjaDto ninjaAlterado = ninjaServices.atualizarNinja(id, ninjaAtualizado);
        if (ninjaAlterado != null) {
            redirectAttributes.addFlashAttribute("mensagem", "Ninja atualizado com sucesso!");
        } else {
            redirectAttributes.addFlashAttribute("mensagem", "Erro: Ninja não encontrado para atualização!");
        }
        return "redirect:/ninjas/ui/todos";
    }
    @PostMapping("/salvar")
    public String salvarNinja(@ModelAttribute NinjaDto ninja, RedirectAttributes redirectAttributes) {
        ninjaServices.cadastrarNinja(ninja);
        redirectAttributes.addFlashAttribute("mensagem", "Ninja cadastrado com sucesso!");
        return "redirect:/ninjas/ui/todos";
    }
}

