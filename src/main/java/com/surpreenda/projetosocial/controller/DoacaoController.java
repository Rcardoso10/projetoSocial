package com.surpreenda.projetosocial.controller;

import com.surpreenda.projetosocial.domain.Doacao;
import com.surpreenda.projetosocial.services.DoacaoService;
import com.surpreenda.projetosocial.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doacao")
public class DoacaoController {

    private DoacaoService doacaoService;

    @Autowired
    public DoacaoController(DoacaoService service){
        this.doacaoService =  service;
    }

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(this.doacaoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity findOne(@PathVariable Long id){
        return ResponseEntity.ok(this.doacaoService.findOne(id));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Doacao doacao){
        try {
            return ResponseEntity.ok(this.doacaoService.save(doacao));
        }catch (ObjectNotFoundException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Doacao doacao){
        try {
            return ResponseEntity.ok(this.doacaoService.save(doacao));
        }catch (ObjectNotFoundException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete (@PathVariable Long id){
        try {
            doacaoService.delele(id);
            return ResponseEntity.ok().build();
        }catch (ObjectNotFoundException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
