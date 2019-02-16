package br.com.bytebank.banco.modelo;

import br.com.bytebank.banco.funcionario.AutenticacaoUtil;
import br.com.bytebank.banco.funcionario.Autenticavel;

public class Cliente implements Autenticavel {
    private String nome;
    private String cpf;
    private String profissao;
    private AutenticacaoUtil util;

    public Cliente() {
        this.util = new AutenticacaoUtil();
    }

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

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    @Override
    public int getSenha() {
        return this.util.getSenha();
    }

    @Override
    public void setSenha(int senha) {
        this.util.setSenha(senha);
    }

    @Override
    public boolean autentica(int senha) {
        return this.util.autentica(senha);
    }
}
