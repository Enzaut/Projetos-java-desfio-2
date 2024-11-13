
package Desafios;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceBanco extends JFrame {
    private Banco banco = new Banco("Banco Central");

    public InterfaceBanco() {
        setTitle("Gerenciamento de Banco");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Painel de botões
        JPanel panel = new JPanel();
        
        JButton criarContaButton = new JButton("Criar Conta");
        JButton depositarButton = new JButton("Depositar");
        JButton sacarButton = new JButton("Sacar");
        JButton verSaldoButton = new JButton("Ver Saldo");

        panel.add(criarContaButton);
        panel.add(depositarButton);
        panel.add(sacarButton);
        panel.add(verSaldoButton);

        add(panel);

        // Ações dos botões
        criarContaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeroStr = JOptionPane.showInputDialog("Número da nova conta:");
                try {
                    int numero = Integer.parseInt(numeroStr);
                    Conta conta = new Conta(numero);
                    banco.adicionaConta(conta);
                    JOptionPane.showMessageDialog(null, "Conta criada com sucesso!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Número inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        depositarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeroStr = JOptionPane.showInputDialog("Número da conta:");
                String valorStr = JOptionPane.showInputDialog("Valor para depositar:");
                try {
                    int numero = Integer.parseInt(numeroStr);
                    double valor = Double.parseDouble(valorStr);
                    Conta conta = banco.recuperaConta(numero);
                    if (conta != null) {
                        conta.depositar(valor);
                        JOptionPane.showMessageDialog(null, "Depósito realizado!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Conta não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Número ou valor inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        sacarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeroStr = JOptionPane.showInputDialog("Número da conta:");
                String valorStr = JOptionPane.showInputDialog("Valor para sacar:");
                try {
                    int numero = Integer.parseInt(numeroStr);
                    double valor = Double.parseDouble(valorStr);
                    Conta conta = banco.recuperaConta(numero);
                    if (conta != null) {
                        conta.sacar(valor);
                        JOptionPane.showMessageDialog(null, "Saque realizado!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Conta não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Número ou valor inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        verSaldoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeroStr = JOptionPane.showInputDialog("Número da conta:");
                try {
                    int numero = Integer.parseInt(numeroStr);
                    Conta conta = banco.recuperaConta(numero);
                    if (conta != null) {
                        JOptionPane.showMessageDialog(null, "Saldo atual: R$" + conta.getSaldo());
                    } else {
                        JOptionPane.showMessageDialog(null, "Conta não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Número inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InterfaceBanco frame = new InterfaceBanco();
            frame.setVisible(true);
        });
    }
}
