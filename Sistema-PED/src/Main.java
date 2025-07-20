import model.*;
import view.*;

public class Main {
    public static void main(String[] args) {
        //O usuário padrão é: Nome de Usuário - Admin, Senha - Senha
        Model model = Model.getInstancia();
        MainView view = new MainView();
        view.init(model);
    }
}
