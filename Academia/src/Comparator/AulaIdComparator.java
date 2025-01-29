/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comparator;

// Importa a classe Aula e a interface Comparator
import Entidades.Aula;
import java.util.Comparator;

/**
 * Classe que implementa a interface Comparator para comparar objetos do tipo Aula
 * com base no ID da aula.
 * O objetivo é permitir a ordenação de uma lista de aulas
 * de acordo com seus IDs.
 * 
 * @author Carlo
 */
public class AulaIdComparator implements Comparator<Aula> {
   
    /**
     * Método que compara dois objetos Aula com base no ID da aula.
     * Retorna 1 se o ID de au1 for maior que o de au2,
     *         -1 se o ID de au1 for menor que o de au2,
     *         e 0 se ambos os IDs forem iguais.
     */
    public int compare(Aula au1, Aula au2) {
        // Compara os IDs das duas aulas
        int matriculaCompare = au1.getIdAula() - au2.getIdAula();
        
        // Retorna 1 se o ID de au1 for maior que o de au2
        if (matriculaCompare > 0) {
            return 1; // au1 tem ID maior que au2
        } 
        // Retorna -1 se o ID de au1 for menor que o de au2
        else if (matriculaCompare < 0) {
            return -1; // au1 tem ID menor que au2
        } 
        // Retorna 0 se ambos os IDs forem iguais
        else {
            return 0; // au1 e au2 têm IDs iguais
        }
    }
}
