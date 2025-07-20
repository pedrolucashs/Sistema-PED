package model;

public class MaterialEstudo {
    private String idMaterial;
    private String titulo;
    private String autor;
    private String ano;
    private String isbn;

    public MaterialEstudo(String idMaterial, String titulo, String autor, String ano, String isbn) {
        setIdMaterial(idMaterial);
        setTitulo(titulo);
        setAutor(autor);
        setAno(ano);
        setIsbn(isbn);
    }

    public String getIdMaterial() {
        return idMaterial;
    }
    public void setIdMaterial(String idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getTitulo() {return titulo;}
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {return autor;}
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAno() {
        return ano;
    }
    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getIsbn() {return isbn;}
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String toString() {
        if(idMaterial == null) {
            return "";
        }
        String s = String.format("Id do Material: %s\nTítulo: %s | Autor: %s\nAno: %s | ISBN: %s", getIdMaterial(), getTitulo(), getAutor(), getAno(), getIsbn());
        return s;
    }
    public String toString2() {
        if(idMaterial == null) {
            return "";
        }
        String s = String.format("Título: %s | Autor: %s\nAno: %s | ISBN: %s", getIdMaterial(), getTitulo(), getAutor(), getAno(), getIsbn());
        return s;
    }
}
