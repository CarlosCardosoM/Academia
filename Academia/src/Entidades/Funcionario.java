/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author Carlo
 */
public class Funcionario extends Pessoa {
    //declarando os atributos da minha classe
    private int id;
    private int senha;
    private String cargo;
    
    // criando o construtor da minha classe
    public Funcionario(int id, int senha, String cargo, String nome, String endereco, int telefone) {
        super(nome, endereco, telefone);
        this.id = id;
        this.senha = senha;
        this.cargo = cargo;
    }
    
    // criando os controles de acesso get e set
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "id=" + id + ", senha=" + senha + ", cargo=" + cargo + '}';
    }
    
    
}
