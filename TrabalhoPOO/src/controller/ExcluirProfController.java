package controller;

import model.Model;
import model.exceptions.PermissaoNegadaException;
import model.exceptions.ProfessorNaoEncontradoException;

import view.Observer;
import view.ExcluirProfView;

// Controller para excluir professores, trata exceções específicas e interação contínua
public class ExcluirProfController implements Observer {
    private Model model;
    private ExcluirProfView view;

    public void init(Model model, ExcluirProfView view) {
        this.model = model;
        this.view = view;
    }

    // Loop para tentar excluir vários professores até o usuário cancelar
    public void iniciarExclusaoProfessor() {
        boolean continuar = true;

        while (continuar) {
            view.exibirMensagem(String.format("=== Exclusão de Professor ==="));
            view.exibirMensagem(String.format("Digite o id do professor que deseja excluir:"));
            String codigoProfessor = view.lerEntrada();

            try {
                this.model.excluirProfessor(codigoProfessor);
                view.exibirMensagem(String.format("Professor excluído com sucesso."));
            } catch (PermissaoNegadaException e) {
                view.exibirMensagem(String.format("Erro de permissão: %s", e.getMessage()));
            } catch (ProfessorNaoEncontradoException e) {
                view.exibirMensagem(String.format("Erro de exclusão: %s", e.getMessage()));
            } catch (Exception e) {
                view.exibirMensagem(String.format("Ocorreu um erro inesperado: %s", e.getMessage()));
            }

            view.exibirMensagem(String.format("\nDeseja excluir outro professor? (s/n):"));
            String resposta = view.lerEntrada();
            continuar = resposta.equalsIgnoreCase("s");
        }

        view.exibirMensagem(String.format("Encerrando exclusão de professores."));
    }

    public void update() {
    }
}
