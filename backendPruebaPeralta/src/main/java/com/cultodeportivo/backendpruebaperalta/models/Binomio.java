package com.cultodeportivo.backendpruebaperalta.models;

import jakarta.persistence.*;

@Entity
@Table(name = "binomios")
public class Binomio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "presidente")
    private String presidente;

    @Column(name = "vicepresidente")
    private String vicepresidente;

    @Column(name = "partido")
    private String partido;

    @Column(name = "numero_lista")
    private String numeroLista;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPresidente() {
        return presidente;
    }

    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }

    public String getVicepresidente() {
        return vicepresidente;
    }

    public void setVicepresidente(String vicepresidente) {
        this.vicepresidente = vicepresidente;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public String getNumeroLista() {
        return numeroLista;
    }

    public void setNumeroLista(String numeroLista) {
        this.numeroLista = numeroLista;
    }
}
