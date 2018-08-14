package com.surpreenda.projetosocial.services;

import com.surpreenda.projetosocial.domain.Campanha;

import java.util.List;

public interface CampanhaService {

    List<Campanha> findAll();

    Campanha findOne(Long id);

    Campanha save( Campanha campanha);

    void delete( Long id);
}
