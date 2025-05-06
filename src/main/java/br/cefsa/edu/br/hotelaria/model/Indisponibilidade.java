package br.cefsa.edu.br.hotelaria.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import br.cefsa.edu.br.hotelaria.exception.DataInvalidaException;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
@Entity
@Table(name = "TB_INDISPONIBILIDADE", schema = "HOTEL")
public class Indisponibilidade implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "ID_INDISPONIBILIDADE")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idIndisponibilidade;

    @NotNull(message = "A data de início é obrigatória.")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "INICIO", nullable = false)
    private LocalDateTime inicio;

    @NotNull(message = "A data de término é obrigatória.")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "TERMINO")
    private LocalDateTime termino;

    @ManyToOne
    @JoinColumn(name = "STATUS_ID", nullable = false)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "QUARTO_ID", nullable = false)
    private Quarto quarto;

    public Indisponibilidade() {
    }

    public Indisponibilidade(UUID idIndisponibilidade, LocalDateTime inicio, LocalDateTime termino, Status status, Quarto quarto) {
        this.idIndisponibilidade = idIndisponibilidade;
        this.inicio = inicio;
        this.termino = termino;
        this.status = status;
        this.quarto = quarto;
    }

    public UUID getIdIndisponibilidade() {
        return idIndisponibilidade;
    }

    public void setIdIndisponibilidade(UUID idIndisponibilidade) {
        this.idIndisponibilidade = idIndisponibilidade;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getTermino() {
        return termino;
    }

    public void setTermino(LocalDateTime termino) {
        this.termino = termino;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }
    
    public void validarDatas() throws DataInvalidaException {
        if (termino.isBefore(inicio) || termino.isEqual(inicio)) {
            throw new DataInvalidaException("A data de término deve ser posterior à data de início.");
        }
    }
}