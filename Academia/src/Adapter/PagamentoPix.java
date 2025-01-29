/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adapter;

/**
 *
 * @author Carlo
 */
public class PagamentoPix implements ProcessadorPagamento {
    private SistemaExterno sx;

    // Construtor que recebe o sistema externo de pagamento
    public PagamentoPix(SistemaExterno sistemaExterno) {
        this.sx = sistemaExterno;
    }

    @Override
    public boolean realizarPagamento(double valor, int matriculaAluno) {
        System.out.println("Realizando pagamento via Pix.");
        return sx.processarPagamento(valor, matriculaAluno);
    }

    @Override
    public String verificarStatusPagamento(int matriculaAluno) {
        return sx.obterStatusPagamento(matriculaAluno);
    }
}
