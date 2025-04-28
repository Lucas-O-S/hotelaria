/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fesa.hotelaria.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

/**
 *
 * STANDARD(1, "Standard", 1), MASTER(2, "Master", 1.2), DELUXE(3, "Deluxe",
 * 1.4);
 *
 * @author Israel
 */
@Entity
@Table(name = "TB_PADRAO", schema = "HOTEL")
public class Padrao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "ID_PADRAO")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idPadrao;
    @Column(name = "NOME", nullable = false, unique = true, length = 20)
    private String nome;
    @Column(name = "PERCENTUAL", nullable = false)
    private double percentual;

    public Padrao() {
    }

    public Padrao(String nome, double percentual) {
        this.nome = nome;
        this.percentual = percentual;
    }

    public Padrao(UUID idPadrao, String nome, double percentual) {
        this.idPadrao = idPadrao;
        this.nome = nome;
        this.percentual = percentual;
    }

    public UUID getIdPadrao() {
        return idPadrao;
    }

    public void setIdPadrao(UUID idPadrao) {
        this.idPadrao = idPadrao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPercentual() {
        return percentual;
    }

    public void setPercentual(double percentual) {
        this.percentual = percentual;
    }
}

