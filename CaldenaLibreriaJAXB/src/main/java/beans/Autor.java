package beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import beans.Libro;



@XmlRootElement(name="persona")
//Podemos hacer que las etiquetas salgan en un determinado orden
//etiqueta opcional
@XmlType(propOrder = {
		"id",
	    "nombre",
	    "apellido",
	    "nacimiento",
	    "bibliografia"
	})
public class Autor{
	
	private int id;	
	private String nombre;
	private String apellido;		
	
	private Date nacimiento;
	
	
	private List<Libro> bibliografia = new ArrayList<Libro>();

	public Autor(int id, String nombre, String apellido, Date nacimiento, List<Libro> bibliografia) {		
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacimiento = nacimiento;
		this.bibliografia = bibliografia;
	}

	public Autor() {
		super();		
	}

	@XmlElement
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@XmlElement
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	@XmlAttribute(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	
	@XmlElement
	public Date getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}
	
	@XmlElement(name = "libro")
	@XmlElementWrapper(name = "libros")
	public List<Libro> getBibliografia(){
		return bibliografia;
	}

	public void setBibliografia(List<Libro> bibliografia) {
		this.bibliografia = bibliografia;
	}
	
	public void addLibro(Libro libro) {
		this.bibliografia.add(libro);
	}

	public String toString() {
        return this.getClass().getSimpleName();
    }
	
	
}
