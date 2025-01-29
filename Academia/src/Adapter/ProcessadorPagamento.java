/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Adapter;

/**
 *
 * @author Carlo
 */
// Interface para o processamento de pagamento
public interface ProcessadorPagamento {
    boolean realizarPagamento(double valor, int matriculaAluno);
    String verificarStatusPagamento(int matriculaAluno);
}
