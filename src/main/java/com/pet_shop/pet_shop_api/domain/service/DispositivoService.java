package com.pet_shop.pet_shop_api.domain.service;

import com.pet_shop.pet_shop_api.persistencias.entity.dispositivo;
import com.pet_shop.pet_shop_api.persistencias.crud.dispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DispositivoService {

    private final dispositivoRepository dispositivoRepo;

    @Autowired
    public DispositivoService(dispositivoRepository dispositivoRepo) {
        this.dispositivoRepo = dispositivoRepo;
    }

    public List<dispositivo> getAllDispositivos() {
        return dispositivoRepo.findAll();
    }

    public Optional<dispositivo> getDispositivoById(int id) {
        return dispositivoRepo.findById(id);
    }

    public dispositivo saveDispositivo(dispositivo dispositivo) {
        return dispositivoRepo.save(dispositivo);
    }

    public void deleteDispositivo(int id) {
        dispositivoRepo.deleteById(id);
    }

    public List<dispositivo> findByNombreAndLocalizacion(String nombre, String localizacion) {
        return dispositivoRepo.findByNombreAndLocalizacion(nombre, localizacion);
    }

    public List<dispositivo> findByNombreOrLocalizacion(String nombre, String localizacion) {
        return dispositivoRepo.findBynombreOrLocalizacion(nombre, localizacion);
    }
}
