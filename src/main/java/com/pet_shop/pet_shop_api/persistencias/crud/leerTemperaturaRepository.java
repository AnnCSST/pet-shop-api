package com.pet_shop.pet_shop_api.persistencias.crud;

import com.pet_shop.pet_shop_api.persistencias.entity.leerTemperatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface leerTemperaturaRepository extends JpaRepository<leerTemperatura, Integer> {

// Metodo para buscar los datos que terminen en 4

    @Repository
    public interface LeerTemperaturaRepository extends JpaRepository<leerTemperatura, Long> {
        List<leerTemperatura> findByTemperaturaLessThan(Integer valor);
    }




// Metodo para buscar la temperatura de manera ascendente

List<leerTemperatura> findAllByOrderByTemperaturaAsc();
}
