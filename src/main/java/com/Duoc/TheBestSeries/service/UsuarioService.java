package com.Duoc.TheBestSeries.service;

import com.Duoc.TheBestSeries.model.Usuario_Serie;
import com.Duoc.TheBestSeries.repository.Usuario_serie_Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {


    @Autowired
    private Usuario_serie_Repository usuarioRepository;

    // crear un usuario
    public Usuario_Serie crearusuario(Usuario_Serie usuario){
        return usuarioRepository.save(usuario);
    }

    // modificar datos de un usuario
    public Usuario_Serie updateUsuario(Usuario_Serie usuario){
        if (!usuarioRepository.existsById(usuario.getId_usuario())){
            return null;
        }
        return usuarioRepository.save(usuario);
    }

    // eliminar un usuario
    public void eliminarusuario(int id){
        usuarioRepository.deleteById(id);
    }

    // mostrar un usuario por su id
    public Usuario_Serie mostrarporid(int id){
        return usuarioRepository.findById(id).orElse(null);
    }


}
