package controller;

import view.*;
import model.Model;

// Controller da view VisualizarPED, responsável por mostrar o conteúdo do Plano de Ensino
public class VisualizarPEDController implements Observer {
    private Model model;
    private VisualizarPEDView view;
    private String codigoTurma;
    private String nomeUnidade;

    // Inicializa com model, view, código da turma e nome da unidade (campus)
    public void init(Model model, VisualizarPEDView view, String codigoTurma, String nomeUnidade) {
        this.model = model;
        this.view = view;
        this.codigoTurma = codigoTurma;
        this.nomeUnidade = nomeUnidade;
    }

    // Reage a eventos da view (ex: confirmação, voltar)
    public void handleEvent(String event) {
        switch (event) {
            case "1":
                // Exibe mensagem de sucesso na finalização do PED (pode ser algo tipo "salvar" ou "concluir")
                view.exibeMSG("Plano de Ensino finalizado com sucesso!");
                break;
        }
    }

    // Pega o texto do Plano de Ensino no model e exibe na view
    public void exibirPlanoDeEnsino() {
        String plano = model.getPlanoDeEnsino(codigoTurma, nomeUnidade);
        view.exibeMSG(plano);
    }

    public void update() {
        // Pode ser usado pra atualizar view quando model muda (aqui vazio)
    }
}
