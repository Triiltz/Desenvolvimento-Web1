package br.ufscar.dc.dsw;

import br.ufscar.dc.dsw.dao.IAlunoDAO;
import br.ufscar.dc.dsw.dao.IPlanoTreinoDAO;
import br.ufscar.dc.dsw.domain.Aluno;
import br.ufscar.dc.dsw.domain.PlanoTreino;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class AcademiaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcademiaApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(IAlunoDAO alunoDAO, IPlanoTreinoDAO planoTreinoDAO) {
        return (args) -> {
            
            if (alunoDAO.count() > 0) {
                return;
            }

            Aluno a1 = new Aluno();
            a1.setNome("Carlos Silva");
            a1.setCpf("123.456.789-00");
            a1.setEmail("carlos@email.com");
            a1.setDataNascimento(LocalDate.of(1995, 6, 15));
            a1.setTelefone("(16)99999-1111");
            a1.setEndereco("Rua A, 100");
            a1.setAltura(1.75f);
            a1.setPeso(82.5f);
            a1.setObjetivo("Hipertrofia");
            alunoDAO.save(a1);

            Aluno a2 = new Aluno();
            a2.setNome("Ana Souza");
            a2.setCpf("987.654.321-00");
            a2.setEmail("ana@email.com");
            a2.setDataNascimento(LocalDate.of(1998, 3, 22));
            a2.setTelefone("(16)98888-2222");
            a2.setEndereco("Rua B, 200");
            a2.setAltura(1.62f);
            a2.setPeso(58.3f);
            a2.setObjetivo("Definição");
            alunoDAO.save(a2);

            PlanoTreino p1 = new PlanoTreino();
            p1.setNomeTreino("Treino A");
            p1.setTipo("Hipertrofia");
            p1.setDescricao("Foco em membros superiores");
            p1.setDuracaoSemanas(8);
            p1.setFrequenciaSemanal(5);
            p1.setDataInicio(LocalDate.of(2024, 5, 1));
            p1.setDataFim(LocalDate.of(2024, 6, 26));
            p1.setObservacoes("Incluir progressão de carga");
            p1.setAluno(a1);
            planoTreinoDAO.save(p1);
            
            PlanoTreino p2 = new PlanoTreino();
            p2.setNomeTreino("Treino B");
            p2.setTipo("Cardio + Força");
            p2.setDescricao("Circuito funcional");
            p2.setDuracaoSemanas(6);
            p2.setFrequenciaSemanal(3);
            p2.setDataInicio(LocalDate.of(2024, 5, 5));
            p2.setDataFim(LocalDate.of(2024, 6, 15));
            p2.setObservacoes("Monitorar frequência cardíaca");
            p2.setAluno(a2);
            planoTreinoDAO.save(p2);
        };
    }
}