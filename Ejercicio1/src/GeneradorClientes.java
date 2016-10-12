import java.util.concurrent.BlockingQueue;

public class GeneradorClientes implements Runnable {
	private int clientesIniciales;
	private int clientesPorSegundo;
	private long tiempoMaximo;
	private BlockingQueue q;
	private int numCliente=0;
	
	public GeneradorClientes(int clientesIniciales, int clientesPorSegundo, long tiempoMaximo, BlockingQueue q) {
		super();
		this.clientesIniciales = clientesIniciales;
		this.clientesPorSegundo = clientesPorSegundo;
		this.tiempoMaximo = tiempoMaximo;
		this.q = q;
	}
	
	@Override
	public void run() {
		long tiempoInicial = System.nanoTime();
		// TODO: generamos "clientesIniciales" y los encolamos crear objetos clients indicados
		crearClientes(clientesIniciales);
		// mientras no nos pasemos del tiempoMaximo 
		while ((int)((System.nanoTime() - tiempoInicial)/1000000000) < tiempoMaximo) {
			// TODO: esperar y generar cliente según "clientesPorSegundo".
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			crearClientes(clientesPorSegundo);
		}
				
		// TODO: Imprimir "Cerrando supermercado, ya no entran más clientes."
		System.out.println("Cerrando supermercado, ya no entran más clientes.");
	}
	
	public void crearClientes(int num){
		for(int i=0; i<num; i++) {
			Cliente c = new Cliente(numCliente);
			numCliente+=1;
			try {
				q.put(c);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

