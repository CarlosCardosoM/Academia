package Controler;

import Comparator.GerenteIdComparator;
import Entidades.Gerente;
import Json.Jsongerente;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe responsável por gerenciar as operações relacionadas aos gerentes.
 * Inclui métodos para criar, buscar, alterar e salvar informações de gerentes.
 */
public class GerenciarGerente {
    
    private List<Gerente> gerentes; // Lista para armazenar os gerentes

    // Construtor da classe
    public GerenciarGerente() {
        this.gerentes = new ArrayList<>(); // Inicializa a lista de gerentes
    }
    
    // Método para criar gerente
    public void criarGerente(Gerente g) {
        this.gerentes.add(g); // Adiciona o gerente à lista
    }
    
    // Método para salvar a lista de gerentes em formato JSON
    public void salvarGerente() {
        Jsongerente.salvarGerente(gerentes); // Chama o método para salvar os gerentes
    }
    
    // Método para buscar gerente pelo ID usando binarySearch
    public Gerente buscarGerente(int id) {
        Gerente gerenteBusca = new Gerente(id, 0, null, null, 0); // Objeto temporário para busca
        int index = Collections.binarySearch(this.gerentes, gerenteBusca, new GerenteIdComparator());
        
        if (index >= 0) {
            return this.gerentes.get(index); // Retorna o gerente encontrado
        } else {
            return null; // Retorna null se o gerente não for encontrado
        }
    }
    
    // Método para alterar o nome do gerente
    public void alterarGerente(int id, String novoNome) {
        Gerente gerente = buscarGerente(id); // Busca o gerente pelo ID

        if (gerente != null) {
            gerente.setNome(novoNome); // Altera o nome do gerente
            System.out.println("Gerente alterado com sucesso: " + gerente);
        } else {
            System.out.println("Gerente não encontrado."); // Mensagem caso o gerente não seja encontrado
        }
    }
    
    public List<Gerente> exibirGerente(){
        return gerentes;
    }
}
