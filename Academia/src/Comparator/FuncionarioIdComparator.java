/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comparator;

// Importa a classe Funcionario e a interface Comparator
import Entidades.Funcionario;
import java.util.Comparator;

/**
 * Classe que implementa a interface Comparator para comparar objetos do tipo Funcionario
 * com base no ID do funcionário.
 * O objetivo é permitir a ordenação de uma lista de funcionários
 * de acordo com seus IDs.
 * 
 * @author Carlo
 */
public class FuncionarioIdComparator implements Comparator<Funcionario> {
    
    /**
     * Método que compara dois objetos Funcionario com base no ID do funcionário.
     *Retorna 1 se o ID de f1 for maior que o de f2,
     *         -1 se o ID de f1 for menor que o de f2,
     *         e 0 se ambos os IDs forem iguais.
     */
    public int compare(Funcionario f1, Funcionario f2) {
        // Compara os IDs dos dois funcionários
        int idCompare = f1.getId() - f2.getId();
        
        // Retorna 1 se o ID de f1 for maior que o de f2
        if (idCompare > 0) {
            return 1; // f1 tem ID maior que f2
        } 
        // Retorna -1 se o ID de f1 for menor que o de f2
        else if (idCompare < 0) {
            return -1; // f1 tem ID menor que f2
        } 
        // Retorna 0 se ambos os IDs forem iguais
        else {
            return 0; // f1 e f2 têm IDs iguais
        }
    }
}
