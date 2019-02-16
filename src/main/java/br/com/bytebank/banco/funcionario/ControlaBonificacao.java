package br.com.bytebank.banco.funcionario;

public class ControlaBonificacao {

    private double soma;

    public double getSoma() {
        return soma;
    }

    public void registra(Funcionario g) {
        System.out.println("Gratificação do " + g.getClass().getName() + ": " + g.getBonificacao());
        if (g instanceof Diretor) {
            System.out.println(g.getClass().getName() + " não registra gratificacao");
        }
        soma += g.getBonificacao();
    }
}
