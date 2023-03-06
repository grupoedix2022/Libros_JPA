package modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="peliculas")
public class Pelicula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String titulo;
	
	@ManyToOne
	@JoinColumn(name="fk_id_director", referencedColumnName = "id")
	private Director director;
	
	@ManyToMany(cascade=CascadeType.PERSIST)	
	@JoinTable(name="peliculas_actores",
			   joinColumns= { @JoinColumn(name="fk_id_pelicula", referencedColumnName="id") }, 
			   inverseJoinColumns= { @JoinColumn(name="fk_id_actor", referencedColumnName="id")})	
	private List<Actor> reparto;
	
	@ManyToOne
	@JoinColumn(name="fk_id_distribuidora", referencedColumnName = "id")
	private Distribuidora distribuidora;
	
	@ManyToMany(cascade=CascadeType.PERSIST)	
	@JoinTable(name="peliculas_cines",
			   joinColumns= { @JoinColumn(name="fk_id_pelicula", referencedColumnName="id") }, 
			   inverseJoinColumns= { @JoinColumn(name="fk_id_cine", referencedColumnName="id")})
	private List<Cine> cineList;
	
	public Pelicula() {
		super();
		// TODO Auto-generated constructor stub
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


	public Director getDirector() {
		return director;
	}


	public void setDirector(Director director) {
		this.director = director;
	}


	public List<Actor> getReparto() {
		return reparto;
	}


	public void setReparto(List<Actor> reparto) {
		this.reparto = reparto;
	}
	
	public void addActor(Actor actor) {
		this.reparto.add(actor);
	}


	public Distribuidora getDistribuidora() {
		return distribuidora;
	}


	public void setDistribuidora(Distribuidora distribuidora) {
		this.distribuidora = distribuidora;
	}


	public List<Cine> getCineList() {
		return cineList;
	}


	public void setCineList(List<Cine> cineList) {
		this.cineList = cineList;
	}
	
	
	
}
