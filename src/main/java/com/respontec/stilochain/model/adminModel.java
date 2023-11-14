/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.respontec.stilochain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author jseba
 */
@Entity
@Table(name = "admi")
public class adminModel {
    @Id
    
    @Column(name = "conadmin")
    private String conadmin;

    public String getConadmin() {
        return conadmin;
    }

    public void setConadmin(String conadmin) {
        this.conadmin = conadmin;
    }
    
}
