package br.com.bytebank.banco.funcionario;

/**
 * Classe que representa Funcionario abstrato
 * @author Rodrigo
 * @version 0.01
 */

public abstract class Funcionario {
    private String nome;
    private String cpf;
    private double salario;

    public Funcionario() {
        System.out.println("Criando br.com.bytebank.banco.funcionario.Funcionario Abtstrato!");
    }

    //Método sem corpo definido e obrigatorio nos filhos
    public abstract double getBonificacao();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
