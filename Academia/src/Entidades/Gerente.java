/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author Carlo
 */
public class Gerente extends Funcionario {

    // criando o construtor da minha classe
    public Gerente(int id, int senha, String nome, String endereco, int telefone) {
        super(id, senha, "Gerente", nome, endereco, telefone);
    }
}
