package Entidades;

import java.util.Date;

public class Agendamento {
    private Data dataAgendamento;
    private Data dataConfirmacao;
    private int matricula;
    private int aulaId;
    private Funcionario funcionario; // Novo atributo para armazenar o funcionário

    // Construtor
    public Agendamento(Data dataAgendamento, Data dataConfirmacao, int matricula, int aulaId, Funcionario funcionario) {
        this.dataAgendamento = dataAgendamento;
        this.dataConfirmacao = dataConfirmacao;
        this.matricula = matricula;
        this.aulaId = aulaId;
        this.funcionario = funcionario;
    }
    

    // Métodos get e set
    public Data getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(Data dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public Data getDataConfirmacao() {
        return dataConfirmacao;
    }

    public void setDataConfirmacao(Data dataConfirmacao) {
        this.dataConfirmacao = dataConfirmacao;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public int getAulaId() {
        return aulaId;
    }

    public void setAulaId(int aulaId) {
        this.aulaId = aulaId;
    }

    @Override
    public String toString() {
        return "Agendamento{" + "dataAgendamento=" + dataAgendamento + ", dataConfirmacao=" + dataConfirmacao + ", matricula=" + matricula + ", aulaId=" + aulaId + ", funcionario=" + funcionario + '}';
    }

}

    


