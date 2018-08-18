package com.surpreenda.projetosocial.controller;

import com.surpreenda.projetosocial.domain.Pessoa;
import com.surpreenda.projetosocial.services.PessoaService;
import com.surpreenda.projetosocial.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService service){
        this.pessoaService = service;
    }

    @GetMapping("/list")
    public ResponseEntity findAll(){
        return ResponseEntity.ok(this.pessoaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity findOne(@PathVariable Long id){
        return ResponseEntity.ok(this.pessoaService.findOne(id));
    }

    @GetMapping("/buscar/{cpf}")
    public ResponseEntity findByCpf(@PathVariable String cpf){
        return ResponseEntity.ok(this.pessoaService.findByCpf(cpf));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Pessoa pessoa){
        try {
            return ResponseEntity.ok(this.pessoaService.save(pessoa));
        }catch (ObjectNotFoundException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Pessoa pessoa){
        try {
            return ResponseEntity.ok(this.pessoaService.save(pessoa));
        }catch (ObjectNotFoundException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        try {
            this.pessoaService.delete(id);
            return ResponseEntity.ok().build();

        }catch (ObjectNotFoundException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
