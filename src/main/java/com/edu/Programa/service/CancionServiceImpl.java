package com.edu.Programa.service;

import com.edu.Programa.model.Cancion;
import com.edu.Programa.repository.CancionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CancionServiceImpl extends GenericServiceImpl<Cancion,Integer> implements CancionService{
    @Autowired
    CancionRepository cancionRepository;
    @Override
    public CrudRepository<Cancion, Integer> getDao() {
        return cancionRepository;
    }
}
