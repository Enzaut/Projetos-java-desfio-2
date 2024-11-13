package Desafios;

import javax.swing.JOptionPane;

public class Conta {
    private final int numero;
    private double saldo;

    public Conta(int numero) {
        this.numero = numero;
        this.saldo = 0.0;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        } else {
            JOptionPane.showMessageDialog(null, "Valor de depósito inválido. Deve ser maior que zero.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
        } else if (valor <= 0) {
            JOptionPane.showMessageDialog(null, "Valor de saque inválido. Deve ser maior que zero.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return "Conta{numero=" + numero + ", saldo=" + saldo + '}';
    }
}
