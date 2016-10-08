Ejercicio1
==========

Tenemos un programa que queremos que simule la cola única del Carrefour utilizando un ArrayBloquingQueue.

Para ello tenemos inicialmente que:

- hay 3 cajeros.
- hay Y clientes inicialmente en la cola
- se genera un nuevo cliente cada Z segundos.
- se dejan de generar clientes al cabo de T segundos.
- los cajeros tardan en atender a un cliente en un tiempo aleatorio entre 1s y 

El programa debe imprimir por pantalla:
- el tamaño de la cola cada vez que se genera un cliente.
- el identificador del cliente atendido y el nombre del cajero cuando se acaba de empezar a atenderlo ("CAJERO X ATENDIENDO CLIENTE Y")
- tiempo total de espera del cliente (cola + cajero) ("CLIENTE X ha tardado T en pasar la cola"). 
- cuando un cajero cierra la caja por estar 
