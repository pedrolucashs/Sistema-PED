package model;

import java.util.HashMap;
import java.util.ArrayList;
import view.*;
// Classe principal que representa o modelo da aplicação (Padrão Singleton)
public class Model {
    private HashMap<String,Usuario> usuarios = new HashMap<String, Usuario>();// Armazena todos os usuários
    private HashMap<String,Campus> listaDeCampus = new HashMap<String, Campus>();// Armazena todos os campus
    private Usuario usuarioAutenticado;// Usuário atualmente logado
    private ArrayList<Observer> observers = new ArrayList<Observer>();// Lista de observadores (para notificação de mudanças)

    private static Model instanciaUnica;// Instância única (singleton
    private static Admin adminPadrao;
    private static Campus campusPadrao;
      // Construtor privado (singleton)
    private Model(){
        super();
    }
    // Método que retorna a instância única da classe (cria se não existir)
    public static Model getInstancia(){
        if (instanciaUnica == null){
            instanciaUnica = new Model();
            adminPadrao = new Admin("Admin", "0000", "Admin", "Password");
            campusPadrao = new Campus("Russas", new HashMap<String, Turma>(), new HashMap<String, Professor>());
            adminPadrao.setUnidade(campusPadrao);

            instanciaUnica.usuarios.put(adminPadrao.getLogin(), adminPadrao);
            instanciaUnica.listaDeCampus.put(campusPadrao.getNomeUnidade(), campusPadrao);
        }
        return instanciaUnica;
    }
     // Notifica todos os observadores
    public void notifica() {
        for (Observer o : observers) {
            o.update();
        }
    }
    // Retorna o nome de um usuário a partir do login
    public String getNomeUsuario(String login) {
        if (login != null) {
            Usuario usuario = usuarios.get(login);
            if (usuario != null){
                return usuario.getNome();
            }
        }
        return "";
    }
    // Retorna o login do usuário autenticado
    public String getUsuarioLogin() {
        if (usuarioAutenticado != null) {
            return usuarioAutenticado.getLogin();
        }
        return "";
    }
    // Cadastra um novo professor no sistema
    public boolean setUsuario(String nome, String id, String login, String senha) {
        if (nome != null && login != null && senha != null && id != null) {
            if(usuarios.containsKey(login)){
                return false;
            }
            Admin admin = (Admin) usuarioAutenticado;
            Professor novoProfessor = new Professor(nome, id, login, senha, admin.getUnidade());
            usuarios.put(login, novoProfessor);
            admin.getUnidade().getProfessores().put(id, novoProfessor);
            notifica();
            return true;
        }
        return false;
    }
    // Autentica um usuário com login e senha
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
    // Desloga o usuário atual
    public void deslogarUsuario() {
        usuarioAutenticado = null;
        notifica();
    }
    // Retorna o login do usuário autenticado
    public String getUsuarioAutenticado() {
        if (usuarioAutenticado != null){
            return usuarioAutenticado.getLogin();
        } else {
            return "";
        }
    }
    // Retorna o total de usuários cadastrados
    public int getTotalUsuarios() {
        return usuarios.size();
    }
    // Adiciona um observador
    public void attachObserver(Observer observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }
    // Remove um observador
    public void detachObserver(Observer observer) {
        if (observer != null) {
            observers.remove(observer);
        }
    }
    // Retorna uma turma específica de um campus
    private Turma getTurma(String codigoTurma, String nomeUnidade) {
        if(listaDeCampus.containsKey(nomeUnidade)){
            Campus campus = listaDeCampus.get(nomeUnidade);
            if(campus.getTurmas().containsKey(codigoTurma)){
                return campus.getTurmas().get(codigoTurma);
            }
        }
        return null;
    }
    // Verifica se um plano de ensino existe para uma turma
    public boolean existePED(String codigoTurma, String nomeUnidade){
        if(getTurma(codigoTurma,nomeUnidade) != null){
            Turma turma = getTurma(codigoTurma,nomeUnidade);
            if(turma.getPlano() != null){
                return true;
            }
        }
        return false;
    }

    public void sistemaIniciado(){
        notifica();
    }
    // Retorna o tipo do usuário autenticado
    public String getTipoUsuario() {
        if (usuarioAutenticado != null) {
            String tipoUsuario = "";
            if(usuarioAutenticado instanceof Admin){
                tipoUsuario = "Admin";
            } else if (usuarioAutenticado instanceof Professor){
                tipoUsuario = "Professor";
            }
            return tipoUsuario;
        }
        return "";
    }
    // Retorna o nome do campus do usuário autenticado
    public String getCampus(){
        if(usuarioAutenticado != null && usuarioAutenticado instanceof Admin){
            Admin adminLogado = (Admin) usuarioAutenticado;
            String nomeUnidade = adminLogado.getUnidade().getNomeUnidade();
            return nomeUnidade;
        } else if(usuarioAutenticado != null && usuarioAutenticado instanceof Professor){
            Professor prof = (Professor) usuarioAutenticado;
            String nomeUnidade = prof.getCampus().getNomeUnidade();
            return nomeUnidade;
        }
        return "";
    }
     // Verifica se uma turma existe no campus do admin
    public boolean existeTurmaAdmin(String codigoTurma){
        Admin admin = (Admin) usuarioAutenticado;
        if(admin.getUnidade().getTurmas().containsKey(codigoTurma)){
            return true;
        }
        return false;
    }
    // Verifica se uma turma existe no professor autenticado
    public boolean existeTurmaProf(String codigoTurma){
        Professor prof = (Professor) usuarioAutenticado;
        if(prof.getTurmas().containsKey(codigoTurma)){
            return true;
        }
        return false;
    }
    // Verifica se existe um professor com o ID fornecido
    public boolean existeProfessor(String idProfessor){
        Admin admin = (Admin) usuarioAutenticado;
        if (admin.getUnidade().getProfessores().containsKey(idProfessor)) {
            return true;
        }
        return false;
    }

//cadastra parte de strings do plano de ensino
    public boolean cadastrarEmenta(String justificativa, String ementa, String[] objetivos,
                                   String metodologia, String[] atividades,
                                   String sistemaAvaliacao, String nomeProfessor) {
        if (justificativa == null || justificativa.trim().isEmpty() ||
                ementa == null || ementa.trim().isEmpty() ||
                objetivos == null || objetivos.length == 0 ||
                metodologia == null || metodologia.trim().isEmpty() ||
                atividades == null || atividades.length == 0 ||
                sistemaAvaliacao == null || sistemaAvaliacao.trim().isEmpty() ||
                nomeProfessor == null || nomeProfessor.trim().isEmpty()) {
            return false;
        }
        Professor professor = (Professor) usuarioAutenticado;
        professor.getTurmas()

        return true;
    }
    //cadastra turma 
    public boolean cadastrarTurma(String idProfessor, String codigoTurma, String codigoDisciplina, String nomeUnidade, String nomeDisciplina,
                                  String caraterDisciplina, String regimeOferta, String estruturaCurricular,
                                  int cargaHoraria) {
        if (idProfessor == null || idProfessor.trim().isEmpty() || codigoTurma == null || codigoTurma.trim().isEmpty() ||
                codigoDisciplina == null || codigoDisciplina.trim().isEmpty() ||
                nomeUnidade == null || nomeUnidade.trim().isEmpty() || nomeDisciplina == null || nomeDisciplina.trim().isEmpty() || cargaHoraria <= 0){
            return false;
        }

        if(!existeProfessor(idProfessor)){
            return false;
        }

        if(existeTurmaAdmin(codigoTurma)){
            return false;
        }

        Admin admin = (Admin) usuarioAutenticado;
        Disciplina disciplina = new Disciplina(codigoDisciplina, nomeUnidade, nomeDisciplina, caraterDisciplina,
                regimeOferta, estruturaCurricular, cargaHoraria);
        Turma novaTurma = new Turma(codigoTurma, disciplina, admin.getUnidade().getProfessores().get(idProfessor).getNome());
        admin.getUnidade().getProfessores().get(idProfessor).getTurmas().put(codigoTurma, novaTurma);
        admin.getUnidade().getTurmas().put(codigoTurma, novaTurma);
        return true;
    }
//retorna plano de ensino
    public String getPlanoDeEnsino(String codigoTurma, String nomeUnidade){
        Turma turma = getTurma(codigoTurma, nomeUnidade);
        String s = String.format("PLANO DE ENSINO");
        s+= String.format("1.IDENTIFICAÇÃO");
        s+= String.format("1.1 UNIDADE: " + nomeUnidade);
        s+= String.format("1.2 ESTRUTURA CURRICULAR: " + turma.getDisciplina().getEstruturaCurricular());
        s+= String.format("1.3 NOME DA DISCIPLINA: " + turma.getDisciplina().getNomeDisciplina());
        s+= String.format("1.4 CÓDIGO DA DISCIPLINA: " + turma.getDisciplina().getCodigo());
        s+= String.format("1.5 CARÁTER DA DISCIPLINA: " + turma.getDisciplina().getCaraterDisciplina());
        s+= String.format("1.6 REGIME DE OFERTA DA DISCIPLINA: " + turma.getDisciplina().getRegimeOferta());
        s+= String.format("1.7 CARGA HORÁRIA: %d", turma.getDisciplina().getCargaHoraria());
        s+= String.format("1.8 PROFESSOR: " + turma.getPlano().getNomeProfessor());
        s += String.format("/n/n");
        s += String.format("2. JUSTIFICATIVA");
        s += String.format(turma.getPlano().getJustificativa());
        s += String.format("/n/n");
        s += String.format("3. EMENTA");
        s += String.format(turma.getPlano().getEmenta());
        s += String.format("/n/n");
        s += String.format("4. OBJETIVOS");
        s += String.format(turma.getPlano().getObjetivos());
        s += String.format("/n/n");
        s += String.format("5. CALENDÁRIO DE ATIVIDADES");
        s += String.format("/n/n");
        s += String.format("6. METODOLOGIA DE ENSINO");
        s += String.format(turma.getPlano().getMetodologia());
        s += String.format("/n/n");
        s += String.format("7. ATIVIDADES DISCENTES");
        s += String.format(turma.getPlano().getAtividades());
        s += String.format("/n/n");
        s += String.format("8. SISTEMA DE AVALIAÇÃO");
        s += String.format(turma.getPlano().getSistemaAvaliacao());
        s += String.format("/n/n");
        s += String.format("9. BIBLIOGRAFIA");
        s += String.format(turma.getPlano().getBibliografia());
        s += String.format("/n/n");

        return s;
    }
//verifica se a turma existe 
    public boolean existeTurmas() {
        if(usuarioAutenticado != null){
            if(usuarioAutenticado instanceof Professor){
                Professor prof = (Professor) usuarioAutenticado;
                if (prof.getTurmas() != null){
                    return true;
                }
            }
        }
        return false;
    }
//retona turmas tanto de professor quanto de admin
    public String getTurmas() {
        if(usuarioAutenticado != null){
            if(usuarioAutenticado instanceof Professor){
                Professor prof = (Professor) usuarioAutenticado;
                if (prof.getTurmas() != null){
                    String resultado = "";
                    resultado += "Lista de Turmas:\n\n";
                    for (HashMap.Entry<String, Turma> entrada : prof.getTurmas().entrySet()) {
                        Turma turma = entrada.getValue();
                        resultado += turma.toString() + "\n";
                    }
                    return resultado;
                }
            } else if(usuarioAutenticado instanceof Admin){
                Admin admin = (Admin) usuarioAutenticado;
                Campus campus = listaDeCampus.get(admin.getUnidade().getNomeUnidade());
                if (campus.getTurmas() != null){
                    String resultado = "";
                    resultado += "Lista de Turmas:\n\n";
                    for (HashMap.Entry<String, Turma> entrada : campus.getTurmas().entrySet()) {
                        Turma turma = entrada.getValue();
                        resultado += turma.toString() + "\n";
                    }
                    return resultado;
                }
            }
        }
        return "";
    }
//retorna a turma escolhida do professor
    public String getTurmaEscolhida(String codigoTurma){
        if(usuarioAutenticado != null){
            if(usuarioAutenticado instanceof Professor){
                Professor prof = (Professor) usuarioAutenticado;
                if (prof.getTurmas() != null){
                    String resultado = "";
                    resultado += prof.getTurmas().get(codigoTurma).toString();
                }
            }
        }
        return "";
    }
//exclui turma
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
//retorna os professores que o admin cadastrou
    public String getProfessores() {
        if(usuarioAutenticado instanceof Admin){
            Admin admin = (Admin) usuarioAutenticado;
            Campus campus = listaDeCampus.get(admin.getUnidade().getNomeUnidade());
            if (campus.getProfessores() != null){
                String resultado = "";
                resultado += "Lista de Professores:\n\n";
                for (HashMap.Entry<String,Professor> entrada : campus.getProfessores().entrySet()) {
                    Professor professor = entrada.getValue();
                    resultado += professor.toString() + "\n";
                }
                return resultado;
            }
        }
        return "";
    }

}
