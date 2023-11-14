/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.respontec.stilochain.controller;

import com.respontec.stilochain.model.estadoModel;
import com.respontec.stilochain.service.estadoService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Sena CSET
 */

@RestController
@RequestMapping(value = "/estado")
public class estadoController {
    
    @Autowired
    private estadoService service;
    
    @GetMapping
    public ArrayList<estadoModel> getEstados(){
        return this.service.getEstados();
    }
    
}
