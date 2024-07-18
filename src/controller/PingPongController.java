package controller;
import model.*;
import view.*;

public class PingPongController {
    public static void main(String[] args) {
        PingPongView.exibirQtdFarinha();
        PingPongModel.qtdFarinha();
        PingPongView.exibirQtdFarinha();
    }
}
