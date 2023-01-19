package com.edu.Programa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cancion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cancion")
    private Integer id_cancion;
    @Column(name = "title")
    private String title;
    @Column(name = "artist")
    private String artist;
    @Column(name = "album")
    private String album;
    @Column(name = "year")
    private Integer year;

    @ManyToOne
    @JoinColumn(name="id_lista",referencedColumnName = "id_lista")
    private Lista lista;
}
