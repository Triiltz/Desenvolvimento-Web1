package br.ufscar.dc.dsw.domain;
import java.util.Date;

public class PlanoTreino {
    private Long id;
    private String nomeTreino;
    private String tipo;
    private String descricao;
    private Integer duracaoSemanas;
    private Integer frequenciaSemanal;
    private Date dataInicio;
    private Date dataFim;
    private String observacoes;
    private Aluno aluno;

    // Construtores, getters e setters
    public PlanoTreino() {}
    
    public PlanoTreino(Long id, String nomeTreino, String tipo, String descricao, 
                      Integer duracaoSemanas, Integer frequenciaSemanal, 
                      Date dataInicio, Date dataFim, String observacoes, Aluno aluno) {
        this.id = id;
        this.nomeTreino = nomeTreino;
        this.tipo = tipo;
        this.descricao = descricao;
        this.duracaoSemanas = duracaoSemanas;
        this.frequenciaSemanal = frequenciaSemanal;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.observacoes = observacoes;
        this.aluno = aluno;
    }

    // Getters e Setters para todos os atributos
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNomeTreino() {
        return nomeTreino;
    }
    public void setNomeTreino(String nomeTreino) {
        this.nomeTreino = nomeTreino;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Integer getDuracaoSemanas() {
        return duracaoSemanas;
    }
    public void setDuracaoSemanas(Integer duracaoSemanas) {
        this.duracaoSemanas = duracaoSemanas;
    }
    public Integer getFrequenciaSemanal() {
        return frequenciaSemanal;
    }
    public void setFrequenciaSemanal(Integer frequenciaSemanal) {
        this.frequenciaSemanal = frequenciaSemanal;
    }
    public Date getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }
    public Date getDataFim() {
        return dataFim;
    }
    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }
    public String getObservacoes() {
        return observacoes;
    }
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    public Aluno getAluno() {
        return aluno;
    }
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
