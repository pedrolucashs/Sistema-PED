package model;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

import view.*;

/*
 * Classe Modelo que provê alguns dados e serviços para views e controllers
 */
public class Model {
    /*
     * Dados do sistema
     */
    private HashMap<String,Usuario> usuarios = new HashMap<String, Usuario>(); // Usuários do sistema
    private Usuario usuarioAutenticado;	// Usuário autenticado pelo sistema
    private ArrayList<Observer> observers = new ArrayList<Observer>(); // Lista de observadores interessados no modelo

    private static Model instanciaUnica; // Instância do padrão Singleton


    /*
     * Construtor privado para implementação do padrão de projeto Singleton
     */
    private Model(){
        super();
    }

    public static Model getInstancia(){
        if (instanciaUnica == null){
            instanciaUnica = new Model();
        }
        return instanciaUnica;
    }

    /*
     * Método utilizado para notificar todos os observadores contidos no ArrayList que o modelo mudou
     */
    public void notifica() {
        for (Observer o : observers) {
            o.update(); // update é a operação definida na interface Observer
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
            usuarios.put(login, new Professor(nome, login, senha, id));
            notifica();
        }
    }
//esse set usuario so seta professor????se sim podemos mudar o nome de usuarios p professores ja que teremos outros usuarios , e criar um map novo de coordenadores ou coordenador sla.

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

    /*
     * Desloga um usuário do sistema
     */
    public void deslogarUsuario() {
        usuarioAutenticado = null;
        notifica();
    }


    public List<Turma> getTurmasProf() {
        if(usuarioAutenticado != null){
                if(usuarioAutenticado instanceof Professor){
                    Professor prof = (Professor) usuarioAutenticado;
                    if (prof.getTurmas() != null){
                        return prof.getTurmas();
                    }
            }
        }
        return null;
    }//mudei aq porque como criei o professor e o coordenandor ai ficou louco aq o negocio;
    /*
     * Devolve o usuário autenticado. Se não tiver nenhum usuário autenticado ele devolve null
     */
    public String getUsuarioAutenticado() {
        if (usuarioAutenticado != null){
            return usuarioAutenticado.getLogin();
        } else {
            return "";
        }
    }

    /*
     * Registra um observador na lista de observadores
     */
    public void attachObserver(Observer observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    /*
     * Exclui um observador da lista de observadores
     */
    public void detachObserver(Observer observer) {
        if (observer != null) {
            observers.remove(observer);
        }
    }

    /*
     * Informa o total de usuários cadastrados
     */
    public int getTotalUsuarios() {
        return usuarios.size();
    }


}