package principal;

import java.util.ArrayList;

public class Buffer {

	private ArrayList<Producto> cola;
	private int siguiente;
	private boolean vacia;
	private boolean llena;
	
	public Buffer(){
		cola = new ArrayList<Producto>();
		this.siguiente = 0;
		this.vacia = true;
		this.llena = false;
	}
	
	public synchronized void producir(int cant, Producto prod) {

		while(this.llena) {
			try {
				System.out.println("La cola se encuentra llena");
				wait();
				
			} catch (InterruptedException e) {
				
			}
			
		}
		cola.add(siguiente, prod);
		siguiente ++;
		this.vacia = false;
		if(siguiente == cant) {
			this.llena = true;
		}
		notifyAll();
	}
	
	
	public synchronized Producto consumir(String color) {
		Producto resp = null;
	

		if (color == "azul") {
			while(this.vacia) {
				try {
					wait();
				} catch (InterruptedException e) {
					
				}
				
			}
		
		
		while((cola.get(siguiente-1).getColor()) != color){
			
			try {
				
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
				
		}
		}
		
		
		siguiente --;
		this.llena = false;
		if (siguiente == 0) {
			this.vacia = true;
		}

		resp = cola.get(siguiente);
		cola.remove(siguiente);
		notifyAll();
	
		
	
		return resp;
	}
	
	public int getTamanocola() {
		return cola.size();
	
	}
	
	public Producto getProducto(int i) {
		return cola.get(i);
	}
	
	public void quitarProductos(Producto prod) {
		cola.remove(prod);
	}
	
	public boolean casoNaranja(String color) {

		boolean resp = true;
		if(vacia || cola.size()== 0) {
			return resp;
		}
	
		if ((cola.get(siguiente-1).getColor()) == color) {
			resp = false;
		}
		
		return resp;
		
	}

}
