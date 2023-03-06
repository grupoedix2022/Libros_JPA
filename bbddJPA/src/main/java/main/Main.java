package main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.entidad.*;

public class Main {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Cine");
		
		EntityManager em = null;
		
		Cine c1 = new Cine();
		c1.setNombre("Cinesa");		
		Direccion d = new Direccion("Calle", "Toledo", "Madrid");
		c1.setDireccion(d);
		
		Director d1 = new Director();
		d1.setNombre("Ron");
		d1.setApellido("Howard");
		
		Actor a1 = new Actor();
		a1.setNombre("Val");
		a1.setApellido("Kilmer");
		
		Actor a2 = new Actor();
		a2.setNombre("Warwick");
		a2.setApellido("Davis");
		
		List<Actor> r1 = new ArrayList<Actor>();
		r1.add(a2);
		r1.add(a1);
		
		Pelicula p1 = new Pelicula();
		p1.setTitulo("Willow");
		p1.setDirector(d1);
		p1.setReparto(r1);
		
		List<Cine> cl1 = new ArrayList<Cine>();
		cl1.add(c1);
		p1.setCineList(cl1);
						
		List<Pelicula> pl1 = new ArrayList<Pelicula>();
		pl1.add(p1);
		c1.setCartelera(pl1);
		
		d1.setPeliculas(pl1);
		
		Distribuidora db1 = new Distribuidora();
		db1.setNombre("Warner");
		p1.setDistribuidora(db1);
		db1.setPeliculas(pl1);
		
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(a1);
		em.persist(a2);
		
		em.persist(d1);
		
		em.persist(c1);
		
		em.persist(db1);
					
		
		em.getTransaction().commit();
						
									
		
		em.close();		
		
		emf.close();	
		
	}

}
