package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import main.ObjToXML;
import beans.Autor;
import beans.Direccion;
import beans.Editorial;
import beans.Libreria;
import beans.Libro;

public class main {

	public static void main(String[] args) {
		
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
		
		System.out.println(a2);
		
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
		
		List<Libro> listaA2 = new ArrayList<Libro>();
		Libro l1 = new Libro();
		l1.setTitulo("El Italiano");
		l1.setPrecio(20.99f);		
		l1.setEditorial(e2);
		//l1.setAutor(a2);
						
		Libro l2 = new Libro();
		l2.setTitulo("Sidi");
		l2.setPrecio(20.99f);
		l2.setEditorial(e2);
		//l2.setAutor(a2);				
		
		Libro l3 = new Libro();
		l3.setTitulo("Falcó");
		l3.setPrecio(20.99f);
		l3.setEditorial(e2);
		//l3.setAutor(a2);
		
		listaA2.add(l1);
		listaA2.add(l2);
		listaA2.add(l3);
		a2.setBibliografia(listaA2);
		
		System.out.println(a2.getBibliografia());
		
		List<Libro> listaA1 = new ArrayList<Libro>();
		Libro l4 = new Libro();
		l4.setTitulo("Rabia");
		l4.setPrecio(10.99f);
		//l4.setAutor(a1);
		l4.setEditorial(e1);
				
		
		Libro l5 = new Libro();
		l5.setTitulo("It");
		l5.setPrecio(7.99f);
		//l5.setAutor(a1);
		l5.setEditorial(e1);
		
		
		Libro l6 = new Libro();
		l6.setTitulo("Carrie");
		l6.setPrecio(25.99f);
		//l6.setAutor(a1);
		l6.setEditorial(e1);
		
		listaA1.add(l6);
		listaA1.add(l5);
		listaA1.add(l4);
		a1.setBibliografia(listaA1);
				
		List<Libro> listaA3 = new ArrayList<Libro>();
		Libro l7 = new Libro();
		l7.setTitulo("Los Hermanos Karamazov");
		l7.setPrecio(12.99f);
		//l7.setAutor(a3);
		l7.setEditorial(e1);
		
		
		Libro l8 = new Libro();
		l8.setTitulo("Crimen y Castigo");
		l8.setPrecio(25.99f);
		//l8.setAutor(a3);
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
				
		
		
		ObjToXML.objectToXML(b1);
		ObjToXML.objectToXML(b2);
		
		ObjToXML.objectToXML(a1);
		ObjToXML.objectToXML(a2);
		ObjToXML.objectToXML(a3);
		
		
		ObjToXML.objectToXML(l1);
		/*
		ObjToXML.objectToXML(l2);
		ObjToXML.objectToXML(l3);
		ObjToXML.objectToXML(l4);
		ObjToXML.objectToXML(l4);
		ObjToXML.objectToXML(l5);
		ObjToXML.objectToXML(l6);
		ObjToXML.objectToXML(l7);
		ObjToXML.objectToXML(l8);
		*/
	
		
	}

}
