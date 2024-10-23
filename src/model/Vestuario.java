package model;

public class Vestuario extends Produto {
    public Vestuario(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public double calcularFrete() {
        return getPreco() * 0.05; // 
    }
}
