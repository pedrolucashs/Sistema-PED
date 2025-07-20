// Classe que representa uma atividade do calendário escolar
class AtividadeCalendario {
    private String data;
    private String descricaoConteudo;
    private int cargaHoraria;

    public String getData() { return data; }
    public void setData(String data) { this.data = data; }

    public String getDescricaoConteudo() { return descricaoConteudo; }
    public void setDescricaoConteudo(String descricaoConteudo) { this.descricaoConteudo = descricaoConteudo; }

    public int getCargaHoraria() { return cargaHoraria; }
    public void setCargaHoraria(int cargaHoraria) {
        if (cargaHoraria > 0) {
            this.cargaHoraria = cargaHoraria; // Define a carga horária se for positiva
        }
    }
}
