/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.respontec.stilochain.controller;

import com.respontec.stilochain.model.empleadoImgModel;
import com.respontec.stilochain.model.empleadoModel;
import com.respontec.stilochain.service.empleadoService;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Omar
 */
@RestController
@RequestMapping("/empleado")
public class empleadoController {

    @Autowired
    private empleadoService service;

    @GetMapping
    public ResponseEntity<?> getEmpleados() {
        try {
            List<empleadoModel> empleados = this.service.getEmpleados();
            return new ResponseEntity<>(empleados, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error al recuperar empleados: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/guardar")
    public empleadoModel saveEmpleado(@RequestBody empleadoModel model) {
        return this.service.saveEmpleado(model);
    }

    @GetMapping(path = "/{documento}")
    public Optional<empleadoModel> getById(@PathVariable("documento") String documento) {
        return this.service.getById(documento);
    }

    @PutMapping(path = "/{documento}")
    public empleadoModel updateEmpleadoById(@RequestBody empleadoModel request, @PathVariable String documento) {
        return this.service.updateById(request, documento);
    }

    @PutMapping(path = "/bloquear/{documento}")
    public empleadoModel BloquearEmpleado(@RequestBody empleadoModel request, @PathVariable String documento) {
        return this.service.BloquearEmpleado(request, documento);
    }

    @DeleteMapping(path = "/{documento}")
    public String deleteById(@PathVariable("documento") String documento) {
        boolean ok = this.service.deleteEmpleado(documento);
        if (ok) {
            return "Empleado eliminado";
        } else {
            return "Error";
        }
    }

    @GetMapping(path = "/ocupacion/{ocuemp}")
    public List<empleadoModel> findByocuemp(@PathVariable("ocuemp") String ocuemp) {
        return this.service.findByocuemp(ocuemp);
    }

    @GetMapping("/empleado/coremp/{docemp}")
    public List<String> getCorCliByDocEmp(@PathVariable String docemp) {
        List<String> corEmpList = service.findCorCliByDocEmp(docemp);
        return (corEmpList);
    }

    @GetMapping("/correo/{coremp}")
    public int buscarCorreo(@PathVariable("coremp") String coremp) {
        return this.service.buscarCorreo(coremp);
    }

    @PutMapping("/imagen")
    public ResponseEntity<String> guardarimagen(@RequestBody empleadoImgModel model) {
        String result = service.guardarimagen(model);

        if (result != null && !result.isEmpty() && !result.startsWith("Error")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar la imagen.");
        }
    }

    @GetMapping("/obtener/{docemp}")
    public ResponseEntity<byte[]> obtenerImagen(@PathVariable String docemp) {
        try {
            byte[] imagenBytes = service.obtenerImagen(docemp);
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

}
