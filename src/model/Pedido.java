package model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Produto> produtos;
    private MetodoPagamento metodoPagamento;
    private double valorTotal;

    public Pedido() {
        produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        valorTotal += produto.getPreco();
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public double calcularFreteTotal() {
        double freteTotal = 0;
        for (Produto produto : produtos) {
            freteTotal += produto.calcularFrete();
        }
        return freteTotal;
    }

    public double calcularValorTotal() {
        return valorTotal + calcularFreteTotal();
    }
}
