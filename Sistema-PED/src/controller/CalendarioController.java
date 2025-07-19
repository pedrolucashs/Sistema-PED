package controller;

import view.*;
import model.Model;

public class CalendarioController implements Observer {
    private Model model;
    private CalendarioView view;

    public void init(Model model, CalendarioView view) {
        this.model = model;
        this.view = view;
    }

    public void handleEvent(String event) {
        String codigoTurma = view.getCodigoTurma();
        String idAtividade = view.getIdAtividade();
        String data = view.getData();
        String descricao = view.getDescricao();
        int cargaHoraria = view.getCargaHoraria();

        switch (event) {
            case "1":
                if(model.existeAtividade(codigoTurma, idAtividade)){
                    view.exibeMSG("ERRO: Esse ID de Atividade já existe!");
                } else {
                    model.addAtividade(codigoTurma, idAtividade, data, descricao, cargaHoraria);
                }
                break;
            case "2":
                if(model.existeAtividade(codigoTurma, idAtividade)){
                    model.excluirAtividade(codigoTurma, idAtividade);
                } else{
                    view.exibeMSG("ERRO: Essa atividade não existe!");
                }
                break;
            case "0":
                view.finalizar();
                break;
        }
    }

    public void update(){

    }
}
