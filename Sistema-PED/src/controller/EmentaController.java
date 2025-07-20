package controller;

import model.Model;
import view.*;

public class EmentaController implements Observer{
    private Model model;
    private EmentaView view;

    public void init(Model model, EmentaView view){
        this.model = model;
        this.view = view;
    }

    public void handleEvent(String event){
        switch (event) {
            case "OK":
                String codigoTurma = view.getCodigoTurma();
                String anoSemestre = view.getAnoSemestre();
                String justificativa = view.getJustificativa();
                String ementa = view.getEmenta();
                String[] objetivos = view.getObjetivos();
                String metodologia = view.getMetodologia();
                String[] atividades = view.getAtividades();
                String sistemaAvaliacao = view.getSistemaAvaliacao();

                boolean sucessoCadastro = model.cadastrarEmenta(codigoTurma, anoSemestre, justificativa, ementa, objetivos,
                        metodologia, atividades, sistemaAvaliacao);

                if (sucessoCadastro) {
                    view.exibeMSG("SUCESSO");
                } else {
                    view.exibeMSG("ERRO: Verifique os dados.");
                }
                break;
        }
    }

    public void update(){

    }
}
