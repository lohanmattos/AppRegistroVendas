package dev.amendola.registroVendas.controler;

import dev.amendola.registroVendas.model.Voluntario;
import dev.amendola.registroVendas.servico.VoluntarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/voluntarios")
public class VoluntarioControler {

    @Autowired
    private VoluntarioService voluntarioService;

    @GetMapping
    public String listarVoluntarios(Model model) {
        model.addAttribute("voluntarios", voluntarioService.listarTodos());
        model.addAttribute("voluntario", new Voluntario()); // Objeto para uso no modal
        return "voluntarios/lista-voluntarios"; // Nome do template Thymeleaf para a listagem
    }

    @PostMapping
    public String salvarVoluntario(@ModelAttribute Voluntario voluntario) {
        voluntarioService.salvar(voluntario);
        return "redirect:/voluntarios";
    }

    @GetMapping("/{id}/editar")
    @ResponseBody
    public Voluntario editarVoluntario(@PathVariable Long id) {
        return voluntarioService.buscarPorId(id);
    }

    @GetMapping("/{id}/excluir")
    public String excluirVoluntario(@PathVariable Long id) {
        voluntarioService.deletar(id);
        return "redirect:/voluntarios";
    }
}
