package br.edu.fesa.hotelaria.repository;

import br.edu.fesa.hotelaria.model.Padrao;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PadraoRepository extends JpaRepository<Padrao, UUID> {

    // Método para buscar um padrão pelo nome
    Optional<Padrao> findByNome(String nome);
}
