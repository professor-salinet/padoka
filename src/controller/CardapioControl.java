package controller;
import model.*;
import view.*;

public class CardapioControl {
    public static void exibirCardapio() {
        CardapioModel.atualizarCardapio();
        CardapioView.mostrarReceitas();
    }
}
