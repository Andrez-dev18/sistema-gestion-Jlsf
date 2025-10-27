package com.vivo.vivoare.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class provinciaVivo {

    private int id;
    private int ano;
    private String mes;
    private String provincia;
    private String zona;
    private String compra;
    private String tipo_cliente;
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
    private int gamboa;
    private int asoc_sondor;

    private int otras_granjas_chicas;

    private int potencial_minimo;
    private int potencial_maximo;
    private String condicion_ptmax;

    private String observaciones;

}
