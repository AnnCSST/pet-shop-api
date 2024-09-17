package com.pet_shop.pet_shop_api.persistencias.entity;

import jakarta.persistence.*;

@Entity
public class usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private int id;


    private String nombreCompleto;
    private String email;
    private int edad;

    // Getter y setter para 'id'
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter y setter para 'nombreCompleto'
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    // Getter y setter para 'email'
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter para 'edad' (este faltaba)
    public int getEdad() {
        return edad;
    }

    // Setter para 'edad'
    public void setEdad(int edad) {
        this.edad = edad;
    }
}
