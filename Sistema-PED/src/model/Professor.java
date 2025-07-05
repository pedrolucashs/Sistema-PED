package model;

import java.util.List;

public class Professor extends Usuario{
    private int id;
    private List<Turma> turmas;

    public Professor(String nome, String login, String senha, int id) {
        super(nome, login, senha);
        setId(id);
    }

    public int getId(){ return id; }
    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public List<Turma> getTurmas(){return turmas;}
    public void setTurmas(List<Turma> turmas){
        if (turmas != null) {
            this.turmas = turmas;
        }
    }

}
