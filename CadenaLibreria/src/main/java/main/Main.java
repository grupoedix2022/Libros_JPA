package main;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.entidad.Autor;
import modelo.entidad.Direccion;
import modelo.entidad.Editorial;
import modelo.entidad.Libreria;
import modelo.entidad.Libro;

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("L");
			
		EntityManager em = null;
				
		Autor a1 = new Autor();
		a1.setNombre("Stephen");
		a1.setApellido("King");
		Date date = new Date(1947-1900, 9, 21);
		a1.setNacimiento(date);
		
		Autor a2 = new Autor();
		a2.setNombre("Arturo");
		a2.setApellido("Pérez-Reverte");
		date = new Date(1951-1900, 11, 25);
		a2.setNacimiento(date);
		
		Autor a3 = new Autor();
		a3.setNombre("Fiódor");
		a3.setApellido("Dostoyevski");
		date = new Date(1821-1900, 11, 11);
		a3.setNacimiento(date);
						
		Editorial e1 = new Editorial();
		e1.setNombre("Planeta");
		Direccion d = new Direccion("Calle", "Petróleo", "Alcorcón");
		e1.setDireccion(d);
		
		Editorial e2 = new Editorial();
		e2.setNombre("Alfaguara");
		d = new Direccion("Travesía", "de Gracia", "Barcelona");
		e2.setDireccion(d);
		
		List<Libro> listaA2 = new ArrayList();
		Libro l1 = new Libro();
		l1.setTitulo("El Italiano");
		l1.setPrecio(20.99f);		
		l1.setEditorial(e2);
		l1.setAutor(a2);
		
		
		Libro l2 = new Libro();
		l2.setTitulo("Sidi");
		l2.setPrecio(20.99f);
		l2.setEditorial(e2);
		l2.setAutor(a2);				
		
		Libro l3 = new Libro();
		l3.setTitulo("Falcó");
		l3.setPrecio(20.99f);
		l3.setEditorial(e2);
		l3.setAutor(a2);		
		
		
		listaA2.add(l3);
		listaA2.add(l2);
		listaA2.add(l1);
		a2.setBibliografia(listaA2);
		
		List<Libro> listaA1 = new ArrayList();
		Libro l4 = new Libro();
		l4.setTitulo("Rabia");
		l4.setPrecio(10.99f);
		l4.setAutor(a1);
		l4.setEditorial(e1);
				
		
		Libro l5 = new Libro();
		l5.setTitulo("It");
		l5.setPrecio(7.99f);
		l5.setAutor(a1);
		l5.setEditorial(e1);
		
		
		Libro l6 = new Libro();
		l6.setTitulo("Carrie");
		l6.setPrecio(25.99f);
		l6.setAutor(a1);
		l6.setEditorial(e1);
		
		listaA1.add(l6);
		listaA1.add(l5);
		listaA1.add(l4);
		a1.setBibliografia(listaA1);
				
		List<Libro> listaA3 = new ArrayList();
		Libro l7 = new Libro();
		l7.setTitulo("Los Hermanos Karamazov");
		l7.setPrecio(12.99f);
		l7.setAutor(a3);
		l7.setEditorial(e1);
		
		
		Libro l8 = new Libro();
		l8.setTitulo("Crimen y Castigo");
		l8.setPrecio(25.99f);
		l8.setAutor(a3);
		l8.setEditorial(e1);
		
		listaA3.add(l7);
		listaA3.add(l8);
		a3.setBibliografia(listaA3);
		
		Libreria b1 = new Libreria();
		b1.setDueño("Pepe Librero");
		b1.setNombre("Librería de Pepe");
		d = new Direccion("Calle", "Barquillo", "Madrid");
		b1.setDireccion(d);
		
		Libreria b2 = new Libreria();
		b2.setDueño("Pichi Librero");
		b2.setNombre("Libros Chulos");
		d = new Direccion("Calle", "Toledo", "Madrid");
		b2.setDireccion(d);
		
				
		List<Libro> lib1 = new ArrayList();
		lib1.add(l1);
		lib1.add(l2);
		lib1.add(l8);
		lib1.add(l7);
		lib1.add(l6);
		
		List<Libro> lib2 = new ArrayList();
		lib2.add(l2);
		lib2.add(l3);
		lib2.add(l4);
		lib2.add(l5);
		
		b1.setLibros(lib1);
		b2.setLibros(lib2);
				
		List<Libreria> listLibA = new ArrayList();
		listLibA.add(b1);
		l1.setLib(listLibA);
		l6.setLib(listLibA);
		l7.setLib(listLibA);
		l8.setLib(listLibA);
		
		List<Libreria> listLibAB = new ArrayList();
		listLibAB.add(b2);
		listLibAB.add(b1);
		l2.setLib(listLibAB);
		
		List<Libreria> listLibB = new ArrayList();
		listLibB.add(b2);
		l3.setLib(listLibB);
		l4.setLib(listLibB);
		l5.setLib(listLibB);
		
		
		
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(e1);
		em.persist(e2);
		
		em.persist(a1);
		em.persist(a2);
		em.persist(a3);	
		
		
		em.persist(b1);
		em.persist(b2);
					
		
		em.getTransaction().commit();
		
		
				
		queries(em);
									
		
		em.close();		
		
		emf.close();		
		
	}
	
	public static void  queries(EntityManager em) {
		
		/*Mostrar todos los libros dados de alta, con su editorial y su autor
		Mostrar todos los autores dados de alta, con sus libros asociados
		Mostrar todas las librerías, con solamente sus libros asociados
		Mostrar todos los libros dados de alta, y en la librería en la que están.
		*/
	
		Query query = em.createQuery("SELECT l FROM Libro l");
		List<Libro> listL = query.getResultList();
		System.out.println("==== listado de libros ====");
		for(Libro l : listL) {
			System.out.println(l.getTitulo());
			System.out.println(l.getAutor().getNombre() + " " + l.getAutor().getApellido());
			System.out.println(l.getEditorial().getNombre());
			System.out.println("----------");
			
		}
				
		query = em.createQuery("SELECT a FROM Autor a");
		List<Autor> listA = query.getResultList();		
		System.out.println("==== listado de autores ====");		
		for(Autor a : listA) {
			System.out.println(a.getNombre() + " " + a.getApellido());
			System.out.println("----------");
			for(Libro l : a.getBibliografia()) {
				System.out.println(l.getTitulo());
			}
			System.out.println("----------");
			}		
		
		
		query = em.createQuery("SELECT b FROM Libreria b");
		List<Libreria> listB = query.getResultList();	
		System.out.println("==== listado de librerías ====");
		for(Libreria b : listB) {
			System.out.println("==== Librería ====");
			System.out.println(b.getNombre());
			System.out.println("----------");
			for (Libro l : b.getLibros())
				System.out.println(l.getTitulo());
			System.out.println("----------");
		}					
		
		
		for(Libro l: listL) {
			System.out.print(l.getTitulo() +": ");
			for(Libreria b: l.getLib()) {
				System.out.print(b.getNombre() + ", ");
			}
			System.out.println();
			System.out.println("----------");
		}
		
	}
	
	
}