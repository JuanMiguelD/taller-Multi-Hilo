package com.taller.multiThreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SistemaPedidosOnline {
    public static void main(String[] args) throws InterruptedException {
        Queue<Pedido> colaPedidos = new ConcurrentLinkedQueue<>();
        
        int numProcesadores = 3;
        List<Thread> threads = new ArrayList<>();
        List<ProcesadorPedidos> procesadores = new ArrayList<>();

        for (int i = 0; i < numProcesadores; i++) {
            ProcesadorPedidos procesador = new ProcesadorPedidos(colaPedidos, 
                                                                "Procesador-" + (i + 1));
            Thread thread = new Thread(procesador);
            threads.add(thread);
            procesadores.add(procesador);
            thread.start();
        }

        for (int i = 1; i <= 10; i++) {
            colaPedidos.offer(new Pedido(i, "Producto-" + i, 100.0 * i));
            Thread.sleep(500);
        }

        Thread.sleep(10000);

        for (ProcesadorPedidos procesador : procesadores) {
            procesador.detener();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Sistema de procesamiento de pedidos finalizado.");
    }
}