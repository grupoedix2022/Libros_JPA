package beans;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name="libreria")
@XmlType(propOrder = {
		"id",
	    "nombre",
	    "dueño",
	    "direccion",
	    "libros"
	})
public class Libreria {
	
	
	private int id;
	
	private String nombre;
	private String dueño;
	
	private Direccion direccion;
		
	private List<Libro> libros;
	
	public Libreria(int id, String nombre, String dueño, Direccion direccion, List<Libro> libros) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.dueño = dueño;
		this.direccion = direccion;
		this.libros = libros;
	}

	public Libreria() {
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
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@XmlElement
	public String getDueño() {
		return dueño;
	}

	public void setDueño(String dueño) {
		this.dueño = dueño;
	}
	@XmlElement
	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	@XmlElement(name = "libro")
	@XmlElementWrapper(name = "libros")
	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}


}