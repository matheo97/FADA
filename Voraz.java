package fadaminiproyecto2;

import java.io.*;
import java.util.*;


public class Voraz 
{
    ArrayList<Libro> libros;
    ArrayList<ArrayList<Libro>> solucion;
    ArrayList<Libro[]> parejas;
    ArrayList<ArrayList<Libro[]>> escritores;
    int numEscritores;
    int numLibros;

    public Voraz() 
    {
        libros = new ArrayList();
        parejas = new ArrayList();
        escritores = new ArrayList();
        solucion = new ArrayList();
        numEscritores = 0;
        numLibros = 0;
    }
    
    public void cargar()
    {
        String mensaje = "";
        String temp = "";
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        StringTokenizer token;
         
         
        try
        {
            fr = new FileReader(new File("libros.txt"));
            br = new BufferedReader(fr);
            int i = 0;
             
            while((mensaje = br.readLine()) != null)
            {
                if(i == 1)
                {
                    temp = mensaje;
                    token = new StringTokenizer(temp);
                    numEscritores = Integer.parseInt(token.nextToken());
                    numLibros = Integer.parseInt(token.nextToken());

                }
                if(i > 1)
                {
                     
                    temp = mensaje;
                    token = new StringTokenizer(temp);
                    String nombre = token.nextToken();
                    int numeroPaginas = Integer.parseInt(token.nextToken());
                    
                    Libro libro = new Libro(nombre, numeroPaginas);
                    
                    insertionSort(libro);
                    
                    
                  
                }
                 
                i++;
            }
             
        }
        catch(Exception x)
        {
            System.err.print(x.toString());
        }
        finally{
             
         try
         {                  
            if( null != fr)
            { 
               fr.close();   
            }                
         }
         catch (Exception e2)
         {
             System.err.print("Error 2");
         }
      }
         
    }
    
    public void insertionSort(Libro l)
    {
        if(libros.size() == 0)
        {
            libros.add(l);
        }
        else
        {
            for (int i = 0; i < libros.size(); i++) 
            {
                if(libros.get(i).getPaginas() >= l.getPaginas())
                {
                    libros.add(i, l);
                    break;
                }
                if(i+1 == libros.size())
                {
                    libros.add(l);
                    break;
                }
            }
        }
    }
    
    public void insertionSortParejas(Libro p[])
    {
        
        if(parejas.size() == 0)
        {
            parejas.add(p);
        }
        else
        {
            for (int i = 0; i < parejas.size(); i++) 
            {
                Libro x[] = parejas.get(i);
                int m = x[0].getPaginas() + x[1].getPaginas();
                int n = p[0].getPaginas() + p[1].getPaginas();
                
                if(m >= n)
                {
                    parejas.add(i, p);
                    break;
                }
                if(i+1 == parejas.size())
                {
                    parejas.add(p);
                    break;
                }
            }
        }
    }
    
    public void parejas()
    {
        int n = libros.size() - 1;        
        
        for(int i = 0; i < libros.size(); i++)
        {
            if(n <= i)
            {
                if(libros.size() % 2 == 0)
                {
                    break;
                }
                else
                {
                    Libro l = new Libro();
                    Libro p[] = {libros.get(i), l};
                    System.out.println("-------> " + libros.get(i).nombre);
                    insertionSortParejas(p);
                    break;
                }
            }
            else
            {
                Libro l = libros.get(i);
                Libro m = libros.get(n);
                Libro p[] = {l,m};
                insertionSortParejas(p);
                n--;
            }
        }
        
        
    }
    
    public void armarSolucionCaso1()
    {   
        for (int i = 0; i < numEscritores; i++) 
        {
            ArrayList<Libro[]> escritor = new ArrayList();
            escritores.add(escritor);    
        }
        
        int flag = 1;
        int index = 0;
        
        while(parejas.size() >= (index + 1))
        {
            for (int i = 0; i < numEscritores; i++) 
            {
                if(parejas.size() >= (index + 1))
                {
                    escritores.get(i).add(parejas.get(index));
                    index++;                
                }
            }
                
            for (int i = numEscritores -1; i >= 0; i--) 
            {
                if(parejas.size() >= (index + 1))
                {
                    escritores.get(i).add(parejas.get(index));
                    index++;                
                }
                
            }
        }
    }
    
    public void armarSolucionCaso2()
    {
        for (int i = 0; i < numEscritores; i++) 
        {
            ArrayList<Libro> escritor = new ArrayList();
            solucion.add(escritor); 
            System.out.println(i+1);
        }
        
        for (int i = 0; i < numEscritores; i++) 
        {
            solucion.get(i).add(libros.get(i));           
        }
        
        int n = (numLibros - numEscritores) - 1;
        
        for (int i = (numLibros-1); i >= numEscritores; i--) 
        {
            solucion.get(n).add(libros.get(i));
            n--;
        } 
    }
    
    public void armarSolucion()
    {
        if((numEscritores*2) <= numLibros )
        {
            parejas();
            armarSolucionCaso1();
        }
        else
        {
            armarSolucionCaso2();
        }
    }
    
}
