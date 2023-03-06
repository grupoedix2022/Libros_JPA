package modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="actores")
public class Actor extends Persona {
	
	@ManyToMany(mappedBy = "reparto", cascade=CascadeType.PERSIST)
	private List<Pelicula> peliculas;

	public Actor(String nombre, String apellido, List<Pelicula> peliculas) {
		super(nombre, apellido);
		this.peliculas = peliculas;
	}
	
	

	public Actor() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Actor(String nombre, String apellido) {
		super(nombre, apellido);
		// TODO Auto-generated constructor stub
	}



	public List<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}
		
}
