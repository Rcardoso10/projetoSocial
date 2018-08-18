package com.surpreenda.projetosocial.services.impl;

import com.surpreenda.projetosocial.domain.Doacao;
import com.surpreenda.projetosocial.repositories.DoacaoRepository;
import com.surpreenda.projetosocial.services.DoacaoService;
import com.surpreenda.projetosocial.services.exception.InvalidParametersException;
import com.surpreenda.projetosocial.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoacaoServiceImpl implements DoacaoService {

    private DoacaoRepository doacaoRepository;

    @Autowired
    public DoacaoServiceImpl(DoacaoRepository repository){
        this.doacaoRepository = repository;
    }

    @Override
    public List<Doacao> findAll() {
        return doacaoRepository.findAll();
    }

    @Override
    public Doacao findOne(Long id) {
        if(id == null){
            throw new InvalidParametersException("Id não pode ser nulo!");
        }
        return doacaoRepository.findOne(id);
    }

    @Override
    public Doacao save(Doacao doacao) {
        if(doacao == null){
            throw new ObjectNotFoundException("Objeto doacao não pode ser nulo!");
        }
        return this.doacaoRepository.save(doacao);
    }

    @Override
    public void delete(Long id) {
        this.doacaoRepository.delete(id);
    }
}
