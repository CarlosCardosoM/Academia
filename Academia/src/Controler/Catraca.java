package Controler;

import Entidades.Acesso;
import Entidades.Aluno;
import Entidades.Data;
import Entidades.Horario;
import Json.Jsoncatraca;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por gerenciar o registro de entradas e saídas dos alunos na academia.
 * Inclui métodos para registrar acessos e interagir com a classe GerenciarAluno.
 */
public class Catraca {
    
    private List<Acesso> acessos;        // Lista para armazenar os acessos registrados
    private GerenciarAluno gerenciarAluno; // Gerenciador de alunos

    // Construtor da classe
    public Catraca(GerenciarAluno gerenciarAluno) {
        this.acessos = new ArrayList<>(); // Inicializa a lista de acessos
        this.gerenciarAluno = gerenciarAluno; // Inicializa o gerenciador de alunos
    }

    // Método para registrar entrada
    public void registrarEntrada(int matricula, Data dataEntrada, Horario horarioEntrada) {
        Aluno aluno = gerenciarAluno.buscarAluno(matricula); // Busca o aluno pela matrícula
        if (aluno != null) {
            Acesso acesso = new Acesso(matricula, dataEntrada, horarioEntrada, "Entrada"); // Cria um novo acesso
            acessos.add(acesso); // Adiciona o acesso à lista
            System.out.println("Entrada registrada para aluno com matrícula: " + matricula + " em " + acesso.getDataHora());
            Jsoncatraca.salvarAcessos(acessos); // Salva os acessos após registrar a entrada
        } else {
            System.out.println("Aluno com matrícula " + matricula + " não encontrado. Não é possível registrar entrada.");
        }
    }

    // Método para registrar saída
    public void registrarSaida(int matricula, Data dataSaida, Horario horarioSaida) {
        Aluno aluno = gerenciarAluno.buscarAluno(matricula); // Busca o aluno pela matrícula
        if (aluno != null) {
            Acesso acesso = new Acesso(matricula, dataSaida, horarioSaida, "Saída"); // Cria um novo acesso
            acessos.add(acesso); // Adiciona o acesso à lista
            System.out.println("Saída registrada para aluno com matrícula: " + matricula + " em " + acesso.getDataHora());
            Jsoncatraca.salvarAcessos(acessos); // Salva os acessos após registrar a saída
        } else {
            System.out.println("Aluno com matrícula " + matricula + " não encontrado. Não é possível registrar saída.");
        }
    }
}
