package com.surpreenda.projetosocial.repositories;

import com.surpreenda.projetosocial.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findAll();

    Usuario findOne (Long id);

    Usuario save (Usuario usuario);

    void delete (Long id);
}
