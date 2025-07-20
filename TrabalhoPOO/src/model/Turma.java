package model;

// Classe que representa uma Turma de uma disciplina
public class Turma {
    private String codigoTurma; // Código identificador da turma
    private Disciplina disciplina; // Disciplina associada à turma
    private PlanoDeEnsino plano; // Plano de ensino da turma

    // Construtor da turma recebendo código, disciplina e nome do professor
    public Turma(String codigoTurma, Disciplina disciplina, String nomeProfessor) {
        setCodigoTurma(codigoTurma);
        setDisciplina(disciplina);
        setPlano(new PlanoDeEnsino(nomeProfessor)); // Cria um novo plano com base no nome do professor
    }

    // Retorna o código da turma
    public String getCodigoTurma() {
        return codigoTurma;
    }

    // Define o código da turma
    public void setCodigoTurma(String codigoTurma) {
        this.codigoTurma = codigoTurma;
    }

    // Retorna a disciplina associada à turma
    public Disciplina getDisciplina() {
        return disciplina;
    }

    // Define a disciplina da turma (se for diferente de null)
    public void setDisciplina(Disciplina disciplina) {
        if (disciplina != null) {
            this.disciplina = disciplina;
        }
    }

    // Retorna o plano de ensino da turma
    public PlanoDeEnsino getPlano() {
        return plano;
    }

    // Define o plano de ensino da turma (se for diferente de null)
    public void setPlano(PlanoDeEnsino plano) {
        if (plano != null) {
            this.plano = plano;
        }
    }

    // Retorna uma representação textual da turma com informações detalhadas
    public String toString() {
        String retorno = String.format(
            "Código da Turma: %s\nCampus: %s\nNome da Disciplina: %s\nCaráter da Disciplina: %s\nRegime de Oferta: %s\nCarga Horária: %d",
            getCodigoTurma(),
            getDisciplina().getUnidade(),
            getDisciplina().getNomeDisciplina(),
            getDisciplina().getCaraterDisciplina(),
            getDisciplina().getRegimeOferta(),
            getDisciplina().getCargaHoraria()
        );
        return retorno;
    }
}
