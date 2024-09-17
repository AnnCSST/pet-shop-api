package com.pet_shop.pet_shop_api.domain.service;

import com.pet_shop.pet_shop_api.persistencias.crud.usuarioRepository;
import com.pet_shop.pet_shop_api.persistencias.entity.usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private usuarioRepository usuarioRepo;

    // Método para obtener todos los usuarios
    public List<usuario> getAllUsuarios() {
        return usuarioRepo.findAll();
    }

    // Método para obtener un usuario por su ID
    public Optional<usuario> getUsuarioById(int id) {
        return usuarioRepo.findById(id);
    }

    // Método para guardar un usuario
    public usuario saveUsuario(usuario usuario) {
        return usuarioRepo.save(usuario);
    }

    // Método para actualizar un usuario
    public usuario updateUsuario(int id, usuario usuarioDetails) {
        Optional<usuario> optionalUsuario = usuarioRepo.findById(id);

        if (optionalUsuario.isPresent()) {
            usuario existingUsuario = optionalUsuario.get();
            existingUsuario.setNombreCompleto(usuarioDetails.getNombreCompleto());
            existingUsuario.setEmail(usuarioDetails.getEmail());
            existingUsuario.setEdad(usuarioDetails.getEdad());

            return usuarioRepo.save(existingUsuario);
        } else {
            return null;
        }
    }

    // Método para eliminar un usuario
    public void deleteUsuario(int id) {
        usuarioRepo.deleteById(id);
    }

    // Método para encontrar usuarios con edad mayor a 18
    public List<usuario> getUsuariosConEdadMayorA18() {
        return usuarioRepo.findByEdadGreaterThan(18);
    }

    // Método para encontrar usuarios cuyo nombre completo no coincide con el especificado
    public List<usuario> getUsuariosConNombreDiferente(String nombreCompleto) {
        return usuarioRepo.findByNombreCompletoNotLike(nombreCompleto);
    }
}
