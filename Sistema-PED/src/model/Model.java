package model;

import java.util.HashMap;
import java.util.ArrayList;
import view.*;
import model.exceptions.*;

public class Model {
    private HashMap<String,Usuario> usuarios = new HashMap<String, Usuario>();
    private HashMap<String,Campus> listaDeCampus = new HashMap<String, Campus>();
    private Usuario usuarioAutenticado;
    private ArrayList<Observer> observers = new ArrayList<Observer>();

    private static Model instanciaUnica;
    private static Admin adminPadrao;
    private static Campus campusPadrao;

    private Model(){
        super();
    }

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

    private Turma getTurma(String codigoTurma, String nomeUnidade) {
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

    public void sistemaIniciado(){
        notifica();
    }

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

    public boolean existeTurmaAdmin(String codigoTurma){
        Admin admin = (Admin) usuarioAutenticado;
        if(admin.getUnidade().getTurmas().containsKey(codigoTurma)){
            return true;
        }
        return false;
    }

    public boolean existeTurmaProf(String codigoTurma){
        Professor prof = (Professor) usuarioAutenticado;
        if(prof.getTurmas().containsKey(codigoTurma)){
            return true;
        }
        return false;
    }

    public boolean existeProfessor(String idProfessor){
        Admin admin = (Admin) usuarioAutenticado;
        if (admin.getUnidade().getProfessores().containsKey(idProfessor)) {
            return true;
        }
        return false;
    }

    public boolean cadastrarEmenta(){
        
    }

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
        listaDeCampus.get(admin.getUnidade().getNomeUnidade()).getTurmas().put(codigoTurma, novaTurma);

        return true;
    }

    public String getPlanoDeEnsino(String codigoTurma, String nomeUnidade){
        Turma turma = getTurma(codigoTurma, nomeUnidade);
        String s = String.format("PLANO DE ENSINO\n");
        s+=String.format("ANO/SEMESTRE: %s\n\n", turma.getPlano().getAnoSemestre());
        s+= String.format("1.IDENTIFICAÇÃO\n");
        s+= String.format("1.1 UNIDADE: " + nomeUnidade + "\n");
        s+= String.format("1.2 ESTRUTURA CURRICULAR: " + turma.getDisciplina().getEstruturaCurricular() + "\n");
        s+= String.format("1.3 NOME DA DISCIPLINA: " + turma.getDisciplina().getNomeDisciplina() + "\n");
        s+= String.format("1.4 CÓDIGO DA DISCIPLINA: " + turma.getDisciplina().getCodigo() + "\n");
        s+= String.format("1.5 CARÁTER DA DISCIPLINA: " + turma.getDisciplina().getCaraterDisciplina() + "\n");
        s+= String.format("1.6 REGIME DE OFERTA DA DISCIPLINA: " + turma.getDisciplina().getRegimeOferta() + "\n");
        s+= String.format("1.7 CARGA HORÁRIA: %d", turma.getDisciplina().getCargaHoraria());
        s+= String.format("\n1.8 PROFESSOR: " + turma.getPlano().getNomeProfessor());
        s += String.format("\n\n");
        s += String.format("2. JUSTIFICATIVA\n");
        s += String.format(turma.getPlano().getJustificativa());
        s += String.format("\n\n");
        s += String.format("3. EMENTA\n");
        s += String.format(turma.getPlano().getEmenta());
        s += String.format("\n\n");
        s += String.format("4. OBJETIVOS\n");
        s += String.format(turma.getPlano().getObjetivos());
        s += String.format("\n\n");
        s += String.format("5. CALENDÁRIO DE ATIVIDADES\n");
        s += String.format("\n\n");
        s += String.format("6. METODOLOGIA DE ENSINO\n");
        s += String.format(turma.getPlano().getMetodologia());
        s += String.format("\n\n");
        s += String.format("7. ATIVIDADES DISCENTES\n");
        s += String.format(turma.getPlano().getAtividades());
        s += String.format("\n\n");
        s += String.format("8. SISTEMA DE AVALIAÇÃO\n");
        s += String.format(turma.getPlano().getSistemaAvaliacao());
        s += String.format("\n\n");
        s += String.format("9. BIBLIOGRAFIA\n");
        s += String.format(turma.getPlano().getBibliografia());
        s += String.format("\n");

        return s;
    }

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
                        resultado += "\n";
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
                        resultado += "\n";
                    }
                    return resultado;
                }
            }
        }
        return "";
    }

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

    public boolean excluirProfessor(String idProfessor) {
        if (!(usuarioAutenticado instanceof Admin)) {
            throw new PermissaoNegadaException("Apenas administradores podem excluir professores.");
        }

        Admin adminLogado = (Admin) usuarioAutenticado;
        Campus campusDoAdmin = adminLogado.getUnidade();

        if (!campusDoAdmin.getProfessores().containsKey(idProfessor)) {
            throw new ProfessorNaoEncontradoException(String.format("Professor com ID '%s' não encontrado no campus '%s'.", idProfessor, campusDoAdmin.getNomeUnidade()));
        }

        Professor professorParaExcluir = campusDoAdmin.getProfessores().get(idProfessor);

        campusDoAdmin.getProfessores().remove(idProfessor);

        String loginProfessor = professorParaExcluir.getLogin();
        if (usuarios.containsKey(loginProfessor)) {
            usuarios.remove(loginProfessor);
        } else {
        }
        notifica();
        return true;
    }

    public String getCalendario(String codigoTurma){
        if(usuarioAutenticado instanceof Professor){
            Professor prof = (Professor) usuarioAutenticado;
            if (prof.getTurmas() != null){
                if(prof.getTurmas().get(codigoTurma) != null){
                    String resultado = "";
                    resultado += "Calendário de Atividades:\n\n";
                    PlanoDeEnsino plano = prof.getTurmas().get(codigoTurma).getPlano();
                    for (HashMap.Entry<String, AtividadeCalendario> entrada : plano.getCalendarioAtividades().entrySet()) {
                        AtividadeCalendario atividade = entrada.getValue();
                        resultado += atividade.toString() + "\n";
                    }
                    return resultado;
                }
            }
        }
        return "";
    }

    public boolean existeAtividade(String codigoTurma, String idAtividade){
        Professor prof = (Professor) usuarioAutenticado;
        if (prof.getTurmas() != null){
            if(prof.getTurmas().get(codigoTurma) != null){
                if(prof.getTurmas().get(codigoTurma).getPlano().getCalendarioAtividades().containsKey(idAtividade)){
                    return true;
                }
            }
        }
        return false;
    }

    public void addAtividade(String codigoTurma, String idAtividade, String data, String descricao, int cargaHoraria){
        Professor prof = (Professor) usuarioAutenticado;
        if (prof.getTurmas() != null){
            if(prof.getTurmas().get(codigoTurma) != null){
                PlanoDeEnsino plano = prof.getTurmas().get(codigoTurma).getPlano();
                plano.addAtividade(idAtividade, data, descricao, cargaHoraria);
            }
        }
    }
    public void excluirAtividade(String codigoTurma, String idAtividade){
        Professor prof = (Professor) usuarioAutenticado;
        if (prof.getTurmas() != null){
            if(prof.getTurmas().get(codigoTurma) != null){
                PlanoDeEnsino plano = prof.getTurmas().get(codigoTurma).getPlano();
                plano.excluirAtividade(idAtividade);
            }
        }
    }

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
                    resultado += "\n";
                }
                return resultado;
            }
        }
        return "";
    }
}
