import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class DemoProductorConsumidor {
	public static void main(String[] args) {
		BlockingQueue<Integer> q = new ArrayBlockingQueue<Integer>(1000);
		
		int cajeros = 10; // tenemos 10 cajeros
		int clientes_iniciales = 100; // generamos 100 clientes inicialmente
		int tiempo_cajero = 1; // un cajero tarda 1 segundo por cliente.
		int tiempo_cliente = 1; // se crea un nuevo cliente por segundo.
		
		
		
		
	}
}


