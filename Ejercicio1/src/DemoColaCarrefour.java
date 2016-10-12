import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class DemoColaCarrefour {
	public static void main(String[] args) throws InterruptedException {
		// TODO: creamos nuestra BloquingQueue
		
		BlockingQueue<Cliente> q = new ArrayBlockingQueue<Cliente>(1000);
		ArrayList<Thread> cajeros = new ArrayList<>();
		
		// TODO: Creamos y arrancamos el generador de clientes. Por ejemplo:
		// 30 clientes iniciales
		// 2 clientes nuevos por segundo
		// 100 segundos antes de cerrar las puertas del super...
		
		GeneradorClientes gc = new GeneradorClientes(30,2,100,q);
		new Thread(gc).start();
		
		// 3 cajeros para atender
		Cajero c;
		Thread t;
		for(int i=0; i<3; i++) {
			// TODO: Creamos y arrancamos los cajeros en sus Threads
			c = new Cajero(i,2,10,q);			
			t= new Thread(c);
			t.start();
			cajeros.add(t);
		}
		
		// TODO: Imprimir cada 2segundos el tamaño de la cola
		Thread.sleep(2000);		
		while (q.size()>0){//mientras haya clientes
			System.out.println(q.size()+" clientes en cola.");
			Thread.sleep(2000);
		}
		
		// TODO: Esperamos a que se vayan los clientes y cajeros para cerrar el super
		// y imprimimos "SUPERMERCADO CERRADO."
		
		//espera de cajeros		
		int num = cajeros.size();
		while (num>0){
			num = cajeros.size();
			for(int i=0; i<3; i++) {
				if (!cajeros.get(i).isAlive()){
					num-=1;
				}
			}
		}
		
		System.out.println("SUPERMERCADO CERRADO.");
		
	}
}
