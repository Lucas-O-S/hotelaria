package br.cefsa.edu.br.hotelaria.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.cefsa.edu.br.hotelaria.model.Padrao;

@Repository
public interface PadraoRepository extends JpaRepository<Padrao, UUID> {

    // Método para buscar um padrão pelo nome
    Optional<Padrao> findByNome(String nome);
}
