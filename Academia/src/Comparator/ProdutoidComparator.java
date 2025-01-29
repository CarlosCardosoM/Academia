/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comparator;

// Importa a classe Produto e a interface Comparator
import Entidades.Produto;
import java.util.Comparator;

/**
 * Classe que implementa a interface Comparator para comparar objetos do tipo Produto
 * com base no ID do produto.
 * O objetivo é permitir a ordenação de uma lista de produtos
 * de acordo com seus IDs.
 * 
 * @author Carlo
 */
public class ProdutoidComparator implements Comparator<Produto> {
    
    /**
     * Método que compara dois objetos Produto com base no ID do produto.
     *Retorna 1 se o ID de p1 for maior que o de p2,
     *         -1 se o ID de p1 for menor que o de p2,
     *         e 0 se ambos os IDs forem iguais.
     */
    public int compare(Produto p1, Produto p2) {
        // Compara os IDs dos dois produtos
        int idCompare = p1.getId() - p2.getId();
        
        // Retorna 1 se o ID de p1 for maior que o de p2
        if (idCompare > 0) {
            return 1; // p1 tem ID maior que p2
        } 
        // Retorna -1 se o ID de p1 for menor que o de p2
        else if (idCompare < 0) {
            return -1; // p1 tem ID menor que p2
        } 
        // Retorna 0 se ambos os IDs forem iguais
        else {
            return 0; // p1 e p2 têm IDs iguais
        }
    }
}
