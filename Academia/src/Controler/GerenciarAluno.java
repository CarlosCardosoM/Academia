package Controler;

import Comparator.AlunocpfComparator;
import Comparator.AlunomatriculaComparator;
import Entidades.Aluno;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import json.Jsonaluno;

/**
 * Classe responsável por gerenciar a lista de alunos na academia.
 * Inclui métodos para criar, alterar, buscar, ordenar e imprimir alunos.
 */
public class GerenciarAluno {

    private List<Aluno> alunos;

    public GerenciarAluno() {
        this.alunos = new ArrayList<>();
    }

    // Método para criar um novo aluno e adicioná-lo à lista
    public void criarAluno(Aluno a) {
        this.alunos.add(a);
    }

    // Método para salvar a lista de alunos em um arquivo JSON
    public void salvarAluno() {
        Jsonaluno.salvarAluno(alunos);
    }

    // Método para buscar aluno por matrícula usando binarySearch
    public Aluno buscarAluno(int matricula) {
    // Ordena a lista de alunos por matrícula

    // Cria uma instância temporária de Aluno apenas com a matrícula
    Aluno alunoBusca = new Aluno(matricula, 0, null, null, 0, null, null);

    // Realiza a busca binária
    int index = Collections.binarySearch(alunos, alunoBusca, new AlunomatriculaComparator());

    // Verifica se encontrou o aluno (índice >= 0) e retorna
    if (index >= 0) {
        return alunos.get(index);
    } else {
        System.out.println("Aluno com matrícula " + matricula + " não encontrado.");
        return null;
    }
}


    // Método para alterar o nome de um aluno baseado na matrícula
    public void alterarAluno(int matricula, String novoNome) {
        Aluno aluno = buscarAluno(matricula);

        if (aluno != null) {
            aluno.setNome(novoNome);
            System.out.println("Aluno alterado com sucesso: " + aluno.getNome());
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    // Método para imprimir a lista de alunos cadastrados
    public void imprimirListaAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Não há alunos cadastrados.");
            return;
        }

        System.out.println("Lista de Alunos:");
        // Cria um iterador para percorrer a lista de alunos
        Iterator<Aluno> alunoIterator = alunos.iterator();

        // Percorre a lista de alunos utilizando um iterador
        while (alunoIterator.hasNext()) {
            Aluno aluno = alunoIterator.next();
            System.out.println("Matrícula: " + aluno.getMatricula() +
                               ", Nome: " + aluno.getNome() +
                               ", Endereço: " + aluno.getEndereco() +
                               ", Telefone: " + aluno.getTelefone());
        }
    }

    // Método para ordenar a lista de alunos pela matrícula
    public void ordenarPorMatricula() {
        Collections.sort(alunos, new AlunomatriculaComparator());
        System.out.println("\nLista de alunos ordenada por matrícula:");
        for (Aluno aluno : alunos) {
            System.out.println("Matrícula: " + aluno.getMatricula() + ", CPF: " + aluno.getCpf() + ", Nome: " + aluno.getNome());
        }
    }

    // Método para ordenar a lista de alunos pelo CPF
    public void ordenarPorCpf() {
        Collections.sort(alunos, new AlunocpfComparator());
        System.out.println("\nLista de alunos ordenada por CPF:");
        for (Aluno aluno : alunos) {
            System.out.println("Matrícula: " + aluno.getMatricula() + ", CPF: " + aluno.getCpf() + ", Nome: " + aluno.getNome());
        }
    }

    // Método para buscar aluno por CPF utilizando find, iterator e comparator
    public Aluno buscarAlunoPorCPF(int cpf) {
        // Cria um iterador para percorrer a lista de alunos
        Iterator<Aluno> alunoIterator = alunos.iterator();
        AlunocpfComparator cpfComparator = new AlunocpfComparator();

        // Define um aluno temporário com o CPF de busca
        Aluno alunoBusca = new Aluno(0, cpf, null, null, 0, null, null);
        
        // O laço continua enquanto houver elementos na lista
        while (alunoIterator.hasNext()) {
            // Retorna o próximo aluno na lista e avança o iterador
            Aluno aluno = alunoIterator.next();
            // Compara o CPF do aluno atual com o CPF de busca
            if (cpfComparator.compare(aluno, alunoBusca) == 0) { // Usa 0 para verificar igualdade
                return aluno; // Retorna o aluno se o CPF for igual
            }
        }

        System.out.println("Aluno com CPF " + cpf + " não encontrado.");
        return null;
    }

}
