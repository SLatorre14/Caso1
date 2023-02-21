package principal;

public class Proceso extends Thread{
	private int tamano;
	private Buffer buffer;
	int id;
	String color;
	public Proceso(int id, int tamano,String color, Buffer b) {
		this.id  = id;
		this.color = color;
		this.buffer = b;
		this.tamano = tamano;
	}
	private void esperaAleatoria() {
		try {
		Thread.sleep((long) (Math.random() * 1000));
		} catch (InterruptedException e) {
		e.printStackTrace();
		}
		}
	
	public void run() {
			System.out.println("inicia el proceso del proceso " + this.id + " y color " + this.color);
			Producto prod = new Producto(this.id, Integer.toString(this.id),this.color);
			
			buffer.producir(tamano, prod);
			System.out.println("El thread " +this.id + " ha depositado el producto " + prod.getMensaje());
			esperaAleatoria();
		
	
		
	}
}
