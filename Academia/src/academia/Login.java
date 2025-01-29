package academia;

import Entidades.Funcionario;
import Entidades.Gerente;
import Controler.GerenciarFuncionario;
import Controler.GerenciarGerente;


/**
 * Classe responsável pela autenticação de login para Funcionários e Gerentes.
 * Realiza a verificação de ID e senha para acesso ao sistema.
 */
public class Login {
    private GerenciarFuncionario gerenciarFuncionario;
    private GerenciarGerente gerenciarGerente;
    private String tipoUsuarioLogado; // Armazena o tipo de usuário logado

    public Login(GerenciarFuncionario gerenciarFuncionario, GerenciarGerente gerenciarGerente) {
        this.gerenciarFuncionario = gerenciarFuncionario;
        this.gerenciarGerente = gerenciarGerente;
    }

    public boolean realizarLogin(int id, int senha, String tipo) {
        if (tipo.equalsIgnoreCase("funcionario")) {
            Funcionario funcionario = gerenciarFuncionario.buscarFuncionario(id);
            if (funcionario != null && funcionario.getSenha() == senha) {
                tipoUsuarioLogado = "funcionario";
                System.out.println("Login realizado como Funcionário: " + funcionario.getNome());
                return true;
            }
        } else if (tipo.equalsIgnoreCase("gerente")) {
            Gerente gerente = gerenciarGerente.buscarGerente(id);
            if (gerente != null && gerente.getSenha() == senha) {
                tipoUsuarioLogado = "gerente";
                System.out.println("Login realizado como Gerente: " + gerente.getNome());
                return true;
            }
        }
        System.out.println("ID ou senha incorretos. Tente novamente.");
        return false;
    }

}






