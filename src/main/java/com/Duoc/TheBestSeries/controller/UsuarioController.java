package com.Duoc.TheBestSeries.controller;
import com.Duoc.TheBestSeries.model.Usuario_Serie;
import com.Duoc.TheBestSeries.service.UsuarioService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioservice;
    
    // crear usuario
    @PostMapping
    public ResponseEntity<Usuario_Serie> Crearusuario(@Valid @RequestBody Usuario_Serie usuario) {
        System.out.println("[UsuarioController] -> Creando usuario");
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioservice.crearusuario(usuario));
    }


    // modificar datos de un usuario
    @PutMapping
    public ResponseEntity<Usuario_Serie> actualizarusuario(@Valid @RequestBody Usuario_Serie usuario){
        System.out.println("Actualizacion de Usuario");
        Usuario_Serie actualizarusuario = usuarioservice.updateUsuario(usuario);
        return ResponseEntity.ok(actualizarusuario);
    }
        

    // eliminar un usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarusuario(@PathVariable int id){
        System.out.println("Eliminando usuario");
        usuarioservice.eliminarusuario(id);
        return ResponseEntity.ok("Usuario eliminado correctamente");
    }



    // mostrar un usuario por su id
    
    @GetMapping("/{id}")
    public ResponseEntity<Usuario_Serie> mostrarusuarioporid(@PathVariable int id){
        System.out.println("Buscando usuario por id");
        Usuario_Serie usuario = usuarioservice.mostrarporid(id);
        return ResponseEntity.ok(usuario);
    }


}

