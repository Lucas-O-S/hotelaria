package br.cefsa.edu.br.hotelaria.model;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_TIPO_QUARTO", schema = "HOTEL")
public class TipoQuarto {

    @Id
    @Column(name = "ID_TIPO_QUARTO")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idTipoQuarto;
    @Column(name = "NOME", nullable = false, unique = true, length = 30)
    private String nome;
    @Column(name = "SIGLA", nullable = false, unique = true, length = 30)
    private String sigla;
    @Column(name = "VALOR", nullable = false)
    private BigDecimal valor;

    public TipoQuarto() {

    }

    public TipoQuarto(String nome, String sigla, BigDecimal valor) {
        this.nome = nome;
        this.sigla = sigla;
        this.valor = valor;
    }

    public TipoQuarto(UUID idTipoQuarto, String nome, String sigla, BigDecimal valor) {
        this.idTipoQuarto = idTipoQuarto;
        this.nome = nome;
        this.sigla = sigla;
        this.valor = valor;
    }

    public UUID getIdTipoQuarto() {
        return idTipoQuarto;
    }

    public void setIdTipoQuarto(UUID idTipoQuarto) {
        this.idTipoQuarto = idTipoQuarto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}