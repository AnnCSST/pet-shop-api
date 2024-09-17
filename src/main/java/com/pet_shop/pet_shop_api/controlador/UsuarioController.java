package com.pet_shop.pet_shop_api.controlador;

import com.pet_shop.pet_shop_api.persistencias.entity.usuario;
import com.pet_shop.pet_shop_api.domain.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")


public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Obtener todos los usuarios
    @GetMapping
    public List<usuario> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    // Obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<usuario> getUsuarioById(@PathVariable int id) {
        Optional<usuario> usuario = usuarioService.getUsuarioById(id);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Guardar un nuevo usuario
    @PostMapping
    public usuario saveUsuario(@RequestBody usuario usuario) {
        return usuarioService.saveUsuario(usuario);
    }

    // Actualizar un usuario existente
    @PutMapping("/{id}")
    public ResponseEntity<usuario> updateUsuario(@PathVariable int id, @RequestBody usuario usuarioDetails) {
        usuario updatedUsuario = usuarioService.updateUsuario(id, usuarioDetails);
        if (updatedUsuario != null) {
            return ResponseEntity.ok(updatedUsuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un usuario por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable int id) {
        usuarioService.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }

    // Obtener usuarios con edad mayor a 18
    @GetMapping("/mayores-de-edad")
    public List<usuario> getUsuariosConEdadMayorA18() {
        return usuarioService.getUsuariosConEdadMayorA18();
    }

    // Obtener usuarios cuyo nombre completo no coincide con el especificado
    @GetMapping("/nombre-no-es")
    public List<usuario> getUsuariosConNombreDiferente(@RequestParam String nombreCompleto) {
        return usuarioService.getUsuariosConNombreDiferente(nombreCompleto);
    }
}

