/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adapter;

/**
 *
 * @author Carlo
 */
public class PagamentoAdapter implements ProcessadorPagamento {
    private SistemaExterno sistemaExterno;

    public PagamentoAdapter(SistemaExterno sistemaExterno) {
        this.sistemaExterno = sistemaExterno;
    }

    @Override
    public boolean realizarPagamento(double valor, int matriculaAluno) {
        return sistemaExterno.processarPagamento(valor, matriculaAluno);
    }

    @Override
    public String verificarStatusPagamento(int matriculaAluno) {
        return sistemaExterno.obterStatusPagamento(matriculaAluno);
    }
}
    

