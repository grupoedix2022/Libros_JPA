package modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="directores")
public class Director extends Persona {
	
	@OneToMany(mappedBy="director", cascade=CascadeType.ALL)
	List<Pelicula> peliculas;

	public Director(String nombre, String apellido, List<Pelicula> peliculas) {
		super(nombre, apellido);
		this.peliculas = peliculas;
	}
		

	public Director() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Director(String nombre, String apellido) {
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
