package adaptadores;

public class MenuItem {
	 
	   private String nombre;
	   private int logotipo;
	 
	   public MenuItem(String nombre, int logotipo) {
	      this.nombre = nombre;
	      this.logotipo = logotipo;
	   }
	 
	   public void setNombre(String nombre) { this.nombre = nombre; }
	 
	   public String getNombre() { return nombre; }
	 
	   public void setLogotipo(int logotipo) { this.logotipo = logotipo; }
	 
	   public int getLogotipo() { return logotipo; }
	 
	}