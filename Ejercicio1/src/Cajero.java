import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Cajero implements Runnable {
	private int id;
	private int tiempoMaximoPorCliente;
	private int maximaEspera; // tiempo máximo que estaremos sin atender antes de cerrar caja.
	private BlockingQueue q;
	
	public Cajero(int id, int tiempoPorCliente, int maximaEspera, BlockingQueue q) {
		super();
		this.maximaEspera = maximaEspera;
		this.tiempoMaximoPorCliente = tiempoPorCliente;
		this.id = id;
		this.q = q;
	}

	@Override
	public void run() {
		// TODO: mientras hayan clientes...
		// sacamos un cliente de la cola, imprimimos "CAJERO X ATENDIENDO CLIENTE Y"
		// esperamos un tiempo aleatorio entre 1segundo y tiempoMaximoPorCliente
		// AYUDA: (int)(rnd.nextDouble() * tiempoMaximoPorCliente + 1);
		
		// esperamos y imprimimos "CAJERO X FINALIZA CON CLIENTE Y. ATENDIDO EN T SEGUNDOS"
		// donde T es el tiempo que ha tardado en esperar en la cola + ser atendido.	
		// Si estamos más de "maximaEspera" segundos sin que hayan clientes imprimimos "CAJERO X CERRANDO."
		
		Random rnd = new Random();	
		long tiempoInicial=System.nanoTime();
		int tiempo=0;
		while(q.size()>0 || tiempo<maximaEspera){
			if (q.size()==0){
				tiempo=(int)((System.nanoTime()- tiempoInicial)/1000000000);
			}else{
				try {
					Cliente c = (Cliente)q.take();
					
					System.out.println("CAJERO "+id+" ATENDIENDO CLIENTE "+c.getId());
					
					Thread.sleep(((int)(rnd.nextDouble() * tiempoMaximoPorCliente + 1))*1000);
					
					System.out.println("CAJERO "+id+" FINALIZA CON CLIENTE "+c.getId()+". ATENDIDO EN "+ (int)(c.getTiempoEspera()/1000000000)+ " SEGUNDOS");
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				tiempo=0;
				tiempoInicial=System.nanoTime();
			}
			
		}
		
		System.out.println("CAJERO "+id+" CERRANDO");
		
	}
	

}
