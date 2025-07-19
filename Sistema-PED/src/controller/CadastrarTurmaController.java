package controller;

import view.*;
import model.Model;

public class CadastrarTurmaController implements Observer {
    Model model;
    CadastrarTurmaView view;

    public void init(Model model, CadastrarTurmaView view) {
        this.model = model;
        this.view = view;
    }

    public void handleEvent(String event) {
        switch (event) {
            case "OK":
                String codigoTurma = view.getCodigoTurma();
                String codigoDisciplina = view.getCodigoDisciplina();
                String nomeUnidade = model.getCampus();
                String nomeDisciplina = view.getNomeDisciplina();
                String caraterDisciplina = view.getCaraterDisciplina();
                String regimeOferta = view.getRegimeOferta();
                String estruturaCurricular = view.getEstruturaCurricular();
                int cargaHoraria = view.getCargaHoraria();

                boolean sucessoCadastro = model.cadastrarTurma(
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
