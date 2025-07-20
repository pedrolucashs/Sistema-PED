package controller;

import view.*;
import model.Model;

// Controller para cadastrar turma
public class CadastrarTurmaController implements Observer {
    Model model;
    CadastrarTurmaView view;

    public void init(Model model, CadastrarTurmaView view) {
        this.model = model;
        this.view = view;
    }

    // Trata evento de confirmação para cadastrar a turma com os dados coletados da view
    public void handleEvent(String event) {
        switch (event) {
            case "OK":
                String idProfessor = view.getIdProfessor();
                String codigoTurma = view.getCodigoTurma();
                String codigoDisciplina = view.getCodigoDisciplina();
                String nomeUnidade = model.getCampus();
                String nomeDisciplina = view.getNomeDisciplina();
                String caraterDisciplina = view.getCaraterDisciplina();
                String regimeOferta = view.getRegimeOferta();
                String estruturaCurricular = view.getEstruturaCurricular();
                int cargaHoraria = view.getCargaHoraria();

                // Tenta cadastrar turma no model e exibe mensagem de sucesso ou erro
                boolean sucessoCadastro = model.cadastrarTurma(idProfessor,
                        codigoTurma, codigoDisciplina, nomeUnidade, nomeDisciplina,
                        caraterDisciplina, regimeOferta, estruturaCurricular,
                        cargaHoraria
                );

                if (sucessoCadastro) {
                    view.exibeMSG("SUCESSO: Turma cadastrada com êxito!");
                } else {
                    view.exibeMSG("ERRO: Falha ao cadastrar turma. Verifique os dados.");
                }
                break;
        }
    }

    public void update(){

    }
}
