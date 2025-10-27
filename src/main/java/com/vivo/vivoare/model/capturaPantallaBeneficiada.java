package com.vivo.vivoare.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "captura_pantalla_beneficiado")
@Data
public class capturaPantallaBeneficiada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tipo_proc", nullable = false, length = 50)
    private String tipo_proc; // 'Arequipa Beneficiado' o 'Provincia Beneficiado'

    @Column(nullable = false)
    private int ano;

    @Column(nullable = false, length = 20)
    private String mes;

    private String provincia;
    private String zona;

    @Column(name = "compra_grs")
    private String compraGrs;

    @Column(name = "tipo_cliente")
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


    private int avelino;
    private int peladores;
    private int avicruz;
    private int rafael;
    private int matilde;
    private int avirox;
    private int julia;
    private int simon;
    private int yesica;
    private int gabriel;
    private int arturo;
    private int nicolas;
    private int luis_f;
    private int mirella;
    private int otros;

    @Column(name = "potencial_minimo")
    private int potencialMinimo;
    @Column(name = "potencial_maximo")
    private int potencialMaximo;
    @Column(name = "condicion_ptmin", length = 255)
    private String condicionPtmin;
    @Column(name = "condicion_ptmax", length = 255)
    private String condicionPtmax;
    @Column(length = 255)
    private String observaciones;

}
