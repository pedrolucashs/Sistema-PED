package controller;
import view.*;
import model.Model;

// Controller da view TurmaEscolhida, que mostra opções de ações pra turma selecionada
public class TurmaEscolhidaController implements Observer{
    private Model model;
    private TurmaEscolhidaView view;

    // Inicializa com o model e a view, e já se inscreve pra receber updates do model
    public void init(Model model, TurmaEscolhidaView view){
        this.model = model;
        this.view = view;
        model.attachObserver(this);
    }

    // Reage aos eventos da view (botões, menus)
    public void handleEvent(String event){
        String codigoTurma = view.getCodigoTurma(); // pega o código da turma selecionada
        switch(event){
            case "1":
                // Abre a view pra editar o Plano de Ensino dessa turma
                EditarPEDView view1 = new EditarPEDView();
                view1.init(model, codigoTurma);
                break;
            case "2":
                // Abre a view pra visualizar o Plano de Ensino dessa turma
                VisualizarPEDView view2 = new VisualizarPEDView();
                // Passa o código da turma e o campus que pega do model
                view2.init(model, codigoTurma, model.getCampus());
                break;
            case "0":
                // Finaliza a view atual e para de escutar o model
                view.finalizar();
                model.detachObserver(this);
                break;
        }
    }

    public void update(){
        // Pode ser usado pra atualizar a view quando o model mudar (aqui tá vazio)
    }
}
