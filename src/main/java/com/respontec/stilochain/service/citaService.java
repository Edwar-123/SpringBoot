/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.respontec.stilochain.service;

import com.respontec.stilochain.dao.ICitaDao;
import com.respontec.stilochain.model.citaModel;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jseba
 */
@Service
public class citaService {
        @Autowired
    ICitaDao dao;
    
    public ArrayList<citaModel> getCitas(){
        return (ArrayList<citaModel>) dao.findAll();
    }
    
    public citaModel saveCita(citaModel model){
        return dao.save(model);
    }
    
    public int fechaHora(String feccita, String horcita, String docempcita){
        return dao.countCitas(feccita, horcita, docempcita);
    }
    
    public List<String> getHorasCitas(String feccita, String docempcita){
        return dao.getHorasCitas(feccita, docempcita);
    }
}
