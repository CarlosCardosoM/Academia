package Entidades;

import academia.SistemaCentral;


public class Aluno extends Pessoa {
    private int matricula;
    private int cpf;
    private String sobrenome;
    private String apelido;

    // Construtor completo da classe Aluno
    public Aluno(int matricula, int cpf, String sobrenome, String apelido, int telefone, String nome, String endereco) {
        super(nome, endereco, telefone); // Chama o construtor da classe Pessoa
        this.matricula = matricula;
        this.cpf = cpf;
        this.sobrenome = sobrenome;
        this.apelido = apelido;
        SistemaCentral.incrementarContadorAlunos(); // Incrementa contador ao criar um aluno
    }

    // Métodos get e set
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    @Override
    public String toString() {
        return "Aluno{" + "matricula=" + matricula + ", cpf=" + cpf + ", sobrenome=" + sobrenome + ", apelido=" + apelido + '}';
    }
}
