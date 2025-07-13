package br.ufscar.dc.dsw.domain;

import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import br.ufscar.dc.dsw.validation.UniqueCPF;

@SuppressWarnings("serial")
@Entity
@Table(name = "Aluno")
public class Aluno extends AbstractEntity<Long> {

    @NotBlank(message = "{NotBlank.aluno.nome}")
    @Size(min = 3, max = 100)
    @Column(nullable = false, length = 100)
    private String nome;

    @UniqueCPF(message = "{Unique.aluno.cpf}")
    @NotBlank
    @Size(min = 14, max = 14, message = "{Size.aluno.cpf}")
    @Column(nullable = false, unique = true, length = 14)
    private String cpf;

    @NotNull(message = "{NotNull.aluno.dataNascimento}")
    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataNascimento;

    @NotBlank
    @Email(message = "{Email.aluno.email}")
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(length = 15)
    private String telefone;

    @Size(max = 255)
    @Column(length = 255)
    private String endereco;
    
    @NotNull(message = "{NotNull.aluno.altura}")
    @Positive(message = "{Positive.aluno.altura}")
    @Column(nullable = false, columnDefinition = "DECIMAL(3,2)")
    private Float altura;
    
    @NotNull(message = "{NotNull.aluno.peso}")
    @Positive(message = "{Positive.aluno.peso}")
    @Column(nullable = false, columnDefinition = "DECIMAL(5,2)")
    private Float peso;
    
    @Column(length = 100)
    private String objetivo;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<PlanoTreino> planosTreino;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public Float getAltura() { return altura; }
    public void setAltura(Float altura) { this.altura = altura; }
    public Float getPeso() { return peso; }
    public void setPeso(Float peso) { this.peso = peso; }
    public String getObjetivo() { return objetivo; }
    public void setObjetivo(String objetivo) { this.objetivo = objetivo; }
    public List<PlanoTreino> getPlanosTreino() { return planosTreino; }
    public void setPlanosTreino(List<PlanoTreino> planosTreino) { this.planosTreino = planosTreino; }
}