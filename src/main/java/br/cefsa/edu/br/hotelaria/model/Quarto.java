package br.cefsa.edu.br.hotelaria.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_QUARTO", schema = "HOTEL")
public class Quarto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "ID_QUARTO")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idQuarto;

    @Column(name = "NUMERO", nullable = false, unique = true, length = 6)
    private int numero;

    @Column(name = "NOME", nullable = false, unique = true, length = 50)
    private String nome;

    @Column(name = "VALOR", nullable = false)
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "PADRAO_ID", nullable = false)
    private Padrao padrao;

    @ManyToOne
    @JoinColumn(name = "TIPO_QUARTO_ID", nullable = false)
    private TipoQuarto tipoQuarto;

    @OneToMany(mappedBy = "quarto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Indisponibilidade> indisponibilidades = new ArrayList<>();

    public Quarto() {
    }

    public Quarto(int numero, String nome, BigDecimal valor, Padrao padrao, TipoQuarto tipoQuarto) {
        this.numero = numero;
        this.setNome(nome);
        this.valor = valor;
        this.padrao = padrao;
        this.tipoQuarto = tipoQuarto;
    }

    public UUID getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(UUID idQuarto) {
        this.idQuarto = idQuarto;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            this.nome = obterNomeQuarto();
        } else {
            this.nome = nome;
        }
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Padrao getPadrao() {
        return padrao;
    }

    public void setPadrao(Padrao padrao) {
        this.padrao = padrao;
    }

    public TipoQuarto getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(TipoQuarto tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    public List<Indisponibilidade> getIndisponibilidades() {
        return indisponibilidades;
    }

    public void setIndisponibilidades(List<Indisponibilidade> indisponibilidades) {
        this.indisponibilidades = indisponibilidades;
    }

    public void addIndisponibilidade(Indisponibilidade indisponibilidade) {
        this.indisponibilidades.add(indisponibilidade);
    }

    private String obterNomeQuarto() {
        return this.getNumero() + "_" + padrao.getNome().toUpperCase() + "_" + tipoQuarto.getNome().replace(" ", "_").toUpperCase();
    }

    public BigDecimal calcularValor() {
        if (this.tipoQuarto == null || this.tipoQuarto.getValor() == null) {
            throw new IllegalStateException("Tipo de quarto ou valor do tipo de quarto não informado.");
        }
    
        if (this.padrao == null || this.padrao.getPercentual() == null) {
            throw new IllegalStateException("Padrão ou percentual do padrão não informado.");
        }
    
        // Multiplica o valor base do tipo de quarto pelo percentual do padrão
        return ((BigDecimal) this.tipoQuarto.getValor()).multiply((BigDecimal) this.padrao.getPercentual());
    }
    
}
