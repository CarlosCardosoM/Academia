/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author Carlo
 */

public class Acesso {
    private int matricula;
    private Data data;
    private Horario horario;
    private String tipo; // "Entrada" ou "Saída"

    // Construtor
    public Acesso(int matricula, Data data, Horario horario, String tipo) {
        this.matricula = matricula;
        this.data = data;
        this.horario = horario;
        this.tipo = tipo;
    }

    // Métodos get
    public int getMatricula() {
        return matricula;
    }

    public Data getData() {
        return data;
    }

    public Horario getHorario() {
        return horario;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDataHora() {
        return data.toString() + " " + horario.toString();
    }

    @Override
    public String toString() {
        return "Acesso{" + "matricula=" + matricula + ", data=" + data + ", horario=" + horario + ", tipo=" + tipo + '}';
    }
    
    
}

