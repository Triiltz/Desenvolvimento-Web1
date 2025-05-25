package br.ufscar.dc.dsw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AcessaBD {

    public static void main(String[] args) {
        try {
            // Setup para uso do banco de dados MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Academia?useTimezone=true&serverTimezone=GMT-3";
            Connection con = DriverManager.getConnection(url, "user", "password");

            Statement stmt = con.createStatement();

            String sql = """
                SELECT a.nome AS aluno_nome, pt.nome_treino, pt.tipo, pt.duracao_semanas,
                       pt.frequencia_semanal, pt.data_inicio, pt.data_fim, pt.observacoes
                FROM PlanoTreino pt
                INNER JOIN Aluno a ON pt.aluno_id = a.id
            """;

            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("Planos de Treino por Aluno:");

            while (rs.next()) {
                System.out.println("Aluno: " + rs.getString("aluno_nome"));
                System.out.println("Treino: " + rs.getString("nome_treino"));
                System.out.println("Tipo: " + rs.getString("tipo"));
                System.out.println("Duração (semanas): " + rs.getInt("duracao_semanas"));
                System.out.println("Frequência semanal: " + rs.getInt("frequencia_semanal"));
                System.out.println("Início: " + rs.getDate("data_inicio"));
                System.out.println("Fim: " + rs.getDate("data_fim"));
                System.out.println("Observações: " + rs.getString("observacoes"));
                System.out.println("-------------------------------------------");
            }

            stmt.close();
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("A classe do driver de conexão não foi encontrada!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("O comando SQL não pode ser executado!");
        }
    }
}
