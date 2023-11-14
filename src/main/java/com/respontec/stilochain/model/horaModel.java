/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.respontec.stilochain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Sena CSET
 */
@Entity
@Table(name="hora")

public class horaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     
    @Column(name = "id")
    private int id;
     
    @Column(name = "idservi")
    private int idservi;
    
    @Column(name = "hora")
    private String hora;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdservi() {
        return idservi;
    }

    public void setIdservi(int idservi) {
        this.idservi = idservi;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    
}
