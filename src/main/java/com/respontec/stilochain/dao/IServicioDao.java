/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.respontec.stilochain.dao;

import com.respontec.stilochain.model.imagenModel;
import com.respontec.stilochain.model.servicioModel;
import java.util.List;
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
public interface IServicioDao extends CrudRepository<servicioModel, Integer> {

    @Query("SELECT c.nombre FROM servicioModel c")
    List<String> findCitaNames();

    @Transactional
    @Modifying
    @Query(value = "UPDATE servicio SET imagen_url = ?1 WHERE id = ?2", nativeQuery = true)
    void guardarimagen(byte[] converterimage, int id);

    @Query(value = "SELECT imagen_url FROM servicio WHERE id = ?1", nativeQuery = true)
    byte[] obtenerImagen(int id);

    @Query("SELECT COUNT(*) FROM servicioModel e WHERE e.nombre = :nombre")
    int buscarNombre(@Param("nombre") String nombre);

}
