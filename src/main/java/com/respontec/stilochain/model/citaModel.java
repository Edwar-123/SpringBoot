/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.respontec.stilochain.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author jseba
 */
@Entity
@Table(name = "cita")
public class citaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "codcit")
    private int codCit;
    
     @Column(name = "docclixcit")
    private String docClixCit;
    
    @Column(name = "horcita")
    private String horCita;
    
    @Column(name = "feccita")
    private String fecCita;
    
    @Column(name = "docempcita")
    private String docEmpCita;

    public int getCodCit() {
        return codCit;
    }

    public void setCodCit(int codCit) {
        this.codCit = codCit;
    }

    public String getDocClixCit() {
        return docClixCit;
    }

    public void setDocClixCit(String docClixCit) {
        this.docClixCit = docClixCit;
    }

    public String getHorCita() {
        return horCita;
    }

    public void setHorCita(String horCita) {
        this.horCita = horCita;
    }

    public String getFecCita() {
        return fecCita;
    }

    public void setFecCita(String fecCita) {
        this.fecCita = fecCita;
    }

    public String getDocEmpCita() {
        return docEmpCita;
    }

    public void setDocEmpCita(String docEmpCita) {
        this.docEmpCita = docEmpCita;
    }
    
}
