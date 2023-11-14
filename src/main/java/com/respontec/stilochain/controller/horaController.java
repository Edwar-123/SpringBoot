/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.respontec.stilochain.controller;

import com.respontec.stilochain.model.horaModel;
import com.respontec.stilochain.service.horaService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Sena CSET
 */
@RestController
@RequestMapping("/hora")
public class horaController {

    @Autowired
    private horaService servi;

    @GetMapping
    public ArrayList<horaModel> gethora() {
        return this.servi.gethora();
    }

    @GetMapping(path = "/{id}")
    public Optional<horaModel> getByid(@PathVariable("id") String id) {
        return this.servi.gethoraid(id);

    }

    @PostMapping("/guardar")
    public horaModel savehora(@RequestBody horaModel model) {
        return this.servi.savehora(model);
    }

    @GetMapping("/servi/{idservi}")
    public List<horaModel> findByIdservi(@PathVariable("idservi") String idservi) {
        return this.servi.findByIdservi(idservi);
    }

    @PutMapping(path = "/{id}")
    public horaModel updateById(@RequestBody horaModel request, @PathVariable int id) {
        return this.servi.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("documento") int id) {
        boolean ok = this.servi.deleteHora(id);
        if (ok) {
            return "Empleado eliminado";
        } else {
            return "Error";
        }
    }
    
    @DeleteMapping("/delete/{idservi}")
    public String deleteHoraByServi(@PathVariable int idservi) {
        servi.eliminarHoraPorIdServicio(idservi);
        return "Hora eliminada para el servicio con ID: " + idservi;
    }

}
