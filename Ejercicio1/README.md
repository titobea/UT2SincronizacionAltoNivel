Ejercicio1
==========

Tenemos un programa que queremos que simule la cola única del Carrefour utilizando un ArrayBloquingQueue.

Para ello tendremos un thread que se encargará de encolar clientes y varios threads (cajeros)
que se encargarán de desencolarlos.

Tenemos inicialmente que:

- hay X cajeros.
- hay Y clientes inicialmente en la cola
- se genera un nuevo cliente cada Z segundos.
- se dejan de generar clientes al cabo de T1 segundos.
- los cajeros tardan en atender a un cliente en un tiempo aleatorio entre 1s y T2 segundos

El programa debe imprimir por pantalla:
- el tamaño de la cola cada 2 segundos.
- el identificador del cliente atendido y el nombre del cajero cuando se acaba de empezar a atenderlo ("CAJERO X ATENDIENDO CLIENTE Y")
- tiempo total de espera del cliente (cola + cajero) ("CLIENTE X ha tardado T en pasar la cola"). 
- "CAJA X CERRADA" cuando un cajero cierra la caja por estar T3 segundos sin recibir nuevos clientes. 
- "SUPERMERCADO CERRADO" una vez todos los clientes se han ido y todo los cajeros han cerrado las cajas.
