package com.surpreenda.projetosocial.services.impl;

import com.surpreenda.projetosocial.domain.Campanha;
import com.surpreenda.projetosocial.repositories.CampanhaRepository;
import com.surpreenda.projetosocial.services.CampanhaService;
import com.surpreenda.projetosocial.services.exception.InvalidParametersException;
import com.surpreenda.projetosocial.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampanhaServiceImpl implements CampanhaService {

    private CampanhaRepository campanhaRepository;

    @Autowired
    public CampanhaServiceImpl(CampanhaRepository repository){
        this.campanhaRepository = repository;
    }

    @Override
    public List<Campanha> findAll() {
        return campanhaRepository.findAll();
    }

    @Override
    public Campanha findOne(Long id) {
        if(id ==  null){
            throw new InvalidParametersException("Id não pode ser nulo!");
        }
        return this.campanhaRepository.findOne(id);
    }

    @Override
    public Campanha save(Campanha campanha) {
        if(campanha == null){
            throw new ObjectNotFoundException("Objeto campanha não pode ser nulo!");
        }

        return this.campanhaRepository.save(campanha);
    }

    @Override
    public void delete(Long id) {
        this.campanhaRepository.delete(id);
    }
}
