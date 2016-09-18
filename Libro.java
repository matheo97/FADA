package fadaminiproyecto2;


public class Libro 
{
    String nombre;
    int paginas;

    public Libro() 
    {
        nombre = "asdsa";
        paginas = -1;
    
    }
    
    public Libro(String nombre, int paginas) 
    {
        this.nombre = nombre;
        this.paginas = paginas;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }
       
}
