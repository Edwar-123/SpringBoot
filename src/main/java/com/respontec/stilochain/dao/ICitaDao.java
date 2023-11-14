/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.respontec.stilochain.dao;

import com.respontec.stilochain.model.citaModel;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author jseba
 */
public interface ICitaDao extends CrudRepository<citaModel, Integer>{
    
    @Query("SELECT COUNT(*) FROM citaModel c WHERE c.fecCita = :feccita AND c.horCita = :horcita AND c.docEmpCita = :docempcita")
    int countCitas (@Param("feccita") String feccita, @Param("horcita") String horcita, @Param("docempcita") String docempcita);
    
    @Query("SELECT c.horCita FROM citaModel c WHERE c.fecCita = :fecCita AND c.docEmpCita = :docEmpCita")
    List<String> getHorasCitas(@Param("fecCita") String feccita, @Param("docEmpCita") String docempcita);

}
