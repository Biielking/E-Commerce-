package dao;

import model.Produto;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    private List<Produto> produtos;

    public ProdutoDAO() {
        produtos = new ArrayList<>();
    }

    public void salvarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println("Produto " + produto.getNome() + " salvo no banco de dados.");
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }
}
