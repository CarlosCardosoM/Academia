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
 * com base na matrícula do aluno.
 * O objetivo é permitir a ordenação de uma lista de alunos
 * de acordo com suas matrículas.
 * 
 * @author Carlo
 */
public class AlunomatriculaComparator implements Comparator<Aluno> {
    
    /**
     * Método que compara dois objetos Aluno com base na matrícula.
     * Retorna 1 se a matrícula de a1 for maior que a de a2,
     *         -1 se a matrícula de a1 for menor que a de a2,
     *         e 0 se ambas as matrículas forem iguais.
     */
    public int compare(Aluno a1, Aluno a2) {
        // Compara as matrículas dos dois alunos
        int matriculaCompare = a1.getMatricula() - a2.getMatricula();
        
        // Retorna 1 se a matrícula de a1 for maior que a de a2
        if (matriculaCompare > 0) {
            return 1; // a1 tem matrícula maior que a2
        } 
        // Retorna -1 se a matrícula de a1 for menor que a de a2
        else if (matriculaCompare < 0) {
            return -1; // a1 tem matrícula menor que a2
        } 
        // Retorna 0 se ambas as matrículas forem iguais
        else {
            return 0; // a1 e a2 têm matrículas iguais
        }
    }
}
