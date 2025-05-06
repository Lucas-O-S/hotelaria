/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefsa.edu.br.hotelaria.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
    private BigDecimal percentual;

    public Padrao() {
    }

    public Padrao(String nome, BigDecimal percentual) {
        this.nome = nome;
        this.percentual = percentual;
    }

    public Padrao(UUID idPadrao, String nome, BigDecimal percentual) {
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

    public BigDecimal getPercentual() {
        return percentual;
    }

    public void setPercentual(BigDecimal percentual) {
        this.percentual = percentual;
    }
}

