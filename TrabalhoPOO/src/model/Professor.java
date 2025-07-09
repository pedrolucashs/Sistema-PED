package model;

import java.util.List;

public class Professor extends Usuario{
    private int id;
    private List<Turma> turmas;

    public Professor(String nome, String login, String senha, int id) {
        setNome(nome);
        setLogin(login);
        setSenha(senha);
        setId(id);
    }
    public Professor(){
        super();
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public  void setTurmas(List<Turma> turmas){
        this.turmas = turmas;
    }
    public List<Turma> getTurmas(){
        return turmas;
    }
}
