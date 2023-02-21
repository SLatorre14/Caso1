package principal;



public class Principal {
	
	private static int cantidad = 10;
	private static int tamanoB = 8;
	private static int tamanoB2 = 10;
	
	

	
	
	
	


	
	public static void main(String[] args) {
		Buffer b =new Buffer();
		Buffer b2 = new Buffer();
		Buffer b3 = new Buffer();
		Proceso[] procesos = new Proceso[cantidad];
		for (int i = 0; i < cantidad-1; i++) {
			procesos[i] = new Proceso(i, tamanoB,"azul", b);
		}
		for (int i = cantidad-1; i < cantidad; i++) {
			procesos[i] = new Proceso(i, tamanoB,"naranja", b);
		}
		for (Proceso proceso : procesos) {
		      proceso.start();
		    }
		PostProceso[] postProcesos = new PostProceso[cantidad];
		for ( int i = 0; i < cantidad-1; i++) {
			postProcesos[i] = new PostProceso(i,tamanoB2,tamanoB2,2,"azul", b, b2);
		}
		for (int i = cantidad-1; i < cantidad; i++) {
			postProcesos[i] = new PostProceso(i,tamanoB2,tamanoB2,2,"naranja",b,b2);
		}
		for (PostProceso postProceso: postProcesos) {
			postProceso.start();
		}

		
		PostProceso[] postProcesos2 = new PostProceso[cantidad];
		for ( int i = 0; i < cantidad-1; i++) {
			postProcesos2[i] = new PostProceso(i,tamanoB2,10,3,"azul", b2, b3);
		}
		for (int i = cantidad-1; i < cantidad; i++) {
			postProcesos2[i] = new PostProceso(i,tamanoB2,10,3,"naranja",b2,b3);
		}
		for (PostProceso postProceso2: postProcesos2) {
			postProceso2.start();
		}
		
		
		
	}
}
