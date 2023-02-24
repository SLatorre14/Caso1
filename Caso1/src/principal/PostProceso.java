package principal;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class PostProceso extends Thread{
	private int id;
	private int tamanob1;
	private int tamanob2;
	private int etapa;
	private String color;
	private Buffer buffer1;
	private Buffer buffer2;
	public PostProceso(int id, int tamanob1,int tamanob2, int etapa,String color, Buffer b1, Buffer b2) {
		this.id = id;
		this.color = color;
		this.tamanob1 = tamanob1;
		this.tamanob2 = tamanob2;
		this.etapa = etapa;
		buffer1 = b1;
		buffer2 = b2;
			
	}
	
	private void esperaAleatoria() {
		try {
		Thread.sleep((long) (Math.random() * 1000));
		} catch (InterruptedException e) {
		e.printStackTrace();
		}
	}
	

	public void run() {
		System.out.println("inicia el proceso del Postproceso " + this.id +" de la etapa " + this.etapa + " y color " + this.color);
		Producto prodNuevo = null;
		if (this.color == "naranja") {
			while(buffer1.casoNaranja("naranja")) {
			
				this.yield();
				
			}
			
			prodNuevo = buffer1.consumir("naranja");
		}
		else {
			prodNuevo = buffer1.consumir(this.color);
		}
	
		System.out.println("El PostProceso " + this.id +" de la etapa " + this.etapa +  " de color " + this.color + " recogio el producto " + prodNuevo.getColor() + " de id " + prodNuevo.getId());

		prodNuevo.setNewMsg(Integer.toString(this.id));
		
		
		buffer2.producir(tamanob2, prodNuevo);
		System.out.println("El PostProceso " +this.id +" de la etapa " + this.etapa +" ha depositado el producto " + " de id " + prodNuevo.getId() +" de mensaje " + prodNuevo.getMensaje() );
		esperaAleatoria();
		

		
		}
	

	
}


