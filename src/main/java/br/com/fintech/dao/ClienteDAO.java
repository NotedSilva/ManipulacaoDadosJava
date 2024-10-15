package br.com.fintech.dao;

import br.com.fintech.BancoDados.ConexaoBanco;
import br.com.fintech.model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public void insert(Cliente cliente) {
        String sql = "INSERT INTO CLIENTE (NOME, EMAIL) VALUES (?, ?)";

        try (Connection connection = ConexaoBanco.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir cliente", e);
        }
    }

    public List<Cliente> getAll() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM CLIENTE";

        try (Connection connection = ConexaoBanco.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String nome = rs.getString("NOME");
                String email = rs.getString("EMAIL");

                Cliente cliente = new Cliente(nome, email);
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao consultar clientes", e);
        }
        return clientes;
    }
}
