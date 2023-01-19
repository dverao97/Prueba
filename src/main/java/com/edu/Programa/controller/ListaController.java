package com.edu.Programa.controller;

import com.edu.Programa.model.Lista;
import com.edu.Programa.service.ListaSercvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ListaController {
    @Autowired
    ListaSercvice listaSercvice;

    @GetMapping("/lists")
    public ResponseEntity<List<Lista>> obtenerLista(){
        return new ResponseEntity<>(listaSercvice.findByAll(), HttpStatus.OK);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Lista>buscarId(@PathVariable Integer id){
        return new ResponseEntity<>(listaSercvice.findById(id),HttpStatus.OK);
    }


    @PostMapping("/crear")
    public ResponseEntity<Lista> crear(@RequestBody Lista l){
        return new ResponseEntity<>(listaSercvice.save(l),HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Lista>actualizar(@RequestBody Lista l,@PathVariable Integer id){
        Lista li=listaSercvice.findById(id);
        li.setName(l.getName());
        li.setDescription(l.getDescription());
        return new ResponseEntity<>(listaSercvice.save(li),HttpStatus.CREATED);
    }
    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Integer id){
        listaSercvice.delete(id);
    }
}
