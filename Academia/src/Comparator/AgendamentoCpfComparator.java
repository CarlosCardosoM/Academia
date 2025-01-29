/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comparator;

// Importa a classe Agendamento e a interface Comparator
import Entidades.Agendamento;
import java.util.Comparator;

/**
 * Classe que implementa a interface Comparator para comparar objetos do tipo Agendamento
 * com base na matrícula do aluno associado a cada agendamento.
 * O objetivo é permitir a ordenação de uma lista de agendamentos
 * de acordo com a matrícula dos alunos.
 * 
 * @author Carlo
 */
public class AgendamentoCpfComparator implements Comparator<Agendamento> {
    
    /**
     * Método que compara dois objetos Agendamento com base na matrícula.
     * Retorna 1 se a matrícula de ag1 for maior que a de ag2,
     *         -1 se a matrícula de ag1 for menor que a de ag2,
     *         e 0 se ambas as matrículas forem iguais.
     */
    public int compare(Agendamento ag1, Agendamento ag2) {
        // Compara as matrículas dos dois agendamentos
        int matriculaagCompare = ag1.getMatricula() - ag2.getMatricula();
        
        // Retorna 1 se a matrícula de ag1 for maior que a de ag2
        if (matriculaagCompare > 0) {
            return 1; // ag1 tem matrícula maior que ag2
        } 
        // Retorna -1 se a matrícula de ag1 for menor que a de ag2
        else if (matriculaagCompare < 0) {
            return -1; // ag1 tem matrícula menor que ag2
        } 
        // Retorna 0 se ambas as matrículas forem iguais
        else {
            return 0; // ag1 e ag2 têm matrículas iguais
        }
    }
}
