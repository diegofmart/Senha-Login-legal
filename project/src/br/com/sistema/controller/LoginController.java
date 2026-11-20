package br.com.sistema.controller;

import br.com.sistema.model.AutenticacaoModel;
import br.com.sistema.model.UsuarioModel;
import br.com.sistema.view.CadastroView;
import br.com.sistema.view.LoginView;

import java.awt.Color;
import java.util.List;

public class LoginController {

    private static final Color VERDE = new Color(0, 128, 0);

    public LoginController(AutenticacaoModel authModel, LoginView loginView) {

        // Botão ENTRAR
        loginView.addEntrarListener(e -> {
            String login = loginView.getLogin();
            String senha = loginView.getSenha();

            if (login.trim().isEmpty() || senha.trim().isEmpty()) {
                loginView.exibirMensagem("Informe login e senha!", Color.RED);
                return;
            }

            if (authModel.autenticar(login, senha)) {
                loginView.dispose();
                abrirTelaCadastro();
            } else {
                loginView.exibirMensagem("Login/Senha incorretos!", Color.RED);
            }
        });

        // Botão NOVO USUÁRIO
        loginView.addCadastrarListener(e -> {
            String login = loginView.getLogin();
            String senha = loginView.getSenha();

            if (login.trim().isEmpty() || senha.trim().isEmpty()) {
                loginView.exibirMensagem("Informe login e senha!", Color.RED);
                return;
            }

            if (authModel.cadastrarNovoUsuario(login, senha)) {
                loginView.exibirMensagem("Login cadastrado com sucesso!", VERDE);
            } else {
                loginView.exibirMensagem("Erro: login já existe ou falha no banco!", Color.RED);
            }
        });
    }

    // Abre a tela principal de cadastro de nomes (já existente)
    private void abrirTelaCadastro() {
        UsuarioModel model = new UsuarioModel();
        CadastroView view = new CadastroView();

        List<String> usuariosSalvos = model.getUsuarios();
        for (int i = 0; i < usuariosSalvos.size(); i++) {
            view.adicionarLinhaTabela(i + 1, usuariosSalvos.get(i));
        }

        new CadastroController(model, view);
        view.setVisible(true);
    }
}
