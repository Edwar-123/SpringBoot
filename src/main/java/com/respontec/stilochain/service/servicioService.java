/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.respontec.stilochain.service;

import com.respontec.stilochain.dao.IServicioDao;
import com.respontec.stilochain.model.imagenModel;
import com.respontec.stilochain.model.servicioModel;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Omar
 */
@Service
public class servicioService {

    @Autowired
    IServicioDao servicioDao;

    public String guardarimagen(imagenModel model) {
        try {
            byte[] imagen = Base64.getDecoder().decode(model.getImagen().split(",")[1]);
            int id = model.getId();
            servicioDao.guardarimagen(imagen, id);
            return "Imagen guardada con éxito.";
        } catch (Exception e) {
            return "Error al procesar la imagen: " + e.getMessage();
        }
    }

    public byte[] obtenerImagen(int id) {
        return servicioDao.obtenerImagen(id);
    }

    public ArrayList<servicioModel> getServicios() {
        return (ArrayList<servicioModel>) servicioDao.findAll();
    }

    public servicioModel saveServicio(servicioModel model) {
        return servicioDao.save(model);
    }

    public Optional<servicioModel> getById(int id) {
        return servicioDao.findById(id);
    }

    public servicioModel updateById(servicioModel request, int id) {
        servicioModel model = servicioDao.findById(id).get();
        model.setId(request.getId());
        model.setNombre(request.getNombre());
        model.setPrecio(request.getPrecio());
        model.setDuracion(request.getDuracion());
        servicioDao.save(model);
        return model;
    }

    public Boolean deleteById(int id) {
        try {
            servicioDao.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<String> findCitaNames() {
        return servicioDao.findCitaNames();
    }
    
    public int buscarNombre(String nombre) {
        return servicioDao.buscarNombre(nombre);
    }

}
