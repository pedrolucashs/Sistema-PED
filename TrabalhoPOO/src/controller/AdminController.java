package controller;

import view.*;
import model.Model;

// Controller da parte do Admin, que observa eventos da view e age conforme o que o Admin pede
public class AdminController implements Observer {
    private Model model;
    private AdminView view;

    // Inicializa o controller com o model e a view do Admin
    public void init(Model model, AdminView view) {
        this.model = model;
        this.view = view;
    }

    // Aqui é onde o controller reage ao evento vindo da view
    public void handleEvent(String event) {
        switch (event) {
            case "0": // Desloga o usuário e fecha o sistema
                model.deslogarUsuario();
                view.finalizarSistema();
                break;
            case "1": // Abre a tela para cadastrar turma
                CadastrarTurmaView view1 = new CadastrarTurmaView();
                view1.init(model);
                break;
            case "2": // Abre a tela para cadastrar professor
                CadastrarProfView view2 = new CadastrarProfView();
                view2.init(model);
                break;
            case "3": // Abre a tela para excluir turma
                ExcluirTurmaView view3 = new ExcluirTurmaView();
                view3.init(model);
                break;
            case "4": // Abre a tela para excluir professor
                ExcluirProfView view4 = new ExcluirProfView();
                view4.init(model);
                break;
            case "5": // Abre a tela para listar turmas
                ListarTurmasView view5 = new ListarTurmasView();
                view5.init(model);
                break;
            case "6": // Abre a tela para listar professores
                ListarProfView view6 = new ListarProfView();
                view6.init(model);
                break;
        }
    }

    // Método vazio para atender interface Observer (pode ser usado para atualizar view)
    public void update(){
    }
}
