/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.respontec.stilochain.controller;

import com.respontec.stilochain.model.imagenModel;
import com.respontec.stilochain.model.servicioModel;
import com.respontec.stilochain.service.servicioService;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
 * @author Omar
 */
@RestController
@RequestMapping("/servicio")
public class servicioController {

    @Autowired
    private servicioService service;

    @GetMapping
    public ArrayList<servicioModel> getServicios() {
        return this.service.getServicios();
    }

    @PostMapping("/guardar")
    public servicioModel saveServicio(@RequestBody servicioModel model) {
        return this.service.saveServicio(model);
    }

    /*@PostMapping("/imagen")
    public servicioModel saveImagen(@RequestBody servicioModel model) {
    byte[] imagen = Base64.getDecoder().decode(model.getImagen_url().split(",")[1]);
        return this.service.saveServicio(model);
    }*/
    @PutMapping("/imagen")
    public ResponseEntity<String> guardarimagen(@RequestBody imagenModel model) {
        String result = service.guardarimagen(model);

        if (result != null && !result.isEmpty()) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().body("Error al guardar la imagen.");
        }
    }

    @GetMapping(path = "/{id}")
    public Optional<servicioModel> getById(@PathVariable("id") int id) {
        return this.service.getById(id);
    }

    @PutMapping(path = "/{id}")
    public servicioModel updateById(@RequestBody servicioModel request, @PathVariable int id) {
        return this.service.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") int id) {
        boolean ok = this.service.deleteById(id);
        if (ok) {
            return "Servicio eliminado";
        } else {
            return "Error";
        }
    }

    @GetMapping("/cita-names")
    public List<String> getCitaNames() {
        return service.findCitaNames();
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<byte[]> obtenerImagen(@PathVariable int id) {
        try {
            byte[] imagenBytes = service.obtenerImagen(id);
            if (imagenBytes != null) {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.IMAGE_PNG); // Puedes cambiar el tipo de contenido según el formato de tu imagen
                return new ResponseEntity<>(imagenBytes, headers, HttpStatus.OK);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @GetMapping("/nombre/{nombre}")
    public int buscarNombre(@PathVariable("nombre") String nombre) {
        return this.service.buscarNombre(nombre);
    }
}
