package Controler;

import Entidades.Despesa;
import Entidades.Receita;
import Entidades.Venda;
import Entidades.VendaPlano;
import Entidades.Agendamento;
import Entidades.Aula;
import Entidades.Data;
import Entidades.Estoque;
import Entidades.Produto;
import academia.Login;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por gerenciar o balanço mensal das receitas e despesas da academia.
 * Inclui métodos para adicionar receitas e despesas, bem como calcular e imprimir o balanço mensal.
 */
public class BalancoMensal {

    private List<Receita> receitas;
    private List<Despesa> despesas;
    private Estoque estoque;
    private GerenciarAula gerenciarAula;
    private Login login; // Referência ao sistema de login para autenticação

    // Construtor da classe que inicializa receitas, despesas, estoque e gerenciador de aulas
    public BalancoMensal(Estoque estoque, GerenciarAula gerenciarAula, Login login) {
        this.receitas = new ArrayList<>();
        this.despesas = new ArrayList<>();
        this.estoque = estoque;
        this.gerenciarAula = gerenciarAula;
        this.login = login;
    }

    // Construtor da classe que inicializa apenas as listas de receitas e despesas
    public BalancoMensal(List<Receita> receitas, List<Despesa> despesas, Login login) {
        this.receitas = receitas;
        this.despesas = despesas;
        this.login = login;
    }

    public Login getLogin() {
        return login;
    }

    // Método para adicionar receita
    public void adicionarReceita(String descricao, double valor, Data data) {
        Receita receita = new Receita(descricao, valor, data);
        receitas.add(receita);
    }

    // Método para adicionar despesa, disponível apenas para o gerente
    public void adicionarDespesa(Despesa despesa) {
            this.despesas.add(despesa);
            System.out.println("Despesa adicionada: " + despesa.getDescricao());
    }

    // Método para adicionar receita de venda
    public void adicionarReceitaVenda(Venda venda) {
        Produto produto = estoque.buscarProduto(venda.getIdProduto());
        if (produto != null) {
            double totalVenda = venda.getQuantidade() * produto.getPreco();
            adicionarReceita("Venda de produto: " + produto.getNome(), totalVenda, venda.getDataVenda());
        } else {
            System.out.println("Produto não encontrado para a venda com ID: " + venda.getIdProduto());
        }
    }

    // Método para adicionar receita de venda de plano
    public void adicionarReceitaVendaPlano(VendaPlano vendaPlano) {
        adicionarReceita("Venda de plano: " + vendaPlano.getTipoPlano(), vendaPlano.getValor(), vendaPlano.getDataVenda());
    }

    // Método para adicionar receita de agendamento
    public void adicionarReceitaAgendamento(Agendamento agendamento) {
        Aula aula = gerenciarAula.buscarAulaPorId(agendamento.getAulaId());
        if (aula != null) {
            adicionarReceita("Agendamento de aula: " + aula.getTipoAula(), aula.getPreco(), agendamento.getDataAgendamento());
        } else {
            System.out.println("Aula não encontrada para o agendamento com ID: " + agendamento.getAulaId());
        }
    }
    
    // Método para remover receita de agendamento
public void removerReceitaAgendamento(Agendamento agendamento) {
    Aula aula = gerenciarAula.buscarAulaPorId(agendamento.getAulaId());
    if (aula != null) {
        // Cria um objeto Receita para a aula, utilizando as mesmas informações que foram usadas na adição
        Receita receitaARemover = new Receita("Agendamento de aula: " + aula.getTipoAula(), aula.getPreco(), agendamento.getDataAgendamento());

        // Procura a receita na lista de receitas e a remove
        boolean removed = receitas.removeIf(receita -> receita.equals(receitaARemover));
        
        if (removed) {
            System.out.println("Receita de agendamento removida: " + receitaARemover.getDescricao());
        } else {
            System.out.println("Receita de agendamento não encontrada para remoção.");
        }
    } else {
        System.out.println("Aula não encontrada para o agendamento com ID: " + agendamento.getAulaId());
    }
}



    // Método para realizar balanço mensal, disponível apenas para o gerente
    public void realizarBalancoMensal(int mes, int ano) {
        
            double totalReceitas = 0;
            double totalDespesas = 0;

            // Calcula o total de receitas para o mês e ano especificados
            for (Receita receita : receitas) {
                if (receita.getData().getMes() == mes && receita.getData().getAno() == ano) {
                    totalReceitas += receita.getValor();
                }
            }

            // Calcula o total de despesas para o mês e ano especificados
            for (Despesa despesa : despesas) {
                if (despesa.getDataDespesa().getMes() == mes && despesa.getDataDespesa().getAno() == ano) {
                    totalDespesas += despesa.getValor();
                }
            }

            // Imprime o balanço mensal
            System.out.println("Balanço Mensal para " + mes + "/" + ano + ":");
            System.out.println("Total Receitas: " + totalReceitas);
            System.out.println("Total Despesas: " + totalDespesas);
            System.out.println("Lucro Líquido: " + (totalReceitas - totalDespesas));
    }
}

