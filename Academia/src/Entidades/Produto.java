/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import academia.SistemaCentral;

/**
 *
 * @author Carlo
 */
public class Produto {
    // Declarando os atributos da minha classe
    private int id;
    private String nome;
    private int quantidade;
    private Double preco;

    // Criando o construtor da minha classe
    public Produto(int id, String nome, int quantidade, Double preco) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        SistemaCentral.incrementarContadorProdutos(); // Incrementa contador ao criar um produto
    }

    // Métodos get e set
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    // toString
    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", nome=" + nome + ", quantidade=" + quantidade + ", preco=" + preco + '}';
    }
}
    

