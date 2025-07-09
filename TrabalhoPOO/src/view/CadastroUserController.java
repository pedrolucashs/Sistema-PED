package view;
import model.*;
public class CadastroUserController implements Observer {
    private Model model ;
    private CadastroUserView view ;
    public void init(Model model , CadastroUserView view){
        this.model = model;
        this.view = view;
        model.attachObserver(this);
    }
    public void handleEvent(String evento){
        switch (evento) {
            case "OK" :
                //coloco aqui algum mapeamento p buscar o id p saber se ele ja existe em usuarios para evitar duplo cadastro ??
                Professor prof = view.getProfessor();
                model.setUsuario(prof.getNome(), prof.getLogin(), prof.getSenha(), prof.getId());
                model.detachObserver(this);
                LoginView view4 = new LoginView();
                view4.init(model);
                break;
        }
    }

    public void update(){

    }

}
