package modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="libros")
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String titulo;
	private float precio;
	
	@ManyToOne
	@JoinColumn(name="fk_id_editorial", referencedColumnName = "id")
	private Editorial editorial;
	
	@ManyToOne
	@JoinColumn(name="fk_id_autor", referencedColumnName="id")
	private Autor autor;
	
	@ManyToMany(mappedBy="libros", cascade=CascadeType.PERSIST)
	private List<Libreria> lib;
	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	
	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	
	

	public List<Libreria> getLib() {
		return lib;
	}

	public void setLib(List<Libreria> lib) {
		this.lib = lib;
	}

	@Override
	public String toString() {
        return this.getClass().getSimpleName();
    }
	
	
}
