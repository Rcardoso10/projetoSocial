package com.surpreenda.projetosocial.repositories;

import com.surpreenda.projetosocial.domain.Campanha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampanhaRepository extends JpaRepository<Campanha, Long> {

    List<Campanha> findAll();

    Campanha findOne(Long id);

    Campanha save(Campanha campanha);

    void delete( Long id);

}
