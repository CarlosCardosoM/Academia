/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adapter;

/**
 *
 * @author Carlo
 */

public class SistemaExterno {
    public boolean processarPagamento(double valor, int idAluno) {
        System.out.println("Processando pagamento de R$" + valor + " para o aluno ID: " + idAluno);
        return true; 
    }

    public String obterStatusPagamento(int idAluno) {
        System.out.println("Verificando status do pagamento para o aluno ID: " + idAluno);
        return "Pagamento confirmado";
    }
}

    

