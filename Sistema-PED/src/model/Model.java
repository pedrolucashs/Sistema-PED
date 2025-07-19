package model;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

import view_controller.*;

/*
 * Classe Modelo que provê alguns dados e serviços para views e controllers
 */
public class Model {
    /*
     * Dados do sistema
     */
    private HashMap<String,Usuario> usuarios = new HashMap<String, Usuario>(); // Usuários do sistema
    private HashMap<String,Campus> listaDeCampus = new HashMap<String, Campus>();
    private Usuario usuarioAutenticado;	// Usuário autenticado pelo sistema
    private ArrayList<Observer> observers = new ArrayList<Observer>(); // Lista de observadores interessados no modelo

    private static Model instanciaUnica; // Instância do padrão Singleton

    private Campus campus;
    private Disciplina disciplina;
    private Turma turma;
    private PlanoDeEnsino planoDeEnsino;
    private MaterialEstudo materialEstudo;

    private static Admin adminPadrao;
    private static Campus campusPadrao;


    /*
     * Construtor privado para implementação do padrão de projeto Singleton
     */
    private Model(){
        super();
    }

    public static Model getInstancia(){
        if (instanciaUnica == null){
            instanciaUnica = new Model();
            adminPadrao = new Admin("Admin", "0000", "Admin", "Senha");
            campusPadrao = new Campus("Campus", new HashMap<String, Turma>(), new HashMap<Integer, Professor>());
            adminPadrao.setUnidade(campusPadrao);

            instanciaUnica.usuarios.put(adminPadrao.getLogin(), adminPadrao);
            instanciaUnica.listaDeCampus.put(campusPadrao.getNomeUnidade(), campusPadrao);
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

    /*
     * Devolve o nome de um usuário do mapeamento
     */
    public String getNomeUsuario(String login) {
        if (login != null) {
            Usuario usuario = usuarios.get(login);
            if (usuario != null){
                return usuario.getNome();
            }
        }
        return "";
    }

    /*
     * Devolve o login do usuário autenticado
     */
    public String getUsuarioLogin() {
        if (usuarioAutenticado != null) {
            return usuarioAutenticado.getLogin();
        }
        return "";
    }

    /*
     * Adiciona um usuário no mapeamento
     */
    public void setUsuario(String nome, String login, int id, String senha) {
        if (nome!= null && login != null && id != null && senha != null) {
            usuarios.put(login, new Usuario(nome, id, login, senha));
            notifica();
        }
    }

    /*
     * Serviço para autenticar um usuário
     */
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
        if(usuarioAutenticado != null && usuarioAutenticado.getTurmas() != null){
            return usuarioAutenticado.getTurmas();
        }
        return null;
    }
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

    public String getPlanoDeEnsino(String codigoTurma){
        String s = String.format("PLANO DE ENSINO");
        s+= String.format("1.IDENTIFICAÇÃO");
        s+= String.format("1.1 UNIDADE: " + campus.getNomeUnidade());
        s+= String.format("1.2 CURSOS: " + campus.getCursos());
        s+= String.format("1.3 ESTRUTURA CURRICULAR: " + disciplina.getEstruturaCurricular());
        s+= String.format("1.4 NOME DA DISCIPLINA: " + disciplina.getNomeDisciplina());
        s+= String.format("1.5 CÓDIGO DA DISCIPLINA: " + disciplina.getCodigo());
        s+= String.format("1.6 CARÁTER DA DISCIPLINA: " + disciplina.getCaraterDisciplina());
        s+= String.format("1.7 REGIME DE OFERTA DA DISCIPLINA: " + disciplina.getRegimeOferta());
        s+= String.format("1.8 CARGA HORÁRIA: %d | CH TEÓRICA: %d | CH PRÁTICA: %d | CH EAD: %d | CH EXTENSÃO: %d" + disciplina.getChTotal(), disciplina.getChTeorica(), disciplina.getChPratica(), disciplina.getChEAD(), disciplina.getChExtensao()));
        s+= String.format("1.9 PRÉ-REQUISITOS: " + disciplina.getPreRequisitos());
        s+= String.format("1.10 CO-REQUISITOS: " + disciplina.getCoRequisitos());
        s+= String.format("1.11 EQUIVALÊNCIAS: " + disciplina.getEquivalencias());
        s+= String.format("1.12 PROFESSOR: " + model.getNomeUsuario());
        s += String.format("/n/n");
        s += String.format("2. JUSTIFICATIVA");
        s += String.format(planoDeEnsino.getJustificativa());
        s += String.format("/n/n");
        s += String.format("3. EMENTA");
        s += String.format(planoDeEnsino.getEmenta());
        s += String.format("/n/n");
        s += String.format("4. OBJETIVOS - GERAL E ESPECÍFICOS");
        s += String.format("OBJETIVOS GERAIS:");
        s += String.format(planoDeEnsino.getObjetivosGerais());
        s += String.format("/n");
        s += String.format("OBJETIVOS ESPECÍFICOS:");
        s += String.format(planoDeEnsino.getObjetivosEspecificos());
        s += String.format("/n/n");
        s += String.format("5. CALENDÁRIO DE ATIVIDADES");
        s += String.format(planoDeEnsino.getCalendarioAtividades());
        s += String.format("/n/n");
        s += String.format("6. METODOLOGIA DE ENSINO");
        s += String.format(planoDeEnsino.getMetodologia());
        s += String.format("/n/n");
        s += String.format("7. ATIVIDADES DISCENTES");
        s += String.format(planoDeEnsino.getAtividades());
        s += String.format("/n/n");
        s += String.format("8. SISTEMA DE AVALIAÇÃO");
        s += String.format(planoDeEnsino.getSistemaAvaliacao());
        s += String.format("/n/n");
        s += String.format("9. BIBLIOGRAFIA BÁSICA E COMPLEMENTAR");
        s += String.format("BIBLIOGRAFIA BÁSICA:");
        s += String.format(planoDeEnsino.getBibliografiaBasica());
        s += String.format("/n");
        s += String.format("BIBLIOGRAFIA COMPLEMENTAR:");
        s += String.format(planoDeEnsino.getBibliografiaComplementar());
        s += String.format("/n/n");

        return s;
    }

    public boolean excluirTurma(String codigoTurma){
        Admin admin = (Admin)usuarioAutenticado;

        Turma turma = admin.getUnidade().getTurmas().get(codigoTurma);
        if (turma != null) {
            admin.getUnidade().getTurmas().remove(codigoTurma);
            notifica();
            return true;
        } else {
            return false;
        }
    }

    public int getTotalUsuarios() {
        return usuarios.size();
    }
}