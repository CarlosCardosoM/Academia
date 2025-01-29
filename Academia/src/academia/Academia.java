
package academia;

import Adapter.PagamentoCartaoCredito;
import Adapter.PagamentoPix;
import Adapter.ProcessadorPagamento;
import Adapter.SistemaExterno;
import Entidades.Aluno;
import Entidades.Data;
import Entidades.Despesa;
import Entidades.Funcionario;
import Entidades.Gerente;
import Entidades.Horario;
import Entidades.Produto;
import java.util.Scanner;


public class Academia {
    
    public static void main(String[] args) {
    SistemaCentral central = new SistemaCentral();
    SistemaExterno sistemaExterno = new SistemaExterno();
    ProcessadorPagamento cartaoCredito = new PagamentoCartaoCredito(sistemaExterno);
    ProcessadorPagamento pix = new PagamentoPix(sistemaExterno);

    // Instanciando objetos de exemplo
    Funcionario funcionario1 = new Funcionario(3124, 32, "Instrutor", "Osvaldo", "rua laranja", 1234);
    Gerente gerente1 = new Gerente(22, 34, "Sergio", "ruaaa", 5678);

    central.getGerenciarFuncionario().criarFuncionario(funcionario1);
    central.getGerenciarGerente().criarGerente(gerente1);

        // Sistema de login
        Login loginSystem = new Login(central.getGerenciarFuncionario(), central.getGerenciarGerente());
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao sistema! Por favor, faça o login.");
        boolean loginSucesso = false;
        boolean isGerente = false;
        

        // Tentativa de login
        while (!loginSucesso) {
            System.out.print("Digite o tipo de usuário (funcionario/gerente): ");
            String tipoUsuario = scanner.next();
            
            System.out.print("Digite o ID do funcionário ou gerente: ");
            int id = scanner.nextInt();
            System.out.print("Digite a senha: ");
            int senha = scanner.nextInt();

            loginSucesso = loginSystem.realizarLogin(id, senha, tipoUsuario);
            if (loginSucesso && tipoUsuario.equalsIgnoreCase("gerente")) {
                isGerente = true;
            }   
        }

        System.out.println("Acesso concedido ao sistema!");

        
        
        // Criando e alterando colaboradores, Questão 6
        Funcionario funcionario2 = new Funcionario(5555, 32, "Instrutor", "Cleiton", "rua ja", 2132231);
        Gerente gerente2 = new Gerente(12, 44, "nunes", "ruaaa b", 213321);
        central.getGerenciarFuncionario().criarFuncionario(funcionario2);
        central.getGerenciarGerente().criarGerente(gerente2);
        
        //Alterando Funcionario e Gerente
        central.getGerenciarFuncionario().alterarFuncionario(3124, "bruno");
        central.getGerenciarGerente().alterarGerente(22, "jose");
        
        // Instanciando alunos
        //Questão 7, criando alunos
        Aluno a1 = new Aluno(12, 1234, "eduardo", "edu", 12314, "carlos", "rua principal");
        Aluno a3 = new Aluno(11, 22234, "silva", "gordin", 312123, "Joao", "rua c 3");
        Aluno a2 = new Aluno(15, 121234, "ivo", "saja", 1231414, "Sergio", "rua flor");
        central.getGerenciarAluno().criarAluno(a1);
        central.getGerenciarAluno().criarAluno(a2);
        central.getGerenciarAluno().criarAluno(a3);

        // criando Produto
        Produto produto1 = new Produto(1, "Whey", 12, 50.0);
        Produto produto2 = new Produto(2, "creatina", 12, 45.0);
        central.getEstoque().criarProduto(produto1);
        central.getEstoque().criarProduto(produto2);
        
        // Criando Despesas
        Despesa despesaLimpeza = new Despesa("Limpeza", 5.00,"serviços", new Data(31, 10, 2024));
        Despesa despesaInstrutores = new Despesa("Instrutores", 20.00, "Pagamento de instrutores", new Data(31, 10, 2024));
        Despesa despesaFuncionarios = new Despesa("Funcionários", 30.00, "Salários dos funcionários", new Data(31, 10, 2024));
        central.getBalancomensal().adicionarDespesa(despesaLimpeza);
        central.getBalancomensal().adicionarDespesa(despesaInstrutores);
        central.getBalancomensal().adicionarDespesa(despesaFuncionarios);

        
       // Exibindo as contagens
       // Questão 11 e 12
        System.out.println("Total de Alunos: " + central.getContadorAlunos());
        System.out.println("Total de Produtos: " + central.getContadorProdutos());
        
        // Questão 7        
        //Alterando aluno
        central.getGerenciarAluno().alterarAluno(12, "antonio");


        // Alterando informações dos objetos
        central.getEstoque().alterarProduto(2, "BCA", 55);


        // Realizar vendas
        central.realizarVenda(12, 2, 3, pix, new Data(23, 10, 2024));
        central.realizarVenda(12, 2, 3, pix, new Data(15, 10, 2024));
        central.realizarVenda(15, 1, 2, cartaoCredito, new Data(20, 10, 2024));
        central.realizarVenda(15, 1, 1, cartaoCredito, new Data(10, 9, 2024));
        central.realizarVenda(15, 1, 5, cartaoCredito, new Data(15, 9, 2024));
        central.realizarVenda(12, 2, 4, pix, new Data(20, 9, 2024));
        central.realizarVenda(12, 2, 1, pix, new Data(5, 8, 2024));
        central.realizarVenda(12, 2, 3, pix, new Data(10, 8, 2024));
        central.realizarVenda(15, 2, 2, cartaoCredito, new Data(15, 8, 2024));

        
        // Realizar venda de um plano 
        central.realizarVendaPlano(12, "mensal", pix, new Data(23, 10, 2024));
        central.realizarVendaPlano(15, "diario", cartaoCredito, new Data(30, 10, 2024));

        // Criando pré-agendamentos
        // Questão 9
        central.criarPreAgendamento(12, 1, new Data(15, 10, 2024),5555);
        central.criarPreAgendamento(15, 2, new Data(20, 10, 2024),3124);

        // Confirmar agendamentos
        central.confirmarAgendamento(12, new Data(12, 10, 2024));
        central.confirmarAgendamento(15, new Data(18, 10, 2024));
        
        // metodo cancelar Agendamento
        central.removerAgendamento(12);
        
        //Ações da Catraca
        // Questão 9
        central.getCatraca().registrarEntrada(12, new Data(23,10,2024), new Horario(8, 30, 0));
        central.getCatraca().registrarEntrada(15, new Data (25, 10, 2024), new Horario(17, 0, 0));
        central.getCatraca().registrarSaida(12, new Data(23,10,2024), new Horario(10, 30, 0));
        
        

        // Impressão dos objetos em ordem
        // Questão 10
        central.getGerenciarAluno().imprimirListaAlunos();
        central.imprimirVendas();
        central.imprimirVendasPlanos();
        
        // realizar balanco mensal
        central.getBalancomensal().realizarBalancoMensal(10, 2024);
        
        
        //QUESTÃO 15
        // iterator
        central.getGerenciarAluno().imprimirListaAlunos();
        
        //QUESTÃO 16
        // ordenação da lista de alunos por cpf e por matricula 
        central.getGerenciarAluno().ordenarPorCpf();
        central.getGerenciarAluno().ordenarPorMatricula();
        
        
        //QUESTÃO 17
        // testando o FIND
        // Definindo um cpf pra buscar
        int cpfBusca = 1234;
        //Chama o método buscarAlunoPorCPF e armazena o resultado 
        Aluno alunoEncontrado = central.getGerenciarAluno().buscarAlunoPorCPF(cpfBusca);
        if (alunoEncontrado != null) {
            System.out.println("Aluno encontrado: " + alunoEncontrado.getNome() + ", CPF: " + alunoEncontrado.getCpf());
        } else {
            System.out.println("Aluno com CPF " + cpfBusca + " não encontrado.");
        }
    
        
        



        // Questão 14
        // Salvando arquivos em formato JSON
        central.getGerenciarAluno().salvarAluno();
        central.getGerenciarGerente().salvarGerente();
        central.getGerenciarFuncionario().salvarFuncionario();
        central.getGerenciarAula().salvarAula();
        central.salvarVenda();
        central.salvarAgendamento();
        central.salvarVendaPlano();
        
        
        
    }
}
