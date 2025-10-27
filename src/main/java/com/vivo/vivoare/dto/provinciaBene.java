package com.vivo.vivoare.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class provinciaBene {

    private int id;
    private int ano;
    private String mes;
    private String provincia;
    private String zona;
    private String compraGrs;
    private String tipoCliente;
    private String nombre;
    private int grs;
    private int rp;
    private int grs_vivo;
    private int santa_elena;
    private int granjas_chicas;
    private int rosario;
    private int sanfern_lima;
    private int avicola_renzo;


    private int otros;
    private int potencialMinimo;
    private int potencialMaximo;
    private String condicionPtmin;
    private String condicionPtmax;
    private String observaciones;

}
