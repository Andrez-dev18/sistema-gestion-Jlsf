package com.vivo.vivoare.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "captura_pantalla_vivo")
public class capturaPantallaVivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 20)
    private String tipo_proc;
    private int ano;
    @Column(length = 20)
    private String mes;
    @Column(length = 50)
    private String provincia;
    @Column(length = 50)
    private String zona;
    @Column(length = 10)
    private String compra;
    @Column(length = 50)
    private String tipo_cliente;
    @Column(length = 100)
    private String nombre;

    //cambos de cantidad de pollos por sector
    private int grs;
    private int rp;
    private int renzo;
    private int fafo;
    private int santa_angela;
    private int jorge_pan;
    private int mirian_g;
    private int vasquez;
    private int san_joaquin;
    private int fortunato;
    private int rosario;
    private int perca;
    private int  gamboa;
    private int asoc_sondor;
    private int pollo_lima ;
    private int otras_granjas_chicas;

    private int potencial_minimo;
    private int potencial_maximo;
    private String condicion_ptmin;
    private String condicion_ptmax;

    private String observaciones;

}
