package view;

import controller.PedidoController;
import model.Eletronico;
import model.Vestuario;
import model.MetodoPagamento;
import exception.CartaoCreditoInvalidoException;

import java.util.Scanner;

public class EcommerceView {
    public static void main(String[] args) {
        PedidoController pedidoController = new PedidoController();
        Scanner scanner = new Scanner(System.in);

        Eletronico celular = new Eletronico("Celular ", 1500);
        Eletronico notebook = new Eletronico ("notebook ", 2500);
        Vestuario camisa = new Vestuario("Camisa ", 100);
        Vestuario jaqueta = new Vestuario("jaqueta ",150);
                               
        boolean escolhendoProdutos = true;
                        
        System.out.println("Bem vindo A Nossa Loja! ");
        
        while(escolhendoProdutos) {
            System.out.println("Produtos Disponiveis Na Loja! ");
            System.out.println("1 - Celular A80 - R$1500.00 ");
            System.out.println("2 - notebook Dell Gamer - R$ 2500.00 ");
            System.out.println("3 - Camisa lacoste Preta - R$100.00 ");
            System.out.println("4 - jaqueta Couro- R$ 150.00");
            System.out.println("Digite o Numero do Produto Desejado Para Adicionar Ao Carrinho: ");
            
            int produtoEscolhido = scanner.nextInt();
                        
            switch (produtoEscolhido) {
                case 1:
                    pedidoController.adicionarProduto(celular);
                    System.out.println("Celular Adicionado no Carrinho ");
                    break;
                case 2:    
                    pedidoController.adicionarProduto(notebook);
                    System.out.println("notebook Adicionado no Carrinho ");
                    break;
                case 3:
                    pedidoController.adicionarProduto(camisa);
                    System.out.println("Camiseta Adicionada no Carrinho ");
                   break;
                case 4:
                    pedidoController.adicionarProduto(jaqueta);
                    System.out.println("jaquetea Adicionada no Carrinho ");
                default:
                    System.out.println("Opçao Invalida, Escolha um produto valido!");
                    
                }
            if(produtoEscolhido !=0){
                System.out.println("Deseja Mais Algum Produto: (1: sim, 2: nao)");
                int continuar = scanner.nextInt();
                if (continuar  !=1) {
                    escolhendoProdutos = false;
                }
            }
            
        }
        
        System.out.println("Produtos Adicionados No carrinho: ");
        for(var produto: pedidoController.getPedido().getProdutos()){
            System.out.println( produto.getNome() + "- R$" + produto.getPreco());
            
        }
        
        boolean pagamentoConcluido = false;
        
        while(!pagamentoConcluido){                
        System.out.println("Escolha o metodo de pagamento (1: Cartão de Crédito, 2: Boleto, 3: PIX): ");
        int opcao = scanner.nextInt();

        try {
            switch (opcao) {
                case 1:
                        pedidoController.getPedido().setMetodoPagamento(MetodoPagamento.CARTAO_CREDITO);
                        
                        throw new CartaoCreditoInvalidoException("Cartao de credito invlido."); // Simulando erro de cartão inválido
                    case 2:
                        pedidoController.getPedido().setMetodoPagamento(MetodoPagamento.BOLETO);
                        pagamentoConcluido = true;
                        break;
                    case 3:
                        pedidoController.getPedido().setMetodoPagamento(MetodoPagamento.PIX);
                        pagamentoConcluido = true;
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
            }
        } catch (CartaoCreditoInvalidoException e) {
            System.err.println(e.getMessage());
        }
        if(!pagamentoConcluido){
            System.out.println("Deseja cancelar ou tentar uma nova forma de pagamento? (1: tentar novamente, 2: encerrar):");
            int resposta = scanner.nextInt();
            
            if(resposta == 2) {
                System.out.println("Encerrado as Compras ");
                break;
            }
        }
    }    
        
    if(pagamentoConcluido){
      System.out.println("Valor total do pedido com frete: R$ " + pedidoController.calcularValorTotal());  
      }    
   }
}

