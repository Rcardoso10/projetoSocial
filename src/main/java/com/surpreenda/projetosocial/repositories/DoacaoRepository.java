package com.surpreenda.projetosocial.repositories;

import com.surpreenda.projetosocial.domain.Doacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoacaoRepository extends JpaRepository<Doacao, Long> {

    List<Doacao> findAll();

    Doacao findOne (Long id);

    Doacao save (Doacao doacao);

    void delete (Long id);
}
