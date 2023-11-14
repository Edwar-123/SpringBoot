/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.respontec.stilochain.controller;

import com.respontec.stilochain.model.clienteModel;
import com.respontec.stilochain.service.EmailService;
import com.respontec.stilochain.service.clienteService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jseba
 */
@RestController
@RequestMapping("/cliente")
public class clienteController {

    @Autowired
    private clienteService service;

    @GetMapping
    public ArrayList<clienteModel> getClientes() {
        return this.service.getClientes();
    }

    @PostMapping("/guardar")
    public clienteModel saveCliente(@RequestBody clienteModel model) {
        return this.service.saveCliente(model);
    }

    @GetMapping(path = "/{docCli}")
    public Optional<clienteModel> getById(@PathVariable("docCli") String docCli) {
        return this.service.getById(docCli);
    }

    @PutMapping(path = "/{docCli}")
    public clienteModel updateClienteById(@RequestBody clienteModel request, @PathVariable String docCli) {
        return this.service.updateById(request, docCli);
    }

    @DeleteMapping(path = "/{docCli}")
    public String deleteById(@PathVariable("docCli") String docCli) {
        boolean ok = this.service.deleteCliente(docCli);
        if (ok) {
            return "cliente eliminado";
        } else {
            return "Error";
        }
    }
    
    @GetMapping("/cliente/corcli/{doccli}")
    public List<String> getCorCliByDocCli(@PathVariable String doccli) {
        List<String> corCliList = service.findCorCliByDocCli(doccli);
        return (corCliList);
    }
    
    @GetMapping("/correo/{corcli}")
    public int buscarCorreo(@PathVariable("corcli") String corcli){
        return this.service.buscarCorreo(corcli);
    }
    


}
