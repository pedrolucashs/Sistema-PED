package view;
import java.util.*;
import model.*;

public class TurmaEscolhidaController implements Observer {
    private Model model;
    private TurmaEscolhidaView view;

    public void init(Model model, TurmaEscolhidaView view) {
        if(model!= null && view!= null){
            this.model = model;
            this.view = view;
            model.attachObserver(this);
        }
    }

    public void handleEvent(String event) {
        switch (event){
            case "1":if(model.getTurmaEscolhida().isPlanodeEnsino()){
                        EditarPlanoView view20 = new EditarPlanoView();
                        view20.init(model);
                    }else{
                        CadastroPlanoView view21 = new CadastroPlanoView();
                        view21.init(model);
                    }
            break;
            case "2":if(model.getTurmaEscolhida().isPlanodeEnsino()){
                        ConsultaView view22 = new ConsultaView();
                        view22.init(model);
                    }else{
                        view.exibirMsg("opcao invalida!");
                    }
                    break;
            default:view.exibirMsg("opcao invalida!");
        }
    }


    @Override
    public void update() {

    }
}
