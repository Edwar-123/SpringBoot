/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.respontec.stilochain.service;

import com.respontec.stilochain.dao.IEstadoDao;
import com.respontec.stilochain.model.estadoModel;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sena CSET
 */

@Service
public class estadoService {
    
    @Autowired
    IEstadoDao dao;
    
    public ArrayList<estadoModel> getEstados(){
        return (ArrayList<estadoModel>) dao.findAll();
    }
    
}
