package com.surpreenda.projetosocial.controller;

import com.surpreenda.projetosocial.domain.Campanha;
import com.surpreenda.projetosocial.services.CampanhaService;
import com.surpreenda.projetosocial.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/campanha")
public class CampanhaController {

    private CampanhaService campanhaService;

    @Autowired
    public CampanhaController(CampanhaService service){
        this.campanhaService = service;
    }

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(this.campanhaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity findOne(@PathVariable Long id){
        return ResponseEntity.ok(this.campanhaService.findOne(id));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Campanha campanha){
        try {
            return ResponseEntity.ok(this.campanhaService.save(campanha));
        }catch (ObjectNotFoundException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Campanha campanha){
        try {
            return ResponseEntity.ok(this.campanhaService.save(campanha));
        }catch (ObjectNotFoundException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        try {
            campanhaService.delete(id);
            return ResponseEntity.ok().build();
        }catch (ObjectNotFoundException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
