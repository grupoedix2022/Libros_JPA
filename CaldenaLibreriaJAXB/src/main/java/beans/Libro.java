package beans;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import beans.Libreria;

@XmlRootElement(name="libro")
@XmlType(propOrder = {
		"id",
	    "titulo",
	    "precio",
	    "editorial",
	    "autor"
	})
public class Libro {

	
	private int id;
	private String titulo;
	private float precio;
	
	
	private Editorial editorial;
	
	
	private Autor autor;
	
	
	public Libro(Integer id, String titulo, float precio, Editorial editorial, Autor autor) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.precio = precio;
		this.editorial = editorial;
		this.autor = autor;
	}

	public Libro() {
		super();
	}
	@XmlAttribute(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@XmlElement
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	@XmlElement
	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	@XmlElement
	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
		autor.addLibro(this);
	}
	

	@XmlElement
	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	
	public String toString() {
        return this.getClass().getSimpleName();
    }
	
}
