package modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="cines")
public class Cine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	
	@Embedded
	private Direccion direccion;
	
	@ManyToMany(mappedBy="cineList", cascade=CascadeType.PERSIST)
	private List<Pelicula> cartelera;
	
	
	public Cine() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Direccion getDireccion() {
		return direccion;
	}


	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}


	public List<Pelicula> getCartelera() {
		return cartelera;
	}


	public void setCartelera(List<Pelicula> cartelera) {
		this.cartelera = cartelera;
	}


	
	

}
