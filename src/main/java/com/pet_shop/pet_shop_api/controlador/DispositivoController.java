package com.pet_shop.pet_shop_api.controlador;

import com.pet_shop.pet_shop_api.persistencias.entity.dispositivo;
import com.pet_shop.pet_shop_api.domain.service.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/dispositivos")
public class DispositivoController {

    private final DispositivoService dispositivoService;

    @Autowired
    public DispositivoController(DispositivoService dispositivoService) {
        this.dispositivoService = dispositivoService;
    }

    @GetMapping
    public ResponseEntity<List<dispositivo>> getAllDispositivos() {
        List<dispositivo> dispositivos = dispositivoService.getAllDispositivos();
        return new ResponseEntity<>(dispositivos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<dispositivo> getDispositivoById(@PathVariable int id) {
        Optional<dispositivo> dispositivo = dispositivoService.getDispositivoById(id);
        return dispositivo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<dispositivo> createDispositivo(@RequestBody dispositivo dispositivo) {
        dispositivo savedDispositivo = dispositivoService.saveDispositivo(dispositivo);
        return new ResponseEntity<>(savedDispositivo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<dispositivo> updateDispositivo(@PathVariable int id, @RequestBody dispositivo dispositivo) {
        if (dispositivoService.getDispositivoById(id).isPresent()) {
            dispositivo.setId(id);
            dispositivo updatedDispositivo = dispositivoService.saveDispositivo(dispositivo);
            return new ResponseEntity<>(updatedDispositivo, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDispositivo(@PathVariable int id) {
        if (dispositivoService.getDispositivoById(id).isPresent()) {
            dispositivoService.deleteDispositivo(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<dispositivo>> searchDispositivos(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String localizacion,
            @RequestParam(defaultValue = "false") boolean and) {

        List<dispositivo> dispositivos;
        if (and) {
            dispositivos = dispositivoService.findByNombreAndLocalizacion(nombre, localizacion);
        } else {
            dispositivos = dispositivoService.findByNombreOrLocalizacion(nombre, localizacion);
        }
        return new ResponseEntity<>(dispositivos, HttpStatus.OK);
    }
}

