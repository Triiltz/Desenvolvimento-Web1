package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.domain.Aluno;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO extends GenericDAO {
    public void insert(Aluno aluno) {
        String sql = "INSERT INTO Aluno (nome, cpf, data_nascimento, email, telefone, endereco, altura, peso, objetivo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            statement.setString(1, aluno.getNome());
            statement.setString(2, aluno.getCpf());
            statement.setDate(3, new java.sql.Date(aluno.getDataNascimento().getTime()));
            statement.setString(4, aluno.getEmail());
            statement.setString(5, aluno.getTelefone());
            statement.setString(6, aluno.getEndereco());
            statement.setFloat(7, aluno.getAltura());
            statement.setFloat(8, aluno.getPeso());
            statement.setString(9, aluno.getObjetivo());
            statement.executeUpdate();
            
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    aluno.setId(generatedKeys.getLong(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Aluno> getAll() {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM Aluno";
        
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String nome = resultSet.getString("nome");
                String cpf = resultSet.getString("cpf");
                Date dataNascimento = resultSet.getDate("data_nascimento");
                String email = resultSet.getString("email");
                String telefone = resultSet.getString("telefone");
                String endereco = resultSet.getString("endereco");
                Float altura = resultSet.getFloat("altura");
                Float peso = resultSet.getFloat("peso");
                String objetivo = resultSet.getString("objetivo");
                
                Aluno aluno = new Aluno(id, nome, cpf, dataNascimento, email, telefone, endereco, altura, peso, objetivo);
                alunos.add(aluno);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return alunos;
    }

    // Implementar update, delete e getById seguindo o mesmo padrão
    public void update(Aluno aluno) {
        String sql = "UPDATE Aluno SET nome = ?, cpf = ?, data_nascimento = ?, email = ?, telefone = ?, endereco = ?, altura = ?, peso = ?, objetivo = ? WHERE id = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            
            statement.setString(1, aluno.getNome());
            statement.setString(2, aluno.getCpf());
            statement.setDate(3, new java.sql.Date(aluno.getDataNascimento().getTime()));
            statement.setString(4, aluno.getEmail());
            statement.setString(5, aluno.getTelefone());
            statement.setString(6, aluno.getEndereco());
            statement.setFloat(7, aluno.getAltura());
            statement.setFloat(8, aluno.getPeso());
            statement.setString(9, aluno.getObjetivo());
            statement.setLong(10, aluno.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void delete(Long id) {
        String sql = "DELETE FROM Aluno WHERE id = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Aluno getById(Long id) {
        Aluno aluno = null;
        String sql = "SELECT * FROM Aluno WHERE id = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String cpf = resultSet.getString("cpf");
                Date dataNascimento = resultSet.getDate("data_nascimento");
                String email = resultSet.getString("email");
                String telefone = resultSet.getString("telefone");
                String endereco = resultSet.getString("endereco");
                Float altura = resultSet.getFloat("altura");
                Float peso = resultSet.getFloat("peso");
                String objetivo = resultSet.getString("objetivo");
                
                aluno = new Aluno(id, nome, cpf, dataNascimento, email, telefone, endereco, altura, peso, objetivo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return aluno;
    }
    public Aluno getByCpf(String cpf) {
        Aluno aluno = null;
        String sql = "SELECT * FROM Aluno WHERE cpf = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            
            statement.setString(1, cpf);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String nome = resultSet.getString("nome");
                Date dataNascimento = resultSet.getDate("data_nascimento");
                String email = resultSet.getString("email");
                String telefone = resultSet.getString("telefone");
                String endereco = resultSet.getString("endereco");
                Float altura = resultSet.getFloat("altura");
                Float peso = resultSet.getFloat("peso");
                String objetivo = resultSet.getString("objetivo");
                
                aluno = new Aluno(id, nome, cpf, dataNascimento, email, telefone, endereco, altura, peso, objetivo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return aluno;
    }
    public List<Aluno> getByNome(String nome) {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM Aluno WHERE nome LIKE ?";
        
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            
            statement.setString(1, "%" + nome + "%");
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String cpf = resultSet.getString("cpf");
                Date dataNascimento = resultSet.getDate("data_nascimento");
                String email = resultSet.getString("email");
                String telefone = resultSet.getString("telefone");
                String endereco = resultSet.getString("endereco");
                Float altura = resultSet.getFloat("altura");
                Float peso = resultSet.getFloat("peso");
                String objetivo = resultSet.getString("objetivo");
                
                Aluno aluno = new Aluno(id, nome, cpf, dataNascimento, email, telefone, endereco, altura, peso, objetivo);
                alunos.add(aluno);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return alunos;
    }
}