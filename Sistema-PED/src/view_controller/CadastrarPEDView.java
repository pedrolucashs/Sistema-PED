package view_controller;

import model.Model;

public class CadastrarPEDView implements Observer {
    private Model model;
    private CadastrarPEDController controller;
    private boolean finalizar = false;

    public void init(Model model){
        if (model != null){
            this.model = model;
            controller = new CadastrarPEDController();
            controller.init(model, this);
            model.attachObserver(this);
            controller.executarCadastroPlano();
        }
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void update() {}
}
