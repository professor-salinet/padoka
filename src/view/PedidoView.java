package view;

import controller.*;

public class PedidoView {
    public static void finalizarPedido() {
        System.out.println("Pedido realizado com sucesso!");
        CardapioView.mostrarReceitas();
    }
    
}
