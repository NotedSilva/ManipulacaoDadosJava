package br.com.fintech.BancoDados;

import br.com.fintech.dao.ClienteDAO;
import br.com.fintech.dao.ContaDAO;
import br.com.fintech.dao.TransacaoDAO;
import br.com.fintech.model.Cliente;
import br.com.fintech.model.Conta;
import br.com.fintech.model.Transacao;

import java.util.List;

public class Teste {
    public static void main(String[] args) {
        // Teste ClienteDAO
        ClienteDAO clienteDAO = new ClienteDAO();
        ContaDAO contaDAO = new ContaDAO(); // Mover a instância de ContaDAO para cima

        // Criar novo cliente
        Cliente novoCliente = new Cliente("João Silva", "joao.silva@example.com");
        clienteDAO.insert(novoCliente);

        // Recuperar o cliente inserido (deve retornar o ID gerado pelo banco)
        List<Cliente> clientes = clienteDAO.getAll();
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente encontrado!");
            return;  // Sair se não há clientes
        }

        Cliente clienteInserido = clientes.get(0); // Pega o primeiro cliente inserido (neste caso, o "João Silva")
        System.out.println("Cliente inserido: " + clienteInserido);

        // Criar nova conta para o cliente inserido
        Conta novaConta = new Conta();
        novaConta.setClienteId(clienteInserido.getId()); // Usar o ID do cliente inserido
        novaConta.setSaldo(0.0); // Ou outro valor inicial
        contaDAO.insert(novaConta); // Insere a conta no banco

        // Recuperar a conta inserida
        List<Conta> contas = contaDAO.getAll();
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta encontrada!");
            return;  // Sair se não há contas
        }

        Conta contaInserida = contas.get(0); // Pega a primeira conta inserida
        System.out.println("Conta inserida: " + contaInserida);

        // Teste TransacaoDAO
        TransacaoDAO transacaoDAO = new TransacaoDAO();

        // Criar nova transação para a conta inserida
        Transacao novaTransacao = new Transacao(contaInserida.getId(), 200.00, "DEPOSITO");
        transacaoDAO.insert(novaTransacao); // Insere a transação no banco

        // Recuperar a transação inserida
        List<Transacao> transacoes = transacaoDAO.getAll();
        if (transacoes.isEmpty()) {
            System.out.println("Nenhuma transação encontrada!");
            return;  // Sair se não há transações
        }

        for (Transacao transacao : transacoes) {
            System.out.println("Transação inserida: " + transacao);
        }
    }
}
