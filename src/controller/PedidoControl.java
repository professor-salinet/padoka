package controller;

import model.*;
import view.*;

public class PedidoControl {
    public static void realizarPedido(String idReceita) {
        PedidoModel.prepararReceita(idReceita);
    }

    public static void baixarPedido() {
        PedidoView.finalizarPedido();
    }
}
