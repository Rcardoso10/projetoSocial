package com.surpreenda.projetosocial.controller;

import com.surpreenda.projetosocial.domain.Usuario;
import com.surpreenda.projetosocial.services.UsuarioService;
import com.surpreenda.projetosocial.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService service){
        this.usuarioService =  service;
    }

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(this.usuarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity findOne(@PathVariable Long id){
        return ResponseEntity.ok(this.usuarioService.findOne(id));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Usuario usuario){
        try {
            return ResponseEntity.ok(this.usuarioService.save(usuario));
        }catch (ObjectNotFoundException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Usuario usuario){
        try {
            return ResponseEntity.ok(this.usuarioService.save(usuario));
        }catch (ObjectNotFoundException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        try {
            usuarioService.delete(id);
            return ResponseEntity.ok().build();
        }catch (ObjectNotFoundException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
