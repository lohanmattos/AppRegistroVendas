package dev.amendola.registroVendas.repository;

import dev.amendola.registroVendas.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {
    List<Venda> findTop5ByOrderByDataHoraDesc();

}
