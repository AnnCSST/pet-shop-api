package com.pet_shop.pet_shop_api.persistencias.entity;

import jakarta.persistence.*;

import java.security.Timestamp;


@Entity

public class leerTemperatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int temperatura;

    @Column(name = "tiempo_lectura")
    private Timestamp tiempoLectura;

    @ManyToOne
    @JoinColumn(name = "dispositivo_id")
    private dispositivo dispositivo;

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public Timestamp getTiempoLectura() {
        return tiempoLectura;
    }

    public void setTiempoLectura(Timestamp tiempoLectura) {
        this.tiempoLectura = tiempoLectura;
    }

    public dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }
}



