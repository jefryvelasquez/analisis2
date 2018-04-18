/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.edatos.laboratorio1.modelo;

/**
 *
 * @author Telecentro
 */
public class Material {
    
    private int ISBN;
    private String titulo;
    private String autor;
    private int anio;
    private boolean disponible;
    private String idioma;
    private String pais;
    private String categoria;
    private String editorial;
    private int diasPrestamo;

    public Material() {
    }

    public Material(int ISBN, String titulo, String autor, int anio, boolean disponible, String idioma, String pais, String categoria, String editorial, int diasPrestamo) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.disponible = disponible;
        this.idioma = idioma;
        this.pais = pais;
        this.categoria = categoria;
        this.editorial = editorial;
        this.diasPrestamo = diasPrestamo;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getDiasPrestamo() {
        return diasPrestamo;
    }

    public void setDiasPrestamo(int diasPrestamo) {
        this.diasPrestamo = diasPrestamo;
    }

    @Override
    public String toString() {
        return "Material{" + "ISBN=" + ISBN + ", titulo=" + titulo + ", autor=" + autor + ", anio=" + anio + ", disponible=" + disponible + ", idioma=" + idioma + ", pais=" + pais + ", categoria=" + categoria + ", editorial=" + editorial + ", diasPrestamo=" + diasPrestamo + '}';
    }

    
}
