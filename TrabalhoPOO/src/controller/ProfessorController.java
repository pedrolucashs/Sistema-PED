package controller;
//importando a classe Model e outros necessarios
import model.Model;
import view.*;

//essa classe é um controller da tela inicial para professor com as opções que ele tem disponivel
// essa classe implementa o observerr
public class ProfessorController implements Observer {
    private Model model;
    private ProfessorView view;

    //iniciando a view com o metodo "init"
    public void init(Model model, ProfessorView view) {
        if (model != null && view != null){
            this.model = model;
            this.view = view;
            //isso registra esse controller como um observador do model
            model.attachObserver(this);
        }
    }
    // metodo para tratar eventos, (qualquer evento que o usuario causar)
    public void handleEvent(String event) {
        //isso fara com que o sistema tenha um comportamento diferente dependendo da escolha do usuario
        switch (event){
            case "1":
                if(model.existeTurmas()){
                    ListarTurmasView view2 = new ListarTurmasView();
                    view2.init(model);
                }
                else{
                    view.exibirMensagem("Não possui turmas cadastradas ");
                }
                break;
            case "2":
                model.deslogarUsuario();
                view.finalizar();
                break;
        }
        //apos o evento ser tratado , remove esse controller como observador
        model.detachObserver(this);
    }
    //metodo obrigatorio da interface Observer,porem nao implementado
    public void update() {

    }
}