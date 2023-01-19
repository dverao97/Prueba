package com.edu.Programa.service;

import com.edu.Programa.model.Lista;
import com.edu.Programa.repository.ListaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ListaServiceImpl extends GenericServiceImpl<Lista,Integer> implements ListaSercvice{
    @Autowired
    ListaRepository listaRepository;

    @Override
    public CrudRepository<Lista, Integer> getDao() {
        return listaRepository;
    }
}
