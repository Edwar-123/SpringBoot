/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.respontec.stilochain.service;

import com.respontec.stilochain.dao.IAdminDao;
import com.respontec.stilochain.model.adminModel;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jseba
 */
@Service
public class adminService {
    @Autowired
    IAdminDao dao;
    
    public ArrayList<adminModel> getAdmin(){
        return (ArrayList<adminModel>) dao.findAll();
    }
    
}
