package view_controller;

import model.*;
import java.util.Scanner;

public class CadastrarPEDController {
    private Model model;
    private CadastrarPEDView view;

    public void executarCadastroPlano() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

    public void init(Model model, CadastrarPEDView view) {
        this.model = model;
        this.view = view;
    }

    public void cadastrarPED(String conteudo) {
        if (conteudo == null || conteudo.trim().isEmpty()) {
            view.exibirMensagem("Erro: o conteúdo do Plano de Ensino não pode ser vazio.");
            return;
        }

        boolean sucesso = model.cadastrarPlanoDeEnsino(conteudo);

        if (sucesso) {
            view.exibirMensagem("Plano de Ensino cadastrado com sucesso!");
        } else {
            view.exibirMensagem("Erro ao cadastrar o Plano de Ensino.");
        }
}
