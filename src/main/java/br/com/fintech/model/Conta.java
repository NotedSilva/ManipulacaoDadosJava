package br.com.fintech.model;

public class Conta {
    private int id;
    private int clienteId;
    private double saldo;

    // Construtor vazio
    public Conta() {
    }

    // Construtor com todos os campos
    public Conta(int id, int clienteId, double saldo) {
        this.id = id;
        this.clienteId = clienteId;
        this.saldo = saldo;
    }

    // Construtor sem id (para inserção)
    public Conta(int clienteId, double saldo) {
        this.clienteId = clienteId;
        this.saldo = saldo;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Conta [id=" + id + ", clienteId=" + clienteId + ", saldo=" + saldo + "]";
    }
}
