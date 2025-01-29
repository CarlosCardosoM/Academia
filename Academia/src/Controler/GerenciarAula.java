package Controler;

import Comparator.AulaIdComparator;
import Entidades.Aula;
import Json.Jsonaula;
import java.util.Arrays;
import java.util.List;

/**
 * Classe responsável por gerenciar as aulas na academia.
 * Inclui métodos para instanciar aulas, buscar aulas por ID,
 * imprimir a lista de aulas e salvar as aulas em um arquivo JSON.
 */
public class GerenciarAula {

    private Aula[] aulas = new Aula[4];  // Vetor para armazenar até 4 aulas

    // Construtor que instancia as 4 aulas com dados predefinidos
    public GerenciarAula() {
        aulas[0] = new Aula("Pilates", 1.0, 1, 50.0);
        aulas[1] = new Aula("Musculação", 1.5, 2, 40.0);
        aulas[2] = new Aula("Yoga", 1.0, 3, 45.0);
        aulas[3] = new Aula("Crossfit", 1.5, 4, 60.0);
    }

    // Método para buscar aula por ID usando busca binária
    public Aula buscarAulaPorId(int id) {
        // Cria um objeto Aula temporário com o ID de busca
        int index = Arrays.binarySearch(aulas, new Aula("", 0, id, 0.0), new AulaIdComparator());

        // Retorna a aula encontrada ou null se não for encontrada
        return (index >= 0) ? aulas[index] : null;
    }

    // Método para imprimir as aulas armazenadas no vetor
    public void imprimirAulas() {
        for (Aula aula : aulas) {
            System.out.println(aula);  // Imprime cada aula no vetor
        }
    }

    // Método para salvar as aulas em um arquivo JSON
    public void salvarAula() {
        // Converte o array de aulas em uma lista para facilitar a manipulação
        List<Aula> listaAulas = Arrays.asList(aulas);
        Jsonaula.salvarAula(listaAulas);  // Chama o método de salvamento em JSON
    }
}
