package main;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import beans.Autor;
import beans.Libreria;
import beans.Libro;

public abstract class ObjToXML {
	
	
	public static void objectToXML(Libro libro) {
		
		JAXBContext contexto;		
		try {			
			contexto = JAXBContext.newInstance(Libro.class);
		} catch (JAXBException e) {
			System.out.println("Error creando el contexto");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return;
		}
		
		Marshaller m;
		try {
			
			m = contexto.createMarshaller();
			
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
									
			
			m.marshal(libro, System.out);
			
			m.marshal(libro, new File(libro.getTitulo()+".xml"));
		} catch (JAXBException e) {
			System.out.println("Error convertiendo el objeto a formato XML");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
public static void objectToXML(Autor autor) {
		
		JAXBContext contexto;		
		try {			
			contexto = JAXBContext.newInstance(Autor.class);
		} catch (JAXBException e) {
			System.out.println("Error creando el contexto");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return;
		}
		
		Marshaller m;
		try {
			
			m = contexto.createMarshaller();
			
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
									
			
			m.marshal(autor, System.out);
			
			m.marshal(autor, new File(autor.getNombre()+autor.getApellido()+".xml"));
		} catch (JAXBException e) {
			System.out.println("Error convertiendo el objeto a formato XML");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
}
		
		public static void objectToXML(Libreria lib) {
			
			JAXBContext contexto;		
			try {			
				contexto = JAXBContext.newInstance(Libreria.class);
			} catch (JAXBException e) {
				System.out.println("Error creando el contexto");
				System.out.println(e.getMessage());
				e.printStackTrace();
				return;
			}
			
			Marshaller m;
			try {
				
				m = contexto.createMarshaller();
				
				m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				
										
				
				m.marshal(lib, System.out);
				
				m.marshal(lib, new File("Libreria_"+lib.getNombre()+".xml"));
			} catch (JAXBException e) {
				System.out.println("Error convertiendo el objeto a formato XML");
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
	}

}
