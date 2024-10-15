package br.com.fintech.model;

import java.sql.Timestamp;

public class Transacao {
    private int id;
    private int contaId;
    private double valor;
    private String tipo;
    private Timestamp dataTransacao;

    // Construtor vazio
    public Transacao() {
    }

    // Construtor com todos os campos
    public Transacao(int id, int contaId, double valor, String tipo, Timestamp dataTransacao) {
        this.id = id;
        this.contaId = contaId;
        this.valor = valor;
        this.tipo = tipo;
        this.dataTransacao = dataTransacao;
    }

    // Construtor sem id (para inserção)
    public Transacao(int contaId, double valor, String tipo) {
        this.contaId = contaId;
        this.valor = valor;
        this.tipo = tipo;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContaId() {
        return contaId;
    }

    public void setContaId(int contaId) {
        this.contaId = contaId;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Timestamp getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Timestamp dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    @Override
    public String toString() {
        return "Transacao [id=" + id + ", contaId=" + contaId + ", valor=" + valor + ", tipo=" + tipo + ", dataTransacao=" + dataTransacao + "]";
    }
}
