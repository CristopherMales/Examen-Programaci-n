package controller;
import java.util.ArrayList;

import model.*;
public class Controllers {

	ArrayList<Libro> libros= new ArrayList<Libro>();
	
    public void guardarLibro(Libro libro) {
        
    	System.out.println("desde mi Controller");
    	
    	System.out.println(libro);

    	libros.add(libro);
    }
    
    public void verLibrosPrestados() {
        for (int i = 0; i < libros.size(); i++) {
            System.out.println(libros);
            
        }
    }
	

}
