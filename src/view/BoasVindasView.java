package view;
import controller.*;
import java.util.*;

public class BoasVindasView {
    public static void exibirCumprimento() {
        System.out.println("Bem-vindo(a) à Padoka mais saborosa do mundo!");
        mostrarOpcoes();
    }

    public static void mostrarOpcoes() {
        System.out.println("Digite abaixo [ 1 ] para exibir o cardápio ou [ 2 ] para sair, depois tecle Enter: ");
        Scanner scnOpcao = new Scanner(System.in);
        String strOpcao = scnOpcao.nextLine();
        switch (strOpcao) {
            case "1":
                CardapioControl.exibirCardapio();
                break;
            case "2":
                System.out.println("Obrigado pela visita! Volte sempre.");
                break;
            default:
                System.out.println("Opção inválida.");
                mostrarOpcoes();
                break;
        }
        scnOpcao.close();
    }
}
