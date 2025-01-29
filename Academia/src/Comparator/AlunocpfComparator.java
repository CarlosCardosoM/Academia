/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comparator;

// Importa a classe Aluno e a interface Comparator
import Entidades.Aluno;
import java.util.Comparator;

/**
 * Classe que implementa a interface Comparator para comparar objetos do tipo Aluno
 * com base no CPF do aluno.
 * O objetivo é permitir a ordenação de uma lista de alunos
 * de acordo com seus CPFs.
 * 
 * @author Carlo
 */
public class AlunocpfComparator implements Comparator<Aluno> {
    
    /**
     * Método que compara dois objetos Aluno com base no CPF.
     * 
     *Retorna 1 se o CPF de a1 for maior que o de a2,
     *         -1 se o CPF de a1 for menor que o de a2,
     *         e 0 se ambos os CPFs forem iguais.
     */
    public int compare(Aluno a1, Aluno a2) {
        // Compara os CPFs dos dois alunos
        int cpfCompare = a1.getCpf() - a2.getCpf();
        
        // Retorna 1 se o CPF de a1 for maior que o de a2
        if (cpfCompare > 0) {
            return 1; // a1 tem CPF maior que a2
        } 
        // Retorna -1 se o CPF de a1 for menor que o de a2
        else if (cpfCompare < 0) {
            return -1; // a1 tem CPF menor que a2
        } 
        // Retorna 0 se ambos os CPFs forem iguais
        else {
            return 0; // a1 e a2 têm CPFs iguais
        }
    }
}
