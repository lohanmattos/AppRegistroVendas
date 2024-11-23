package dev.amendola.registroVendas.controler;

import dev.amendola.registroVendas.model.Venda;
import dev.amendola.registroVendas.model.Produto;
import dev.amendola.registroVendas.model.Voluntario;
import dev.amendola.registroVendas.servico.VendaService;
import dev.amendola.registroVendas.servico.ProdutoService;
import dev.amendola.registroVendas.servico.VoluntarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/vendas")
public class VendaControler {

    @Autowired
    private VendaService vendaService;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private VoluntarioService voluntarioService;

    // Listar todas as vendas
    @GetMapping
    public String listarVendas(Model model) {
        List<Venda> vendas = vendaService.listarTodas();
        model.addAttribute("vendas", vendas);
        return "vendas/lista-vendas";
    }

    // Salvar uma nova venda
    @PostMapping
    public String salvarVenda(@ModelAttribute Venda venda) {
        vendaService.salvar(venda);
        return "redirect:/vendas";
    }

    // Obter os dados de uma venda para edição
    @GetMapping("/{id}/editar")
    @ResponseBody
    public Venda editarVenda(@PathVariable Long id) {
        return vendaService.buscarPorId(id);
    }

    // Excluir uma venda
    @GetMapping("/{id}/excluir")
    public String excluirVenda(@PathVariable Long id) {
        vendaService.deletar(id);
        return "redirect:/vendas";
    }
}
