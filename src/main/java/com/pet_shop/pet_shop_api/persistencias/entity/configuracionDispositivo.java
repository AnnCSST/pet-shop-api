package com.pet_shop.pet_shop_api.persistencias.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "configuracion_dispositivo")
public class configuracionDispositivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "detalles_configuracion")
    private String detallesConfiguracion;

    @OneToOne
    @JoinColumn(name = "dispositivo_id", unique = true)
    private dispositivo dispositivo;

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetallesConfiguracion() {
        return detallesConfiguracion;
    }

    public void setDetallesConfiguracion(String detallesConfiguracion) {
        this.detallesConfiguracion = detallesConfiguracion;
    }

    public dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }
}
