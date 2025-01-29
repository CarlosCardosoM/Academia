/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author Carlo
 */
public class Aula {
    //declarando os atributos da minha classe
    private String tipoAula;
    private double duracao;
    private int idAula;
    private double preco;
    
    // criando o construtor da minha classe
    public Aula(String tipoAula, double duracao, int idAula, double preco) {
        
        this.tipoAula = tipoAula;
        this.duracao = duracao;
        this.idAula = idAula;
        this.preco = preco;
    }
    
    // criando os controles de acesso get e set

    public String getTipoAula() {
        return tipoAula;
    }

    public void setTipoAula(String tipoAula) {
        this.tipoAula = tipoAula;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public int getIdAula() {
        return idAula;
    }

    public void setIdAula(int idAula) {
        this.idAula = idAula;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Aula{" + "tipoAula=" + tipoAula + ", duracao=" + duracao + ", idAula=" + idAula + ", preco=" + preco + '}';
    }
    
    
    
    
}
