package view_controller;
import model.*;

public class PlanoDeEnsinoController implements Observer {
    private Model model;
    private PlanoDeEnsinoView view;

    public void init(Model model, PlanoDeEnsinoView view) {
        this.model = model;
        this.view = view;
        model.attachObserver(this);
    }

    public void handleEvent(String event) {
        switch (event) {
            case "1":
                view.exibirMensagem("Plano de Ensino finalizado com sucesso!");
                TurmaSelecionada view = new TurmaSelecionada();
                view.init(model);
                break;
            case "2":
                view.exibirMensagem("Gerando PDF");
                GerarPdf view = new GerarPdf();
                view.init(model);
                break;
        }
    }

    public void exibirPlanoDeEnsino(String codigoTurma) {
        String plano = model.getPlanoDeEnsino(codigoTurma);
        view.exibirMensagem(plano);
    }

    public void update() {}
}
