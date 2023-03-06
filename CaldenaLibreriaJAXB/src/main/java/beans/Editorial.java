package beans;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import beans.Libro;


@XmlRootElement(name="libro")
@XmlType(propOrder = {
		"id",
	    "nombre",
	    "direccion",
	    "libros"
	})

public class Editorial {
	

	private int id;
	private String nombre;
	
	private Direccion direccion;
	
	
	private List<Libro> libros;
		

	public Editorial(int id, String nombre, Direccion direccion, List<Libro> libros) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.libros = libros;
	}

	public Editorial() {
		super();
	}
	@XmlAttribute(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@XmlAttribute
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@XmlElement(name = "direccion")
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

	@Override
	public String toString() {
        return this.getClass().getSimpleName();
    }

	

}
