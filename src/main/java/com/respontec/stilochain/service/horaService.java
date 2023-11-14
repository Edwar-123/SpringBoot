/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.respontec.stilochain.service;

import com.respontec.stilochain.dao.IhoraDao;
import com.respontec.stilochain.model.horaModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Sena CSET
 */
@Service
public class horaService {

    @Autowired
    IhoraDao dao;

    public ArrayList<horaModel> gethora() {
        return (ArrayList<horaModel>) dao.findAll();
    }

    public Optional<horaModel> gethoraid(String id) {
        return dao.findById(Integer.parseInt(id));
    }

    public horaModel savehora(horaModel model) {
        return dao.save(model);
    }

    public List<horaModel> findByIdservi(String idservi) {
        return dao.findByIdservi(Integer.parseInt(idservi));
    }

    public horaModel updateById(horaModel request, int id) {

        horaModel hora = dao.findById(id).get();

        hora.setId(request.getId());
        hora.setIdservi(request.getIdservi());
        hora.setHora(request.getHora());

        dao.save(hora);

        return hora;
    }

    public Boolean deleteHora(int id) {
        try {
            dao.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    @Transactional
    public void eliminarHoraPorIdServicio(int idServicio) {
        dao.deleteHoraByServi(idServicio);
    }


}
