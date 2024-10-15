package br.com.fintech.dao;

import br.com.fintech.bancoDados.ConexaoBanco;
import br.com.fintech.model.Conta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContaDAO {
    public void insert(Conta conta) {
        String sql = "INSERT INTO Conta (cliente_id, saldo) VALUES (?, ?)";
        try (Connection conn = ConexaoBanco.getConnection();
             PreparedStatement con = conn.prepareStatement(sql)) {
            con.setInt(1, conta.getClienteId());
            con.setDouble(2, conta.getSaldo());
            con.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Conta> getAll() {
        List<Conta> contas = new ArrayList<>();
        String sql = "SELECT * FROM Conta";
        try (Connection conn = ConexaoBanco.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Conta conta = new Conta();
                conta.setId(rs.getInt("id"));
                conta.setClienteId(rs.getInt("cliente_id"));
                conta.setSaldo(rs.getDouble("saldo"));
                contas.add(conta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contas;
    }
}
