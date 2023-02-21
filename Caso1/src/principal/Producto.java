package principal;

public class Producto {
	private int id;
	private String color;
	private String mensaje;
	private Buffer buffer;	
	
	public Producto(int id, String mensaje,String color) {
		this.id = id;
		this.color = color;
		this.mensaje = mensaje;
	}
	
	
	public String getColor() {
		return this.color;
	}
	
	public int getId() {
		return this.id;
	}
	
	public synchronized void setNewMsg(String a) {
		 String nuevo = mensaje+"-"+a;
		 mensaje = nuevo;
	}
	
	public String getMensaje() {
		return mensaje;
	}
}
