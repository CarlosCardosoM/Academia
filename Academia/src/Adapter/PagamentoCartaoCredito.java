/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adapter;

/**
 *
 * @author Carlo
 */
public class PagamentoCartaoCredito implements ProcessadorPagamento {
    private SistemaExterno sx;

    // Construtor que recebe o sistema externo de pagamento
    public PagamentoCartaoCredito(SistemaExterno sistemaExterno) {
        this.sx = sistemaExterno;
    }

    
    public boolean realizarPagamento(double valor, int matriculaAluno) {
        System.out.println("Realizando pagamento com cartão de crédito.");
        return sx.processarPagamento(valor, matriculaAluno);
    }

    
    public String verificarStatusPagamento(int matriculaAluno) {
        return sx.obterStatusPagamento(matriculaAluno);
    }
}
