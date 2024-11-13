package Desafios;

import java.util.ArrayList;

public class Banco {
    private final String nomeDoBanco;
    private final ArrayList<Conta> contas;

    public Banco(String nomeDoBanco) {
        this.nomeDoBanco = nomeDoBanco;
        this.contas = new ArrayList<>();
    }

    public void adicionaConta(Conta c) {
        contas.add(c);
    }

    public Conta recuperaConta(int numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numeroConta) {
                return conta;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Banco{nomeDoBanco='" + nomeDoBanco + "', contas=" + contas + '}';
    }
}
