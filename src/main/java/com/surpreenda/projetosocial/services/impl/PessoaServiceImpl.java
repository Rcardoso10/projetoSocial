package com.surpreenda.projetosocial.services.impl;

import com.surpreenda.projetosocial.domain.Pessoa;
import com.surpreenda.projetosocial.repositories.PessoaRepository;
import com.surpreenda.projetosocial.services.PessoaService;
import com.surpreenda.projetosocial.services.exception.InvalidParametersException;
import com.surpreenda.projetosocial.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaServiceImpl implements PessoaService {

    private PessoaRepository pessoaRepository;

    @Autowired
    public PessoaServiceImpl(PessoaRepository repository){
        this.pessoaRepository =  repository;
    }

    @Override
    public List<Pessoa> findAll() {
        return this.pessoaRepository.findAll();
    }

    @Override
    public Pessoa findOne(Long id) {
        if(id == null) {
            throw new InvalidParametersException("Id não pode ser nulo!");
        }
        return this.pessoaRepository.findOne(id);
    }

    @Override
    public Pessoa findByCpf(String cpf) {
        if(cpf == null){
            throw new InvalidParametersException("Cpf não existe!");
        }
        return this.pessoaRepository.findByCpf(cpf);
    }

    @Override
    public Pessoa save(Pessoa pessoa) {
        if(pessoa == null){
            throw new ObjectNotFoundException("Objeto pessoa não pode ser nulo!");
        }
        return this.pessoaRepository.save(pessoa);
    }

    @Override
    public void delete(Long id) {
        this.pessoaRepository.delete(id);
    }
}
