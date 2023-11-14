/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.respontec.stilochain.controller;

import com.respontec.stilochain.model.adminModel;
import com.respontec.stilochain.service.adminService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jseba
 */
@RestController
@RequestMapping("/admin")
public class adminController {
        @Autowired
    private adminService service;
    
    @GetMapping
    public ArrayList<adminModel> getAdmin(){
        return this.service.getAdmin();
    }
    
}
