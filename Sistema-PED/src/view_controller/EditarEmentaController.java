package view_controller;


public class EditarEmentaController {
    private PlanoDeEnsino plano;

    public EditarEmentaController(PlanoDeEnsino plano) {
        this.plano = plano;
    }

    public void atualizarAnoSemestre(String anoSemestre) {
        plano.setAnoSemestre(anoSemestre);
    }

    public void atualizarJustificativa(String justificativa) {
        plano.setJustificativa(justificativa);
    }

    public void atualizarEmenta(String ementa) {
        plano.setEmenta(ementa);
    }

    public void atualizarObjetivoGeral(String objetivoGeral) {
        plano.setObjetivoGeral(objetivoGeral);
    }

    public void atualizarObjetivosEspecificos(List<String> objetivos) {
        plano.setObjetivosEspecificos(objetivos);
    }

    public void atualizarConteudos(List<String> conteudos) {
        plano.setConteudos(conteudos);
    }

    public PlanoDeEnsino getPlanoAtualizado() {
        return plano;
    }
}

