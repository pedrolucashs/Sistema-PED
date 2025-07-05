package view;
import model.*;
public class CadastroUserController implements Observer {
    private Model model ;
    private CadastroUserView view ;
    public void iniciar(Model model , CadastroUserView view){
        this.model = model;
        this.view = view;
        model.attachObserver(this);
    }
    public void tratarEvento(String evento){
        switch (evento) {
            case "OK" :
                //coloco aqui algum mapeamento p buscar o id p saber se ele ja existe em usuarios para evitar duplo cadastro ??
                model.setUsuario(view.getProfessor());
                model.detachObserver(this);
                LoginView view4 = new LoginView();
                view4.iniciar(model);
                break;
        }
    }

    public void update(){

    }

}
