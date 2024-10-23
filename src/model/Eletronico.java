package model;

public class Eletronico extends Produto {
    public Eletronico(String nome, double preco) {
        super(nome, preco);
    }

   
    public double calcularFrete() {
        return getPreco() * 0.1; // Exemplo de cálculo de frete para eletrônicos
    }
}
