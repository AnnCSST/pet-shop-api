package com.pet_shop.pet_shop_api.persistencias.crud;

import com.pet_shop.pet_shop_api.persistencias.entity.usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface usuarioRepository extends JpaRepository<usuario, Integer> {

    // Método para encontrar usuarios con edad mayor a 18
    List<usuario> findByEdadGreaterThan(int edad);

    // Método para encontrar usuarios cuyo nombre completo no coincida con el especificado
    List<usuario> findByNombreCompletoNotLike(String nombreCompleto);
}
