package br.com.fintech.dao;

import br.com.fintech.bancoDados.ConexaoBanco;
import br.com.fintech.model.Transacao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransacaoDAO {
    public void insert(Transacao transacao) {
        String sql = "INSERT INTO Transacao (conta_id, valor, tipo) VALUES (?, ?, ?)";
        try (Connection conn = ConexaoBanco.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, transacao.getContaId());
            stmt.setDouble(2, transacao.getValor());
            stmt.setString(3, transacao.getTipo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Transacao> getAll() {
        List<Transacao> transacoes = new ArrayList<>();
        String sql = "SELECT * FROM Transacao";
        try (Connection conn = ConexaoBanco.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Transacao transacao = new Transacao();
                transacao.setId(rs.getInt("id"));
                transacao.setContaId(rs.getInt("conta_id"));
                transacao.setValor(rs.getDouble("valor"));
                transacao.setTipo(rs.getString("tipo"));
                transacao.setDataTransacao(rs.getTimestamp("data_transacao"));
                transacoes.add(transacao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transacoes;
    }
}
