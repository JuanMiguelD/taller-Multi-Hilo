package com.taller.multiThreading;

import java.util.Queue;

public class ProcesadorPedidos implements Runnable {
    private final Queue<Pedido> colaPedidos;
    private final String nombreProcesador;
    private volatile boolean ejecutando = true;

    public ProcesadorPedidos(Queue<Pedido> colaPedidos, String nombreProcesador) {
        this.colaPedidos = colaPedidos;
        this.nombreProcesador = nombreProcesador;
    }

    @Override
    public void run() {
        while (ejecutando) {
            Pedido pedido = colaPedidos.poll();
            if (pedido != null) {
                procesarPedido(pedido);
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }

    private void procesarPedido(Pedido pedido) {
        try {
            System.out.printf("%s: Procesando %s%n", 
                            nombreProcesador, pedido.toString());
            Thread.sleep(2000);
            pedido.setEstado("PROCESADO");
            System.out.printf("%s: Completado %s%n", 
                            nombreProcesador, pedido.toString());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            pedido.setEstado("ERROR");
        }
    }

    public void detener() {
        ejecutando = false;
    }
}