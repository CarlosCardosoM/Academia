/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comparator;

// Importa a classe Gerente e a interface Comparator
import Entidades.Gerente;
import java.util.Comparator;

/**
 * Classe que implementa a interface Comparator para comparar objetos do tipo Gerente
 * com base no ID do gerente.
 * O objetivo é permitir a ordenação de uma lista de gerentes
 * de acordo com seus IDs.
 * 
 * @author Carlo
 */
public class GerenteIdComparator implements Comparator<Gerente> {
    
    /**
     * Método que compara dois objetos Gerente com base no ID do gerente.
     * Retorna 1 se o ID de g1 for maior que o de g2,
     *         -1 se o ID de g1 for menor que o de g2,
     *         e 0 se ambos os IDs forem iguais.
     */
    public int compare(Gerente g1, Gerente g2) {
        // Compara os IDs dos dois gerentes
        int idCompare = g1.getId() - g2.getId();
        
        // Retorna 1 se o ID de g1 for maior que o de g2
        if (idCompare > 0) {
            return 1; // g1 tem ID maior que g2
        } 
        // Retorna -1 se o ID de g1 for menor que o de g2
        else if (idCompare < 0) {
            return -1; // g1 tem ID menor que g2
        } 
        // Retorna 0 se ambos os IDs forem iguais
        else {
            return 0; // g1 e g2 têm IDs iguais
        }
    }
}
