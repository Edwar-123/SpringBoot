/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.respontec.stilochain.service;

import com.respontec.stilochain.dao.IRolDao;
import com.respontec.stilochain.model.rolModel;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */

@Service
public class rolService {
    
    @Autowired
    IRolDao dao;
    
    public ArrayList<rolModel> get(){
        return (ArrayList<rolModel>)dao.findAll();
    }
    
}
