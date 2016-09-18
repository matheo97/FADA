
package fadaminiproyecto2;

import java.util.ArrayList;


public class FadaMiniProyecto2 {

         
    public static void main(String[] args) 
    {
        Voraz v = new Voraz();
        v.cargar();
        
        //Caso 1
        v.armarSolucion();
        
        for (int i = 0; i < v.solucion.size(); i++) 
        {
            ArrayList<Libro> escritor = v.solucion.get(i);
            
            for (int j = 0; j < escritor.size(); j++) 
            {
                Libro n = escritor.get(j);
                
                System.out.println("-------->");
                System.out.println(n.getNombre() + " " + n.getPaginas());
                
            }
            
            System.out.println("---------------------escritor----------------------");
        }
        
        

        //Caso 2
//        v.parejas();
//        v.armarSolucionCaso1();
        
        for (int i = 0; i < v.libros.size(); i++) 
        {
            Libro m = v.libros.get(i);
            System.out.println(m.getNombre() + " " + m.getPaginas());
            
            
        }
        System.out.println("------libros-----");
        
        for (int i = 0; i < v.parejas.size(); i++) 
        {
            Libro n[] = v.parejas.get(i);
            Libro m = n[0];
            Libro c = n[1];
                
            System.out.println("Pareja: " + (i+1));
            System.out.println(m.getNombre() + " " + m.getPaginas());
            System.out.println(c.getNombre() + " " + c.getPaginas());    
        }
        
        for (int i = 0; i < v.escritores.size(); i++) 
        {
            ArrayList<Libro[]> escritor = v.escritores.get(i);
            
            for (int j = 0; j < escritor.size(); j++) 
            {
                Libro n[] = escritor.get(j);
                Libro m = n[0];
                Libro c = n[1];
                
                System.out.println("-------->");
                System.out.println(m.getNombre() + " " + m.getPaginas());
                System.out.println(c.getNombre() + " " + c.getPaginas());
                
            }
            
            System.out.println("---------------------escritor----------------------");
            
        } 
        
//        ArrayList<Integer> lol = new ArrayList<>();
//        lol.add(1);
//        lol.add(2);
//        lol.add(4);
//        lol.add(5);
//        lol.add(2, 3);
//        
//        System.out.println(lol.size());
    }
}
