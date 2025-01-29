/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author Carlo
 */
public class VendaPlano {
    private int matriculaAluno;
    private String tipoPlano;
    private double valor;
    private Data dataVenda;

    // Construtor para inicializar a venda do plano
    public VendaPlano(int matriculaAluno, String tipoPlano, double valor, Data dataVenda) {
        this.matriculaAluno = matriculaAluno;
        this.tipoPlano = tipoPlano;
        this.valor = valor;
        this.dataVenda = dataVenda;
    }

    public int getMatriculaAluno() {
        return matriculaAluno;
    }

    public void setMatriculaAluno(int matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
    }

    public String getTipoPlano() {
        return tipoPlano;
    }

    public void setTipoPlano(String tipoPlano) {
        this.tipoPlano = tipoPlano;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Data getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Data dataVenda) {
        this.dataVenda = dataVenda;
    }

   

    @Override
    public String toString() {
        return "VendaPlano{" +
                "Matrícula do Aluno=" + matriculaAluno +
                ", Tipo de Plano='" + tipoPlano + '\'' +
                ", Valor= R$" + valor +
                ", Data da Venda=" + dataVenda +
                '}';
    }
}

