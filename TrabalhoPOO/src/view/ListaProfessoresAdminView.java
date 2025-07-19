package view;

import java.util.*;
import model.*;

public class ListaProfessoresAdminView implements Observer{
    private Model model;
    private ListaProfessoresAdminController controller ;

    public ListaProfessoresAdminView(Model model) {
        this.model = model;
        controller = new ListaProfessoresAdminController();
        controller.init(model,this);
        model.attachObserver(this);
        ListarProfessores();
    }

    public void ListarProfessores() {
        model.detachObserver(this);
    }

    public void update() {

    }
}
