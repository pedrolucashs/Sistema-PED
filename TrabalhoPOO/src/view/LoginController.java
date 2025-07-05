package view;

import model.*;
import java.util.*;
public class LoginController implements Observer {
    private Model model;
    private LoginView view;

    public void iniciar(Model model , LoginView view) {
        if(model != null && view != null){
            this.model = model;
            this.view = view;
            model.attachObserver(this);
        }
    }

    public void tratarEvento(String evento){
        switch(evento){
            case "OK":
                boolean autenticado = model.autenticarUsuario(view.getLogin(), view.getSenha());
                if(!autenticado){
                    view.exibirMensagem("ERRO:usuário ou senha incorretos");
                }else {
                    view.exibirMensagem("SUCESSO: Usuario autenticado!");
                    ListaTurmasProfView view5 = new ListaTurmasProfView();
                    view5.iniciar(model);
                }
                model.detachObserver(this);
                break;
        }
    }


    public void update(){}

}
