package br.ufscar.dc.dsw.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.PlanoTreino;
import br.ufscar.dc.dsw.domain.Aluno;

public class PlanoTreinoDAO extends GenericDAO {
    public void insert(PlanoTreino planoTreino) {
        String sql = "INSERT INTO PlanoTreino (nome_treino, tipo, descricao, duracao_semanas, frequencia_semanal, data_inicio, data_fim, observacoes, aluno_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            statement.setString(1, planoTreino.getNomeTreino());
            statement.setString(2, planoTreino.getTipo());
            statement.setString(3, planoTreino.getDescricao());
            statement.setInt(4, planoTreino.getDuracaoSemanas());
            statement.setInt(5, planoTreino.getFrequenciaSemanal());
            statement.setDate(6, new java.sql.Date(planoTreino.getDataInicio().getTime()));
            statement.setDate(7, new java.sql.Date(planoTreino.getDataFim().getTime()));
            statement.setString(8, planoTreino.getObservacoes());
            statement.setLong(9, planoTreino.getAluno().getId());
            statement.executeUpdate();
            
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    planoTreino.setId(generatedKeys.getLong(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<PlanoTreino> getAll() {
        List<PlanoTreino> planos = new ArrayList<>();
        String sql = "SELECT p.*, a.nome as aluno_nome FROM PlanoTreino p INNER JOIN Aluno a ON p.aluno_id = a.id";
        
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String nomeTreino = resultSet.getString("nome_treino");
                String tipo = resultSet.getString("tipo");
                String descricao = resultSet.getString("descricao");
                Integer duracaoSemanas = resultSet.getInt("duracao_semanas");
                Integer frequenciaSemanal = resultSet.getInt("frequencia_semanal");
                Date dataInicio = resultSet.getDate("data_inicio");
                Date dataFim = resultSet.getDate("data_fim");
                String observacoes = resultSet.getString("observacoes");
                
                // Criar objeto Aluno básico apenas com id e nome
                Aluno aluno = new Aluno();
                aluno.setId(resultSet.getLong("aluno_id"));
                aluno.setNome(resultSet.getString("aluno_nome"));
                
                PlanoTreino planoTreino = new PlanoTreino(id, nomeTreino, tipo, descricao, duracaoSemanas, 
                                                         frequenciaSemanal, dataInicio, dataFim, observacoes, aluno);
                planos.add(planoTreino);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return planos;
    }

    // Implementar update, delete e getById seguindo o mesmo padrão
    public void update(PlanoTreino planoTreino) {
        String sql = "UPDATE PlanoTreino SET nome_treino = ?, tipo = ?, descricao = ?, duracao_semanas = ?, frequencia_semanal = ?, data_inicio = ?, data_fim = ?, observacoes = ?, aluno_id = ? WHERE id = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            
            statement.setString(1, planoTreino.getNomeTreino());
            statement.setString(2, planoTreino.getTipo());
            statement.setString(3, planoTreino.getDescricao());
            statement.setInt(4, planoTreino.getDuracaoSemanas());
            statement.setInt(5, planoTreino.getFrequenciaSemanal());
            statement.setDate(6, new java.sql.Date(planoTreino.getDataInicio().getTime()));
            statement.setDate(7, new java.sql.Date(planoTreino.getDataFim().getTime()));
            statement.setString(8, planoTreino.getObservacoes());
            statement.setLong(9, planoTreino.getAluno().getId());
            statement.setLong(10, planoTreino.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void delete(Long id) {
        String sql = "DELETE FROM PlanoTreino WHERE id = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public PlanoTreino getById(Long id) {
        PlanoTreino planoTreino = null;
        String sql = "SELECT p.*, a.nome as aluno_nome FROM PlanoTreino p INNER JOIN Aluno a ON p.aluno_id = a.id WHERE p.id = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                String nomeTreino = resultSet.getString("nome_treino");
                String tipo = resultSet.getString("tipo");
                String descricao = resultSet.getString("descricao");
                Integer duracaoSemanas = resultSet.getInt("duracao_semanas");
                Integer frequenciaSemanal = resultSet.getInt("frequencia_semanal");
                Date dataInicio = resultSet.getDate("data_inicio");
                Date dataFim = resultSet.getDate("data_fim");
                String observacoes = resultSet.getString("observacoes");
                
                // Criar objeto Aluno básico apenas com id e nome
                Aluno aluno = new Aluno();
                aluno.setId(resultSet.getLong("aluno_id"));
                aluno.setNome(resultSet.getString("aluno_nome"));
                
                planoTreino = new PlanoTreino(id, nomeTreino, tipo, descricao, duracaoSemanas, 
                                              frequenciaSemanal, dataInicio, dataFim, observacoes, aluno);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return planoTreino;
    }
    public List<PlanoTreino> getByAlunoId(Long alunoId) {
        List<PlanoTreino> planos = new ArrayList<>();
        String sql = "SELECT p.*, a.nome as aluno_nome FROM PlanoTreino p INNER JOIN Aluno a ON p.aluno_id = a.id WHERE p.aluno_id = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            
            statement.setLong(1, alunoId);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String nomeTreino = resultSet.getString("nome_treino");
                String tipo = resultSet.getString("tipo");
                String descricao = resultSet.getString("descricao");
                Integer duracaoSemanas = resultSet.getInt("duracao_semanas");
                Integer frequenciaSemanal = resultSet.getInt("frequencia_semanal");
                Date dataInicio = resultSet.getDate("data_inicio");
                Date dataFim = resultSet.getDate("data_fim");
                String observacoes = resultSet.getString("observacoes");
                
                // Criar objeto Aluno básico apenas com id e nome
                Aluno aluno = new Aluno();
                aluno.setId(resultSet.getLong("aluno_id"));
                aluno.setNome(resultSet.getString("aluno_nome"));
                
                PlanoTreino planoTreino = new PlanoTreino(id, nomeTreino, tipo, descricao, duracaoSemanas, 
                                                         frequenciaSemanal, dataInicio, dataFim, observacoes, aluno);
                planos.add(planoTreino);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return planos;
    }
}