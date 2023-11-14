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
@Table(name = "cliente")
public class clienteModel {

    @Id

    @Column(name = "doccli")
    private String docCli;

    @Column(name = "concli")
    private String conCli;

    @Column(name = "nomcli")
    private String nomCli;

    @Column(name = "apecli")
    private String apeCli;

    @Column(name = "telcli")
    private String telCli;

    @Column(name = "corcli")
    private String corCli;

    public String getDocCli() {
        return docCli;
    }

    public void setDocCli(String docCli) {
        this.docCli = docCli;
    }

    public String getConCli() {
        return conCli;
    }

    public void setConCli(String conCli) {
        this.conCli = conCli;
    }

    public String getNomCli() {
        return nomCli;
    }

    public void setNomCli(String nomCli) {
        this.nomCli = nomCli;
    }

    public String getApeCli() {
        return apeCli;
    }

    public void setApeCli(String apeCli) {
        this.apeCli = apeCli;
    }

    public String getTelCli() {
        return telCli;
    }

    public void setTelCli(String telCli) {
        this.telCli = telCli;
    }

    public String getCorCli() {
        return corCli;
    }

    public void setCorCli(String corCli) {
        this.corCli = corCli;
    }

}
