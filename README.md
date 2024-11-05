# taller-Multi-Hilo

Este proyecto implementa un sistema de procesamiento de pedidos utilizando programación multi-hilo en Java. Está compuesto por tres clases principales:

1. Clase Pedido
Representa un pedido individual en el sistema.
2. Clase ProcesadorPedidos
Implementa la lógica de procesamiento de pedidos en hilos separados.
3. Clase SistemaPedidosOnline
Clase principal que coordina todo el sistema, crea una cola thread-safe (ConcurrentLinkedQueue) para los pedidos e inicializa múltiples procesadores de pedidos en hilos separados
