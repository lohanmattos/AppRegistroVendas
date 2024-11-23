package dev.amendola.registroVendas.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControler {

    @GetMapping("/")
    public String telaInicial(Model model) {
        model.addAttribute("mensagem", "Bem-vindo ao Registro de Vendas!");
        return "index"; // Nome do arquivo HTML (index.html)
    }
}
