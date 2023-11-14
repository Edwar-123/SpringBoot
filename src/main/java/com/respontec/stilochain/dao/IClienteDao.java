/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.respontec.stilochain.dao;

import com.respontec.stilochain.model.clienteModel;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jseba
 */
@Repository
public interface IClienteDao extends CrudRepository<clienteModel, String> {

    @Query("SELECT c.corCli FROM clienteModel c WHERE c.docCli = :doccli")
    List<String> findCorCliByDocCli(String doccli);

    @Query("SELECT COUNT(*) FROM clienteModel c WHERE c.corCli = :corcli")
    int buscarCorreo (@Param("corcli") String corcli);
}
