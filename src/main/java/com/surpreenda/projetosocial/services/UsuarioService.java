package com.surpreenda.projetosocial.services;

import com.surpreenda.projetosocial.domain.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> findAll();

    Usuario findOne( Long id );

    Usuario save( Usuario usuario );

    void delete( Long id );
}
