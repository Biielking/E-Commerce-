package controller;

import model.Pedido;
import model.Produto;

public class PedidoController {
    private Pedido pedido;

    public PedidoController() {
        pedido = new Pedido();
    }

    public void adicionarProduto(Produto produto) {
        pedido.adicionarProduto(produto);
    }

    public double calcularValorTotal() {
        return pedido.calcularValorTotal();
    }

    public Pedido getPedido() {
        return pedido;
    }
}
