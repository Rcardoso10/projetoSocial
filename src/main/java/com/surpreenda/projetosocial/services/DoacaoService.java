package com.surpreenda.projetosocial.services;

import com.surpreenda.projetosocial.domain.Doacao;
import java.util.List;

public interface DoacaoService {

    List<Doacao> findAll();

    Doacao findOne(Long id);

    Doacao save(Doacao doacao);

    void delete (Long id);

}
