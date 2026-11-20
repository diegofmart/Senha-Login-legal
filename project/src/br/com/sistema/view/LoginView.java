package br.com.sistema.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JTextField txtLogin;
    private JPasswordField txtSenha;
    private JButton btnEntrar;
    private JButton btnCadastrar;
    private JLabel lblStatus;

    public LoginView() {
        setTitle("Acesso ao Sistema");
        setSize(360, 230);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout(10, 10));

        // Campos de login e senha
        JPanel painelCampos = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 15, 8, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblLogin = new JLabel("Login:");
        lblLogin.setFont(lblLogin.getFont().deriveFont(Font.BOLD));
        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setFont(lblSenha.getFont().deriveFont(Font.BOLD));

        txtLogin = new JTextField(15);
        txtSenha = new JPasswordField(15);

        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0;
        painelCampos.add(lblLogin, gbc);
        gbc.gridx = 1; gbc.weightx = 1;
        painelCampos.add(txtLogin, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0;
        painelCampos.add(lblSenha, gbc);
        gbc.gridx = 1; gbc.weightx = 1;
        painelCampos.add(txtSenha, gbc);

        // Botões
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        btnEntrar = new JButton("Entrar");
        btnCadastrar = new JButton("Novo Usuário");
        painelBotoes.add(btnEntrar);
        painelBotoes.add(btnCadastrar);

        // Status
        JPanel painelStatus = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lblStatus = new JLabel(" ");
        painelStatus.add(lblStatus);

        JPanel painelSul = new JPanel(new BorderLayout());
        painelSul.add(painelBotoes, BorderLayout.NORTH);
        painelSul.add(painelStatus, BorderLayout.SOUTH);

        add(painelCampos, BorderLayout.CENTER);
        add(painelSul, BorderLayout.SOUTH);

        // Enter no teclado aciona o botão "Entrar"
        getRootPane().setDefaultButton(btnEntrar);
    }

    public String getLogin() { return txtLogin.getText(); }

    public String getSenha() { return new String(txtSenha.getPassword()); }

    public void limparCampos() {
        txtLogin.setText("");
        txtSenha.setText("");
        txtLogin.requestFocus();
    }

    public void exibirMensagem(String mensagem, Color cor) {
        lblStatus.setForeground(cor);
        lblStatus.setText(mensagem);
    }

    public void addEntrarListener(ActionListener listener) {
        btnEntrar.addActionListener(listener);
    }

    public void addCadastrarListener(ActionListener listener) {
        btnCadastrar.addActionListener(listener);
    }
}
