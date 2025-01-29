/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;


/**
 *
 * @author Carlo
 */
public class Venda {
    private int matriculaAluno;
    private int idProduto;
    private int quantidade;
    private Data dataVenda; // Adicionando o atributo Data

    // Construtor da classe Venda
    public Venda(int matriculaAluno, int idProduto, int quantidade, Data dataVenda) {
        this.matriculaAluno = matriculaAluno;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.dataVenda = dataVenda;
    }

    // Métodos get
    public int getMatriculaAluno() {
        return matriculaAluno;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Data getDataVenda() {
        return dataVenda; // Método get para a data
    }

    @Override
    public String toString() {
        return "Venda{" +
                "matriculaAluno=" + matriculaAluno +
                ", idProduto=" + idProduto +
                ", quantidade=" + quantidade +
                ", dataVenda=" + dataVenda +
                '}';
    }
}
