package br.ufscar.dc.dsw.domain;
import java.util.Date;
import java.util.List;

public class Aluno {
    private Long id;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private String email;
    private String telefone;
    private String endereco;
    private Float altura;
    private Float peso;
    private String objetivo;
    private List<PlanoTreino> planosTreino;

    // Construtores, getters e setters
    public Aluno() {}
    
    public Aluno(Long id, String nome, String cpf, Date dataNascimento, String email, 
                String telefone, String endereco, Float altura, Float peso, String objetivo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.altura = altura;
        this.peso = peso;
        this.objetivo = objetivo;
    }

    // Getters e Setters para todos os atributos
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public Date getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public Float getAltura() {
        return altura;
    }
    public void setAltura(Float altura) {
        this.altura = altura;
    }
    public Float getPeso() {
        return peso;
    }
    public void setPeso(Float peso) {
        this.peso = peso;
    }
    public String getObjetivo() {
        return objetivo;
    }
    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }
    public List<PlanoTreino> getPlanosTreino() {
        return planosTreino;
    }
    public void setPlanosTreino(List<PlanoTreino> planosTreino) {
        this.planosTreino = planosTreino;
    }
    
}