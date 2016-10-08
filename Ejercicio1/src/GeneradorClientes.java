import java.util.concurrent.BlockingQueue;

public class GeneradorClientes implements Runnable {
	private int clientesIniciales;
	private int clientesPorSegundo;
	private long tiempoMaximo;
	private BlockingQueue q;
	
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
		// TODO: generamos "clientesIniciales" y los encolamos
		
		// mientras no nos pasemos del tiempoMaximo 
		while ((System.nanoTime() - tiempoInicial) < tiempoMaximo) {
			// TODO: esperar y generar cliente según "clientesPorSegundo".  
		}
		
		// TODO: Imprimir "Cerrando supermercado, ya no entran más clientes."
	}

}

