/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.respontec.stilochain.service;

import com.respontec.stilochain.dao.IEmpleadoDao;
import com.respontec.stilochain.model.empleadoImgModel;
import com.respontec.stilochain.model.empleadoModel;
import com.respontec.stilochain.model.imagenModel;
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
public class empleadoService {

    @Autowired
    IEmpleadoDao dao;

    public ArrayList<empleadoModel> getEmpleados() {
        return (ArrayList<empleadoModel>) dao.findAll();
    }

    public empleadoModel saveEmpleado(empleadoModel model) {
        return dao.save(model);
    }

    public Optional<empleadoModel> getById(String documento) {
        return dao.findById(documento);
    }

    public empleadoModel updateById(empleadoModel request, String documento) {

        empleadoModel empleado = dao.findById(documento).get();

        empleado.setDocemp(request.getDocemp());
        empleado.setNomemp(request.getNomemp());
        empleado.setApeemp(request.getApeemp());
        empleado.setTelemp(request.getTelemp());
        empleado.setCoremp(request.getCoremp());
        empleado.setConemp(request.getConemp());
        empleado.setEstemp(request.getEstemp());
        empleado.setOcuemp(request.getOcuemp());
        empleado.setBloqueado(request.getBloqueado());
        empleado.setId_servicio(request.getId_servicio());
        empleado.setId_rol(request.getId_rol());
        dao.save(empleado);

        return empleado;
    }

    public empleadoModel BloquearEmpleado(empleadoModel request, String documento) {

        empleadoModel bloqEmpleado = dao.findById(documento).get();

        bloqEmpleado.setDocemp(request.getDocemp());
        bloqEmpleado.setBloqueado(request.getBloqueado());

        dao.save(bloqEmpleado);

        return bloqEmpleado;
    }

    public Boolean deleteEmpleado(String documento) {
        try {
            dao.deleteById(documento);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<empleadoModel> findByocuemp(String ocuemp) {
        return dao.findByocuemp(ocuemp);
    }

    public List<String> findCorCliByDocEmp(String docemp) {
        return dao.findCorCliByDocEmp(docemp);
    }

    public int buscarCorreo(String coremp) {
        return dao.buscarCorreo(coremp);
    }

    public String guardarimagen(empleadoImgModel model) {
        try {
            byte[] imagen = Base64.getDecoder().decode(model.getFoto().split(",")[1]);
            String docemp = model.getDocemp();
            dao.guardarimagen(imagen, docemp);
            return "Imagen guardada con éxito.";
        } catch (Exception e) {
            return "Error al procesar la imagen: " + e.getMessage();
        }
    }
    
    public byte[] obtenerImagen(String docemp) {
        return dao.obtenerImagen(docemp);
    }

}
