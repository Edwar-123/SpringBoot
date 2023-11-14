/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.respontec.stilochain.controller;

import com.respontec.stilochain.model.citaModel;
import com.respontec.stilochain.service.citaService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jseba
 */
@RestController
@RequestMapping("/cita")
public class citaController {
    @Autowired
    private citaService service;
    
    @GetMapping
    public ArrayList<citaModel> getCitas(){
        return this.service.getCitas();
    }
    
    @GetMapping(path = "/{feccita}/{horcita}/{docempcita}")
    public int fehcaHora(@PathVariable("feccita") String feccita, @PathVariable("horcita") String horcita, @PathVariable("docempcita") String docempcita){
        return this.service.fechaHora(feccita, horcita, docempcita);
    }
    
    @PostMapping("/guardar")
    public citaModel saveCita(@RequestBody citaModel model){
        return this.service.saveCita(model);
    }
    
    @GetMapping(path = "/{feccita}/{docempcita}")
    public List<String> getHorasCitas(@PathVariable("feccita") String feccita, @PathVariable("docempcita") String docempcita){
        return this.service.getHorasCitas(feccita, docempcita);
    }
    
}
