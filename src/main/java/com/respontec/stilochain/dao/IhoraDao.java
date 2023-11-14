/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.respontec.stilochain.dao;

import com.respontec.stilochain.model.horaModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sena CSET
 */
@Repository
public interface IhoraDao extends JpaRepository<horaModel, Integer>{
    
    @Modifying
    @Query("DELETE FROM horaModel h WHERE h.idservi = :idservi")
    void deleteHoraByServi(@Param("idservi") int idservi);
    
    List<horaModel> findByIdservi(int idservi);
}
