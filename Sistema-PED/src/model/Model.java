package model;

import java.util.HashMap;
import java.util.ArrayList;
import view.*;

public class Model {
    private HashMap<String,Usuario> usuarios = new HashMap<String, Usuario>();
    private HashMap<String,Campus> listaDeCampus = new HashMap<String, Campus>();
    private Usuario usuarioAutenticado;
    private ArrayList<Observer> observers = new ArrayList<Observer>();

    private static Model instanciaUnica;

    private Model(){
        super();
    }

    public static Model getInstancia(){
        if (instanciaUnica == null){
            instanciaUnica = new Model();
        }
        return instanciaUnica;
    }

    public void notifica() {
        for (Observer o : observers) {
            o.update();
        }
    }

    public String getNomeUsuario(String login) {
        if (login != null) {
            Usuario usuario = usuarios.get(login);
            if (usuario != null){
                return usuario.getNome();
            }
        }
        return "";
    }

    public String getUsuarioLogin() {
        if (usuarioAutenticado != null) {
            return usuarioAutenticado.getLogin();
        }
        return "";
    }

    public void setUsuario(String nome, String login, String senha, int id) {
        if (nome != null && login != null && senha != null) {
            usuarios.put(login, new Usuario(nome, id, login, senha));
            notifica();
        }
    }

    public boolean autenticarUsuario(String login, String senha) {
        Usuario usuario;
        boolean autenticado = false;
        if (login != null && senha != null) {
            usuario = usuarios.get(login);
            if (usuario != null) {
                if (login.equals(usuario.getLogin()) && senha.equals(usuario.getSenha())){
                    usuarioAutenticado = usuario;
                    autenticado = true;
                }
            }
        }
        notifica();
        return autenticado;
    }

    public void deslogarUsuario() {
        usuarioAutenticado = null;
        notifica();
    }

    public String getUsuarioAutenticado() {
        if (usuarioAutenticado != null){
            return usuarioAutenticado.getLogin();
        } else {
            return "";
        }
    }

    public int getTotalUsuarios() {
        return usuarios.size();
    }

    public void attachObserver(Observer observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    public void detachObserver(Observer observer) {
        if (observer != null) {
            observers.remove(observer);
        }
    }

    public Turma getTurma(String codigoTurma, String nomeUnidade) {
        if(listaDeCampus.containsKey(nomeUnidade)){
            Campus campus = listaDeCampus.get(nomeUnidade);
            if(campus.getTurmas().containsKey(codigoTurma)){
                return campus.getTurmas().get(codigoTurma);
            }
        }
        return null;
    }

    public boolean existePED(String codigoTurma, String nomeUnidade){
        if(getTurma(codigoTurma,nomeUnidade) != null){
            Turma turma = getTurma(codigoTurma,nomeUnidade);
            if(turma.getPlano() != null){
                return true;
            }
        }
        return false;
    }
}