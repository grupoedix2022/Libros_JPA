package modelo.entidad;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="autores")
public class Autor{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	private String nombre;
	private String apellido;
	
	
	@Temporal(TemporalType.DATE)
	private Date nacimiento;
	
	@OneToMany(mappedBy="autor", cascade=CascadeType.ALL)
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

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	

	public Date getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}

	public List<Libro> getBibliografia() {
		return bibliografia;
	}

	public void setBibliografia(List<Libro> bibliografia) {
		this.bibliografia = bibliografia;
	}
	
	public void addLibro(Libro libro) {
		this.bibliografia.add(libro);
	}

	@Override
	public String toString() {
        return this.getClass().getSimpleName();
    }

	
	
	
}
