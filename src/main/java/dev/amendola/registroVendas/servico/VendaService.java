package dev.amendola.registroVendas.servico;


import dev.amendola.registroVendas.model.Venda;
import dev.amendola.registroVendas.model.Produto;
import dev.amendola.registroVendas.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ProdutoService produtoService;

    public List<Venda> listarTodas() {
        return vendaRepository.findAll();
    }

    public Venda buscarPorId(Long id) {
        return vendaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Venda não encontrada com ID: " + id));
    }

    public Venda salvar(Venda venda) {
        // Calcular o total da venda com base no preço do produto e na quantidade
        Produto produto = produtoService.buscarPorId(venda.getProduto().getId());
        venda.setTotal(produto.getPreco() * venda.getQuantidade());
        return vendaRepository.save(venda);
    }

    public void deletar(Long id) {
        if (!vendaRepository.existsById(id)) {
            throw new IllegalArgumentException("Venda não encontrada com ID: " + id);
        }
        vendaRepository.deleteById(id);
    }
}
