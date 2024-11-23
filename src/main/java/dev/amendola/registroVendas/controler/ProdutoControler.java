package dev.amendola.registroVendas.controler;

import dev.amendola.registroVendas.model.Produto;
import dev.amendola.registroVendas.servico.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/produtos")
public class ProdutoControler {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public String listarProdutos(Model model) {
        model.addAttribute("produtos", produtoService.listarTodos());
        model.addAttribute("produto", new Produto()); // Objeto para uso no modal
        return "produtos/lista-produtos"; // Nome do template Thymeleaf para a listagem
    }

    @PostMapping
    public String salvarProduto(@ModelAttribute Produto produto) {
        produtoService.salvar(produto);
        return "redirect:/produtos";
    }

    @GetMapping("/{id}/editar")
    @ResponseBody
    public Produto editarProduto(@PathVariable Long id) {
        return produtoService.buscarPorId(id);
    }

    @GetMapping("/{id}/excluir")
    public String excluirProduto(@PathVariable Long id) {
        produtoService.deletar(id);
        return "redirect:/produtos";
    }
}
