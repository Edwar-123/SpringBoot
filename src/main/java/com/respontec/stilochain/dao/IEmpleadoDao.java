/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.respontec.stilochain.dao;

import com.respontec.stilochain.model.empleadoModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Omar
 */

@Repository
public interface IEmpleadoDao extends JpaRepository<empleadoModel, String>{
    
    List<empleadoModel> findByocuemp(String ocuemp);
    
    @Query("SELECT COUNT(*) FROM empleadoModel e WHERE e.coremp = :coremp")
    int buscarCorreo(@Param("coremp") String coremp);
    
    @Query("SELECT c.coremp FROM empleadoModel c WHERE c.docemp = :docemp")
    List<String> findCorCliByDocEmp(String docemp);
    
    @Transactional
    @Modifying
    @Query(value = "UPDATE empleado SET foto_url = ?1 WHERE docemp = ?2", nativeQuery = true)
    void guardarimagen(byte[] converterimage, String docemp);
    
    @Query(value = "SELECT foto_url FROM empleado WHERE docemp = ?1", nativeQuery = true)
    byte[] obtenerImagen(String docemp);
}
