import model.*;
import view.*;

public class Main {
    public static void main(String[] args) {
        Model model = Model.getInstancia();
        MainView view = new MainView();
        view.init(model);
    }
}
