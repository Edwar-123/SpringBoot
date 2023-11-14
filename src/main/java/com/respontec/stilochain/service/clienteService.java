/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.respontec.stilochain.service;

import com.respontec.stilochain.dao.IClienteDao;
import com.respontec.stilochain.model.clienteModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jseba
 */
@Service
public class clienteService {

    @Autowired
    IClienteDao dao;

    public ArrayList<clienteModel> getClientes() {
        return (ArrayList<clienteModel>) dao.findAll();
    }

    public clienteModel saveCliente(clienteModel model) {
        return dao.save(model);
    }

    public Optional<clienteModel> getById(String docCli) {
        return dao.findById(docCli);
    }

    public clienteModel updateById(clienteModel request, String docCli) {

        clienteModel cliente = dao.findById(docCli).get();

        cliente.setDocCli(request.getDocCli());
        cliente.setNomCli(request.getNomCli());
        cliente.setApeCli(request.getApeCli());
        cliente.setTelCli(request.getTelCli());
        cliente.setCorCli(request.getCorCli());
        cliente.setConCli(request.getConCli());

        dao.save(cliente);

        return cliente;
    }

    public Boolean deleteCliente(String docCli) {
        try {
            dao.deleteById(docCli);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<String> findCorCliByDocCli(String doccli) {
        return dao.findCorCliByDocCli(doccli);
    }

    public int buscarCorreo(String corcli){
        return dao.buscarCorreo(corcli);
    }
}
