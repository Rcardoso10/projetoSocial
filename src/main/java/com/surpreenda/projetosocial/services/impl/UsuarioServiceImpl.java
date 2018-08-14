package com.surpreenda.projetosocial.services.impl;

import com.surpreenda.projetosocial.domain.Usuario;
import com.surpreenda.projetosocial.repositories.UsuarioRepository;
import com.surpreenda.projetosocial.services.UsuarioService;
import com.surpreenda.projetosocial.services.exception.InvalidParametersException;
import com.surpreenda.projetosocial.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository repository){
        this.usuarioRepository = repository;
    }

    @Override
    public List<Usuario> findAll() {
        return this.usuarioRepository.findAll();
    }

    @Override
    public Usuario findOne(Long id) {
        if(id == null){
            throw new InvalidParametersException("Id não pode ser nulo!");
        }
        return this.usuarioRepository.findOne(id);
    }

    @Override
    public Usuario save(Usuario usuario) {
        if(usuario == null){
            throw new ObjectNotFoundException("Objeto usuario não pode ser nulo!");
        }
        return this.usuarioRepository.save(usuario);
    }

    @Override
    public void delete(Long id) {
        this.usuarioRepository.delete(id);
    }
}
