package com.edu.Programa.controller;

import com.edu.Programa.model.Cancion;
import com.edu.Programa.model.Lista;
import com.edu.Programa.service.CancionService;
import com.edu.Programa.service.ListaSercvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CancionController {
    @Autowired
    CancionService cancionService;

    @GetMapping("/listarCancion")
    public ResponseEntity<List<Cancion>> obtenerLista(){
        return new ResponseEntity<>(cancionService.findByAll(), HttpStatus.OK);
    }

    @GetMapping("/listarCancion/{id}")
    public ResponseEntity<Cancion>buscarId(@PathVariable Integer id){
        return new ResponseEntity<>(cancionService.findById(id),HttpStatus.OK);
    }


    @PostMapping("/crearCancion")
    public ResponseEntity<Cancion> crear(@RequestBody Cancion c){
        return new ResponseEntity<>(cancionService.save(c),HttpStatus.CREATED);
    }

    @PutMapping("/actualizarCancion/{id}")
    public ResponseEntity<Cancion>actualizar(@RequestBody Cancion c,@PathVariable Integer id){
        Cancion ca=cancionService.findById(id);
        ca.setTitle(c.getTitle());
        ca.setArtist(c.getArtist());
        ca.setAlbum(c.getAlbum());
        ca.setYear(c.getYear());
        return new ResponseEntity<>(cancionService.save(ca),HttpStatus.CREATED);
    }
    @DeleteMapping("/eliminarCancion/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Integer id){
        cancionService.delete(id);
    }
}
