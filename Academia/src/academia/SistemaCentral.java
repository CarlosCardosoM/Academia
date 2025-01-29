package academia;

import Adapter.PagamentoAdapter;
import Adapter.ProcessadorPagamento;
import Adapter.SistemaExterno;
import Comparator.AgendamentoCpfComparator;
import Controler.BalancoMensal;
import Controler.Catraca;
import Controler.GerenciarAluno;
import Controler.GerenciarAula;
import Controler.GerenciarFuncionario;
import Controler.GerenciarGerente;
import Entidades.Agendamento;
import Entidades.Aluno;
import Entidades.Aula;
import Entidades.Data;
import Entidades.Estoque;
import Entidades.Funcionario;
import Entidades.Produto;
import Entidades.Venda;
import Entidades.VendaPlano;
import Json.Jsonagendamento;
import Json.Jsonvenda;
import Json.Jsonvendaplano;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe principal do sistema da academia, responsável por gerenciar alunos,
 * aulas, agendamentos, estoque de produtos e vendas.
 * Inclui funcionalidades de pagamento, controle de catraca e balanço mensal.
 * 
 * @autor Carlo
 */
public class SistemaCentral {
    
    // Controladores para gerenciar diferentes entidades
    private GerenciarAluno gerenciarAluno;
    private GerenciarAula gerenciarAula;
    private Estoque estoque;
    private GerenciarFuncionario gerenciarFuncionario;
    private GerenciarGerente gerenciarGerente;
    private ProcessadorPagamento processadorPagamento;
    private Catraca catraca;
    private BalancoMensal balancomensal;
    private Login login;
    
    // Contadores estáticos para controle de instâncias de alunos e produtos
    protected static int contadorAlunos = 0;
    private static int contadorProdutos = 0;
   
    // Listas para armazenar registros de agendamentos, vendas de produtos e planos
    private List<Agendamento> listaAgendamentos;
    private List<Venda> listaVendas;
    private List<VendaPlano> listaVendasPlanos;
    
    // Instancia um sistema externo de pagamento
    SistemaExterno sistemaexterno = new SistemaExterno();

    /**
     * Construtor da classe SistemaCentral que inicializa controladores, estoque e listas.
     */
    public SistemaCentral() {
        this.gerenciarAluno = new GerenciarAluno();
        this.gerenciarAula = new GerenciarAula();
        this.gerenciarFuncionario = new GerenciarFuncionario();
        this.gerenciarGerente = new GerenciarGerente();
        this.estoque = new Estoque();
        this.listaAgendamentos = new ArrayList<>();
        this.listaVendas = new ArrayList<>();
        this.listaVendasPlanos = new ArrayList<>();
        this.processadorPagamento = new PagamentoAdapter(sistemaexterno);
        this.catraca = new Catraca(gerenciarAluno);
        this.login = new Login (gerenciarFuncionario, gerenciarGerente);
        this.balancomensal = new BalancoMensal(estoque, gerenciarAula, login);
    }

    // Métodos getters e setters para gerenciar entidades
    public GerenciarAluno getGerenciarAluno() {
        return gerenciarAluno;
    }

    public void setGerenciarAluno(GerenciarAluno gerenciarAluno) {
        this.gerenciarAluno = gerenciarAluno;
    }
    
    public GerenciarAula getGerenciarAula() {
        return gerenciarAula;
    }

    public void setGerenciarAula(GerenciarAula gerenciarAula) {
        this.gerenciarAula = gerenciarAula;
    }
    
    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }
    
    public GerenciarFuncionario getGerenciarFuncionario() {
        return gerenciarFuncionario;
    }

    public void setGerenciarFuncionario(GerenciarFuncionario gerenciarFuncionario) {
        this.gerenciarFuncionario = gerenciarFuncionario;
    }
    
    public GerenciarGerente getGerenciarGerente() {
        return gerenciarGerente;
    }

    public void setGerenciarGerente(GerenciarGerente gerenciarGerente) {
        this.gerenciarGerente = gerenciarGerente;
    }
    
    // Métodos estáticos para controle de instâncias de alunos e produtos
    public static int getContadorAlunos() {
        return contadorAlunos;
    }

    public static int getContadorProdutos() {
        return contadorProdutos;
    }

    public static void incrementarContadorAlunos() {
        contadorAlunos++;
    }

    public static void incrementarContadorProdutos() {
        contadorProdutos++;
    }

    public BalancoMensal getBalancomensal() {
        return balancomensal;
    }

    public Catraca getCatraca() {
        return catraca;
    }
    
    
    
    

    /**
     * Realiza a venda de um produto, incluindo a verificação de estoque e processamento de pagamento.
     */
    public void realizarVenda(int matriculaAluno, int idProduto, int quantidade, ProcessadorPagamento pagamento, Data dataVenda) {
        Aluno aluno = gerenciarAluno.buscarAluno(matriculaAluno);
        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        Produto produto = estoque.buscarProduto(idProduto);
        if (produto == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        if (produto.getQuantidade() < quantidade) {
            System.out.println("Quantidade solicitada não disponível no estoque.");
            return;
        }

        estoque.removerQuantidade(idProduto, quantidade);
        double total = produto.getPreco() * quantidade;
        
        // Realiza o pagamento e adiciona venda ao balanço mensal se for bem-sucedido
        if (pagamento.realizarPagamento(total, matriculaAluno)) {
            Venda venda = new Venda(matriculaAluno, idProduto, quantidade, dataVenda);
            listaVendas.add(venda);
            balancomensal.adicionarReceitaVenda(venda);
            System.out.println("Venda realizada com sucesso! " + dataVenda + ", Aluno: " + aluno.getNome() + ", Produto: " + produto.getNome() + ", Total: R$ " + total);
        } else {
            System.out.println("Falha ao processar pagamento.");
        }
    }

    // Método para salvar vendas de produtos em formato JSON
    public void salvarVenda() {
        Jsonvenda.salvarAluno(listaVendas);
    }

    /**
     * Realiza a venda de um plano de academia, dependendo do tipo de plano (diário ou mensal).
     */
    public void realizarVendaPlano(int matriculaAluno, String tipoPlano, ProcessadorPagamento pagamento, Data dataVenda) {
        Aluno aluno = gerenciarAluno.buscarAluno(matriculaAluno);
        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        double valor;

        // Define o valor com base no tipo de plano
        if (tipoPlano.equalsIgnoreCase("diario")) {
            valor = 15.0;
        } else if (tipoPlano.equalsIgnoreCase("mensal")) {
            valor = 100.0;
        } else {
            System.out.println("Tipo de plano inválido.");
            return;
        }

        // Processa o pagamento e adiciona venda de plano ao balanço mensal
        if (pagamento.realizarPagamento(valor, matriculaAluno)) {
            VendaPlano vendaPlano = new VendaPlano(matriculaAluno, tipoPlano, valor, dataVenda);
            listaVendasPlanos.add(vendaPlano);
            balancomensal.adicionarReceitaVendaPlano(vendaPlano);
            System.out.println("Venda de plano realizada com sucesso! " + vendaPlano);
        } else {
            System.out.println("Falha ao processar pagamento.");
        }
    }

    // Método para salvar vendas de planos em formato JSON
    public void salvarVendaPlano() {
        Jsonvendaplano.salvarVendaPlano(listaVendasPlanos);
    }
    
    /**
     * Cria um pré-agendamento para um aluno em uma aula específica.
     */
    public void criarPreAgendamento(int matricula, int aulaId, Data dataAgendamento, int funcionarioId) {
        Aluno aluno = gerenciarAluno.buscarAluno(matricula);
        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        Aula aula = gerenciarAula.buscarAulaPorId(aulaId);
        if (aula == null) {
            System.out.println("Aula não encontrada.");
            return;
        }

        Funcionario funcionario = gerenciarFuncionario.buscarFuncionario(funcionarioId);
        if (funcionario == null) {
            System.out.println("Funcionário não encontrado.");
            return;
        }

        Agendamento agendamentoExistente = buscarAgendamentoPorMatricula(matricula);
        if (agendamentoExistente != null && agendamentoExistente.getDataAgendamento().equals(dataAgendamento)) {
            System.out.println("Já existe um agendamento para este aluno na mesma data.");
            return;
        }

        Agendamento agendamento = new Agendamento(dataAgendamento, null, matricula, aulaId, funcionario);
        listaAgendamentos.add(agendamento);
        System.out.println("Pré-agendamento realizado com sucesso para " + aluno.getNome() + " na aula " + aula.getTipoAula() + " para a data: " + dataAgendamento);
    }

    // Método para buscar um agendamento pelo número da matrícula usando busca binária
    public Agendamento buscarAgendamentoPorMatricula(int matricula) {
        Agendamento agendamentoBuscado = new Agendamento(null, null, matricula, 0, null);
        int index = Collections.binarySearch(listaAgendamentos, agendamentoBuscado, new AgendamentoCpfComparator());
        return (index >= 0) ? listaAgendamentos.get(index) : null;
    }
    
    /**
 * Confirma o agendamento de um aluno, garantindo que o pré-agendamento exista
 * e processando o pagamento da aula antes de confirmar.
 */
    // Método para confirmar o agendamento
    public void confirmarAgendamento(int matricula, Data dataConfirmacao) {
    // Busca o agendamento pelo número da matrícula
        Agendamento agendamento = buscarAgendamentoPorMatricula(matricula);
        if (agendamento == null) {
        System.out.println("Agendamento não encontrado para a matrícula: " + matricula);
        return;
    }

    // Define a data de confirmação
    agendamento.setDataConfirmacao(dataConfirmacao);
    
    // Adicionar a receita de agendamento ao balanço mensal
    balancomensal.adicionarReceitaAgendamento(agendamento);
    
    System.out.println("Agendamento confirmado com sucesso! " +
                       "Aluno: " + gerenciarAluno.buscarAluno(matricula).getNome() +
                       ", Data de Agendamento: " + agendamento.getDataAgendamento() +
                       ", Data de Confirmação: " + dataConfirmacao);
}

    // salvar JSOn
    public void salvarAgendamento(){
        Jsonagendamento.salvarAgendamento(listaAgendamentos);
    
    }
    
    /**
 * Cancela um agendamento de um aluno, removendo-o da lista de agendamentos e da lista de receitas.
 */
public boolean removerAgendamento(int idAgendamento) {
    for (Agendamento agendamento : listaAgendamentos) {
        if (agendamento.getMatricula() == idAgendamento) {
            // Remover a receita associada ao agendamento
            balancomensal.removerReceitaAgendamento(agendamento);
            
            // Remover o agendamento da lista de agendamentos
            listaAgendamentos.remove(agendamento);
            
            System.out.println("Agendamento, do aluno com ID:  " + idAgendamento + " removido com sucesso.");
            return true;
        }
    }
    System.out.println("Agendamento com matrícula " + idAgendamento + " não encontrado.");
    return false;
}


    
    // Método para imprimir as vendas realizadas
    public void imprimirVendas() {
        if (listaVendas.isEmpty()) {
        System.out.println("Não há vendas registradas.");
        return;
    }

    System.out.println("Lista de Vendas:");
    for (Venda venda : listaVendas) {
        System.out.println("Matricula do Aluno: " + venda.getMatriculaAluno() +
                           ", ID do Produto: " + venda.getIdProduto() +
                           ", Quantidade: " + venda.getQuantidade() +
                           ", Data da Venda: " + venda.getDataVenda());
    }
}

    // Método para imprimir as vendas de planos
    public void imprimirVendasPlanos() {
        if (listaVendasPlanos.isEmpty()) {
        System.out.println("Não há vendas de planos registradas.");
        return;
    }

    System.out.println("Lista de Vendas de Planos:");
    for (VendaPlano vendaPlano : listaVendasPlanos) {
        System.out.println("Matricula do Aluno: " + vendaPlano.getMatriculaAluno() +
                           ", Tipo de Plano: " + vendaPlano.getTipoPlano() +
                           ", Valor: R$ " + vendaPlano.getValor() +
                           ", Data da Venda: " + vendaPlano.getDataVenda());
    }
}



}
    


