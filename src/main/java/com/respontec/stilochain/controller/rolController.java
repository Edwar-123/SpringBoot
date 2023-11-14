/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.respontec.stilochain.controller;

import com.respontec.stilochain.model.rolModel;
import com.respontec.stilochain.service.rolService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ACER
 */

@RestController
@RequestMapping("/rol")
public class rolController {
    
    @Autowired
    private rolService service;
    
    @GetMapping
    public ArrayList<rolModel> get(){
        return this.service.get();
    }
    
}
