/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.respontec.stilochain.dao;

import com.respontec.stilochain.model.adminModel;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jseba
 */
public interface IAdminDao extends CrudRepository<adminModel, String>{
    
}
