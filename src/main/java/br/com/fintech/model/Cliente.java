package br.com.fintech.model;

public class Cliente {
    private int id;
    private String nome;
    private String email;

    // Construtor vazio
    public Cliente() {
    }

    // Construtor com todos os campos
    public Cliente(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    // Construtor sem id (para inserção)
    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nome=" + nome + ", email=" + email + "]";
    }
}
