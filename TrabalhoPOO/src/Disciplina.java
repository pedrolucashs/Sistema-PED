public class Identificacao{
    private String unidade;
    private String[] cursos;
    private String estruturaC;
    private String nome;
    private int codigo;
    private int cargaHoraria;
    private String carater;
    private String regimeOferta;
    private String[] preRequisitos;
    private String[] coRequisitos;
    private String[] equivalencias;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getCarater() {
        return carater;
    }

    public void setCarater(String carater) {
        this.carater = carater;
    }

    public String getRegimeOferta() {
        return regimeOferta;
    }

    public void setRegimeOferta(String regimeOferta) {
        this.regimeOferta = regimeOferta;
    }
}
