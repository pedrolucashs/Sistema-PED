package controller;

import view.*;
import model.Model;

public class BibliografiaController implements Observer {
    private Model model;
    private BibliografiaView view;

    public void init(Model model, BibliografiaView view) {
        this.model = model;
        this.view = view;
    }

    public void handleEvent(String event) {
        String codigoTurma = view.getCodigoTurma();
        String idMaterial = view.getIdMaterial();
        String titulo = view.getTitulo();
        String autor = view.getAutor();
        String ano = view.getAno();
        String isbn = view.getIsbn();

        switch (event) {
            case "1":
                if(model.existeMaterial(codigoTurma, idMaterial)){
                    view.exibeMSG("ERRO: Esse ID de Material já existe!");
                } else {
                    model.addMaterial(codigoTurma, idMaterial, titulo, autor, ano, isbn);
                }
                break;
            case "2":
                if(model.existeMaterial(codigoTurma, idMaterial)){
                    model.excluirMaterial(codigoTurma, idMaterial);
                } else{
                    view.exibeMSG("ERRO: Esse material não existe!");
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
