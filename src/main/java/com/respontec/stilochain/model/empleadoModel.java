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
 * @author Omar
 */

@Entity
@Table(name = "empleado")
public class empleadoModel {
    
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "docemp")
    private String docemp;
    
    @Column(name = "nomemp")
    private String nomemp;
    
    @Column(name = "apeemp")
    private String apeemp;
    
    @Column(name = "telemp")
    private String telemp;
    
    @Column(name = "coremp")
    private String coremp;
    
    @Column(name = "conemp")
    private String conemp;
    
    @Column(name = "estemp")
    private int estemp;
    
    @Column(name = "ocuemp")
    private String ocuemp;
    
    @Column (name = "bloqueado")
    private String bloqueado;
    
    @Column(name = "id_servicio", nullable = true)
    private Integer id_servicio;
    
    @Column (name = "id_rol")
    private int id_rol;
    

    public String getDocemp() {
        return docemp;
    }

    public void setDocemp(String docemp) {
        this.docemp = docemp;
    }

    public String getNomemp() {
        return nomemp;
    }

    public void setNomemp(String nomemp) {
        this.nomemp = nomemp;
    }

    public String getApeemp() {
        return apeemp;
    }

    public void setApeemp(String apeemp) {
        this.apeemp = apeemp;
    }

    public String getTelemp() {
        return telemp;
    }

    public void setTelemp(String telemp) {
        this.telemp = telemp;
    }

    public String getCoremp() {
        return coremp;
    }

    public void setCoremp(String coremp) {
        this.coremp = coremp;
    }

    public String getConemp() {
        return conemp;
    }

    public void setConemp(String conemp) {
        this.conemp = conemp;
    }

    public int getEstemp() {
        return estemp;
    }

    public void setEstemp(int estemp) {
        this.estemp = estemp;
    }

    public String getOcuemp() {
        return ocuemp;
    }

    public void setOcuemp(String ocuemp) {
        this.ocuemp = ocuemp;
    }

    public String getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(String bloqueado) {
        this.bloqueado = bloqueado;
    }

    public Integer getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(Integer id_servicio) {
        this.id_servicio = id_servicio;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    
}
