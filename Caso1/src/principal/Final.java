package principal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Final extends Thread{
	private Buffer buffer;
	private List<Producto> lista;
	private int tamano;
	
	public Final(Buffer b, int tamano) {
		buffer = b;
		this.tamano = tamano;
		lista = new ArrayList<Producto>();
	}
	
	class SortById implements Comparator<Producto>{
	    @Override
	    public int compare(Producto o1, Producto o2) {
	        int person_id1=o1.getId();
	        int person_id2=o2.getId();
	        if(person_id1 > person_id2){
	            return 1;
	        }
	        else if(person_id1 < person_id2){
	            return -1;
	        }
	        else return 0;
	    }
	}
	
	
	public void run() {
	
		
		while (buffer.getTamanocola()< tamano) {
			try {
				this.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("----------------------------------");
		System.out.println("Finalizacion del proceso");
		for (int i = 0; i < buffer.getTamanocola(); i++) {
			lista.add(buffer.getProducto(i));
		}
		System.out.println("----------------------------------");
		Collections.sort(lista, new SortById());
		for (Producto productos: lista) {
			System.out.println("El producto de id: " + productos.getId() + " ha llegado al final con el mensaje " + productos.getMensaje());
		}
	}
}
