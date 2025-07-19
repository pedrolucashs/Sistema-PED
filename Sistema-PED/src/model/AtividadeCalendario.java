package model;

public class AtividadeCalendario {
    private String idAtividade;
    private String data;
    private String descricaoConteudo;
    private int cargaHoraria;

    public AtividadeCalendario(String idAtividade, String data, String descricao, int cargaHoraria) {
        setIdAtividade(idAtividade);
        setData(data);
        setDescricaoConteudo(descricao);
        setCargaHoraria(cargaHoraria);
    }

    public String getIdAtividade() {
        return idAtividade;
    }
    public void setIdAtividade(String idAtividade) {
        this.idAtividade = idAtividade;
    }

    public String getData() {return data;}
    public void setData(String data) {
        this.data = data;
    }

    public String getDescricaoConteudo() {return descricaoConteudo;}
    public void setDescricaoConteudo(String descricaoConteudo) {
        this.descricaoConteudo = descricaoConteudo;
    }

    public int getCargaHoraria() {return cargaHoraria;}
    public void setCargaHoraria(int cargaHoraria) {
        if(cargaHoraria > 0){
            this.cargaHoraria = cargaHoraria;
        }
    }

    public String toString() {
        if(data == null && descricaoConteudo == null && cargaHoraria == 0){
            return "";
        }
        String s = String.format("Id da Atividade: %s | Data: %s | Descrição do Conteúdo: %s | Carga Horária: %d", getIdAtividade(), getData(), getDescricaoConteudo(), getCargaHoraria());
        return s;
    }
}
