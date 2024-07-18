package model;
import view.*;
import java.sql.*;

import view.Erro;

public class PedidoModel {
    public static void prepararReceita(String idReceita) {
        try {
            Connection conn = MySQLConnector.conectar();

            String strSqlSelectItensReceita = "select * from `db_mysql_connector`.`tbl_itens_receita` where `id_receita` = " + idReceita + ";";
            Statement stmSqlItensReceita = conn.createStatement();
            ResultSet rsSqlItensReceita = stmSqlItensReceita.executeQuery(strSqlSelectItensReceita);

            String idProduto = "";
            String qtdProdutoReceita = "";

            String strSqlSelectProduto = "";
            Statement stmSqlSelectProduto = null;
            ResultSet rsSqlSelectProduto = null;
            String qtdProduto = "";
            int qtdProdutoAtualizada = 0;

            Statement stmSqlUpdateProduto = null;

            while (rsSqlItensReceita.next()) {
                idProduto = rsSqlItensReceita.getString("id_produto");
                qtdProdutoReceita = rsSqlItensReceita.getString("qtd");

                strSqlSelectProduto = "select `qtd` from `db_mysql_connector`.`tbl_produtos` where `id` = " + idProduto + ";";
                stmSqlSelectProduto = conn.createStatement();
                rsSqlSelectProduto = stmSqlSelectProduto.executeQuery(strSqlSelectProduto);
                while (rsSqlSelectProduto.next()) {
                    qtdProduto = rsSqlSelectProduto.getString("qtd");
                }
                qtdProdutoAtualizada = Integer.valueOf(qtdProduto) - Integer.valueOf(qtdProdutoReceita);

                String strSqlUpdateProduto = "update `db_mysql_connector`.`tbl_produtos` set `qtd` = (" + qtdProdutoAtualizada + ") where `id` = " + idReceita + ";";
                stmSqlUpdateProduto = conn.createStatement();
                stmSqlUpdateProduto.addBatch(strSqlUpdateProduto);
                stmSqlUpdateProduto.executeBatch();

                

                stmSqlUpdateProduto.close();

                stmSqlSelectProduto.close();
                rsSqlSelectProduto.close();
            }

            stmSqlItensReceita.close();
            rsSqlItensReceita.close();
        } catch (Exception e) {
            Erro.exibirErro(String.valueOf(e));
        }
    }
}
