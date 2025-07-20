package controller;

import model.Model;
import view.*;

/**
 * Controller responsável pela interação da view de Ementa com o model.
 * Implementa o padrão Observer para atualizações.
 */
public class EmentaController implements Observer {
    private Model model;   // Referência ao model principal
    private EmentaView view; // Referência à view de Ementa

    // Inicializa o controller com o model e a view.
     
    public void init(Model model, EmentaView view) {
        this.model = model;
        this.view = view;
    }

    // Trata eventos disparados pela view, processando os dados da ementa.

    public void handleEvent(String event) {
        switch (event) {
            case "OK":
                // Coleta dados da view
                String codigoTurma = view.getCodigoTurma();
                String anoSemestre = view.getAnoSemestre();
                String justificativa = view.getJustificativa();
                String ementa = view.getEmenta();
                String[] objetivos = view.getObjetivos();
                String metodologia = view.getMetodologia();
                String[] atividades = view.getAtividades();
                String sistemaAvaliacao = view.getSistemaAvaliacao();

                // Chama o método do model para cadastrar a ementa com os dados coletados
                boolean sucessoCadastro = model.cadastrarEmenta(codigoTurma, anoSemestre, justificativa, ementa, objetivos,
                        metodologia, atividades, sistemaAvaliacao);

                // Exibe mensagem na view de acordo com o resultado do cadastro
                if (sucessoCadastro) {
                    view.exibeMSG("SUCESSO");
                } else {
                    view.exibeMSG("ERRO: Verifique os dados.");
                }
                break;
        }
    }

    // Método chamado quando o model notifica os observers.
     
    public void update() {
    }
}

