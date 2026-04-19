package dao;

import model.Tarefa;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TarefaDAO {

    public void adicionar(String descricao){
        String sql = "INSERT INTO tarefas (descricao) VALUES (?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, descricao);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
        }
    }

    public List<Tarefa> listar(){
        String sql = "SELECT * FROM tarefas";
        List<Tarefa> lista = new ArrayList<>();

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()){

            while(rs.next()){
                Tarefa t = new Tarefa();
                t.setId(rs.getInt("id"));
                t.setDescricao(rs.getString("descricao"));
                t.setConcluida(rs.getBoolean("consluida"));
                lista.add(t);
            }
        }
        catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
        }
        return lista;
    }

    public void concluir(int id){
        String sql = "UPDATE tarefas SET concluida = TRUE WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
        }
    }

    public void deletar(int id){
        String sql = "DELETE FROM tarefas WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
        }
    }
}
