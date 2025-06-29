package br.ufscar.dc.dsw.domain;

import java.time.LocalDate;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings("serial")
@Entity
@Table(name = "PlanoTreino")
public class PlanoTreino extends AbstractEntity<Long> {

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String nomeTreino;

    @Size(max = 50)
    @Column(length = 50)
    private String tipo;

    @Column(columnDefinition = "TEXT")
    private String descricao;
    
    @NotNull
    @Positive
    @Column(nullable = false)
    private Integer duracaoSemanas;
    
    @NotNull
    @Min(1) @Max(7)
    @Column(nullable = false)
    private Integer frequenciaSemanal;
    
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(nullable = false)
    private LocalDate dataInicio;
    
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(nullable = false)
    private LocalDate dataFim;
    
    @Column(columnDefinition = "TEXT")
    private String observacoes;

    @NotNull(message = "{NotNull.planoTreino.aluno}")
    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    public String getNomeTreino() { return nomeTreino; }
    public void setNomeTreino(String nomeTreino) { this.nomeTreino = nomeTreino; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Integer getDuracaoSemanas() { return duracaoSemanas; }
    public void setDuracaoSemanas(Integer duracaoSemanas) { this.duracaoSemanas = duracaoSemanas; }
    public Integer getFrequenciaSemanal() { return frequenciaSemanal; }
    public void setFrequenciaSemanal(Integer frequenciaSemanal) { this.frequenciaSemanal = frequenciaSemanal; }
    public LocalDate getDataInicio() { return dataInicio; }
    public void setDataInicio(LocalDate dataInicio) { this.dataInicio = dataInicio; }
    public LocalDate getDataFim() { return dataFim; }
    public void setDataFim(LocalDate dataFim) { this.dataFim = dataFim; }
    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
    public Aluno getAluno() { return aluno; }
    public void setAluno(Aluno aluno) { this.aluno = aluno; }
}