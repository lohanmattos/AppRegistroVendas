package dev.amendola.registroVendas.servico;

import dev.amendola.registroVendas.model.Voluntario;
import dev.amendola.registroVendas.repository.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoluntarioService {

    @Autowired
    private VoluntarioRepository voluntarioRepository;

    public List<Voluntario> listarTodos() {
        return voluntarioRepository.findAll();
    }

    public Voluntario buscarPorId(Long id) {
        return voluntarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Voluntário não encontrado com ID: " + id));
    }

    public Voluntario salvar(Voluntario voluntario) {
        return voluntarioRepository.save(voluntario);
    }

    public void deletar(Long id) {
        if (!voluntarioRepository.existsById(id)) {
            throw new IllegalArgumentException("Voluntário não encontrado com ID: " + id);
        }
        voluntarioRepository.deleteById(id);
    }

}
