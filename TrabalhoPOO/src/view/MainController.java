package view;

import model.*;
public class MainController implements Observer {
    private Model model;
    private MainView view;

    public void iniciar(Model model , MainView view){
        if(model != null && view != null){
            this.model = model;
            this.view = view;
        }
    }

    public void tratarEvento(String evento){
        switch(evento){
            case "1": if(model.getUsuarioAutenticado() == ""){
                LoginView view3 = new LoginView();
                view3.iniciar(model);
                }else {
                    model.deslogarUsuario();
                }
            break;
            case "2":CadastroUserView view2 = new CadastroUserView();
                     view2.iniciar(model);
                     break;
            case "3": view.finalizarSistema();
                      break;

        }
    }

    public void update(){

    };
}
