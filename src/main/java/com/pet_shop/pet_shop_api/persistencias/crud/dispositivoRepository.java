package com.pet_shop.pet_shop_api.persistencias.crud;
import com.pet_shop.pet_shop_api.persistencias.entity.dispositivo;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface dispositivoRepository extends JpaRepository<dispositivo, Integer> {

    // Metodo para buscar el nombre y la localizacion si a y b
    List<dispositivo> findByNombreAndLocalizacion(String nombre, String localizacion);

    // Metodo para buscar el nombre y localizacion si a o b
    List<dispositivo> findBynombreOrLocalizacion(String nombre, String localizacion);

}
