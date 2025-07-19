package view;
//importando a classe Model e outros necessarios
import model.*;

import java.util.Observable;

//essa classe é um controller da tela inicial para professor com as opções que ele tem disponivel
// essa classe implementa o observerr
public class TelaProfessorController implements Observer {
    private Model model;
    private TelaProfessorView view;

//iniciando a view com o metodo "init"
    public void init(Model model, TelaProfessorView view) {
        if (model != null && view != null){
            this.model = model;
            this.view = view;
            //isso registra esse controller como um observador do model
            model.attachObserver(this);
            //"pega" o usuario autenticado
            String l = model.getUsuarioAutenticado();
        }
    }
    // metodo para tratar eventos, (qualquer evento que o usuario causar)
    public void handleEvent(String event) {
        //isso fara com que o sistema tenha um comportamento diferente dependendo da escolha do usuario
        switch (event){
            case "1":
                if(model.getTurmasProf() != null){
                    ListaTurmasProfView view6 = new ListaTurmasProfView();
                    view6.init(model);}
                else{
                    view.exibirMensagem("nao possui turmas cadastradas ");
                }
                break;
            case "2":view.finalizarSistema();
                break;
        }
        //apos o evento ser tratado , remove esse controller como observador
        model.detachObserver(this);
    }
//metodo obrigatorio da interface Observer,porem nao implementado
    public void update() {

    }
}