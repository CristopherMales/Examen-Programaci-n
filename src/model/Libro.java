package model;

public class Libro {

	private String ISSN; 
	private String autor;
	private String titulo;
	private String editorial;
	private String a�o;
	

	public Libro(){
		
	}
	public String getISSN() {
		return ISSN;
	}
	public void setISSN(String iSSN) {
		ISSN = iSSN;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public String getA�o() {
		return a�o;
	}
	public void setA�o(String a�o) {
		this.a�o = a�o;
	}
	
	
	@Override
	public String toString() {
		return "Libro [ISSN=" + ISSN + ", autor=" + autor + ", titulo=" + titulo + ", editorial=" + editorial + ", a�o="
				+ a�o + "]";
	}
}
