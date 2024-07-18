package view;
import controller.*;
import java.util.*;
import com.mysql.cj.util.*;

public class CardapioView {
    public static void mostrarReceitas() {
        InterfacePadoka.vendoCardapio = true;
        System.out.println("Digite abaixo a opção desejada e tecle Enter, para realizar o pedido: ");
        for (int r = 0; r < CardapioInter.idsReceitas.size(); r++) {
            System.out.println("[ " + CardapioInter.idsReceitas.get(r) + " ] - " + CardapioInter.nomesReceitas.get(r) + " - " + CardapioInter.disponibilidadesReceitas.get(r));
        }
        System.out.println("[ s ] - Sair");
        Scanner scnOpcao = new Scanner(System.in);
        String strOpcao = scnOpcao.nextLine().toLowerCase();

        if (CardapioHelper.isNumeric(strOpcao)) {
            // System.out.println("CardapioInter.idsReceitas.size(): " + CardapioInter.idsReceitas.size());
            // System.out.println("Integer.valueOf(strOpcao): " + Integer.valueOf(strOpcao));
            if (Integer.valueOf(CardapioInter.idsReceitas.size()) <= Integer.valueOf(strOpcao)) {
                if (CardapioInter.disponibilidadesReceitas.get(Integer.parseInt(strOpcao) - 1).equals(CardapioInter.disponivel)) {
                    PedidoControl.realizarPedido(strOpcao);
                } else {
                    System.err.println("Ops! Opção " + CardapioInter.indisponivel + ", favor selecionar outra receita.");
                    mostrarReceitas();
                }
            } else {
                OpcaoInvalidaView.exibirOpcaoInvalida();
                mostrarReceitas();
            }
        } else {
            if (strOpcao.equals("s")) {
                SaidaView.sair();
            } else {
                OpcaoInvalidaView.exibirOpcaoInvalida();
            }
        }
        scnOpcao.close();
    }
}
