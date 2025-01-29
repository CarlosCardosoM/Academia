package Controler;

import Comparator.FuncionarioIdComparator;
import Entidades.Funcionario;
import Json.Jsonfuncionario;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe responsável por gerenciar as operações relacionadas aos funcionários.
 * Inclui métodos para criar, buscar, alterar e salvar informações de funcionários.
 */
public class GerenciarFuncionario {
    
    private List<Funcionario> funcionarios = new ArrayList<>(); // Lista para armazenar os funcionários

    // Construtor da classe
    public GerenciarFuncionario() {
        
    }

    // Método para criar funcionário
    public void criarFuncionario(Funcionario f) {
        this.funcionarios.add(f); // Adiciona o funcionário à lista
    }
    
    // Método para salvar a lista de funcionários em formato JSON
    public void salvarFuncionario() {
        Jsonfuncionario.salvarFuncionario(funcionarios); // Chama o método para salvar os funcionários
    }
    
    // Método para buscar funcionário pelo ID usando binarySearch
    public Funcionario buscarFuncionario(int id) {
        Funcionario funcionarioBusca = new Funcionario(id, 0, null, null, null, 0); // Objeto temporário para busca
        int index = Collections.binarySearch(this.funcionarios, funcionarioBusca, new FuncionarioIdComparator());
        
        if (index >= 0) {
            return this.funcionarios.get(index); // Retorna o funcionário encontrado
        } else {
            return null; // Retorna null se o funcionário não for encontrado
        }
    }
    
    // Método para alterar o nome do funcionário
    public void alterarFuncionario(int id, String novoNome) {
        Funcionario funcionario = buscarFuncionario(id); // Busca o funcionário pelo ID

        if (funcionario != null) {
            funcionario.setNome(novoNome); // Altera o nome do funcionário
            System.out.println("Gerente alterado com sucesso: " + funcionario);
        } else {
            System.out.println("Gerente não encontrado."); // Mensagem caso o funcionário não seja encontrado
        }
    }
    
    public List<Funcionario> exibirFuncionario(){
        return funcionarios;
        
    }
}
