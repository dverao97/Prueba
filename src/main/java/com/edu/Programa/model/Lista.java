package com.edu.Programa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Lista {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_lista")
    private Integer id_lista;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;


    @OneToMany(mappedBy = "lista")
    private List<Cancion> songs;
}
