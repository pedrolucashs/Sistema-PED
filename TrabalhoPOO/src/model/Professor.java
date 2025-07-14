package model;

import java.util.*;

public class Professor extends Usuario{
    private int id;
    private HashMap<String,Turma> turmas;

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
    public  void setTurmas( Turma turma){
        turmas.put(turma.getCodigoTurma(), turma);
    }
    public HashMap<String, Turma> getTurmas(){
        return turmas;
    }
}
