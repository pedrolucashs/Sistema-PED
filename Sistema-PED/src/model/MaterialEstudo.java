package model;

public class MaterialEstudo {
    private String titulo;
    private String autor;
    private String edicao;
    private String editora;
    private int ano;
    private String isbn;

    public String getTitulo() {return titulo;}

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {return autor;}

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEdicao() {return edicao;}

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getEditora() {return editora;}

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getAno() {return ano;}

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getIsbn() {return isbn;}

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
