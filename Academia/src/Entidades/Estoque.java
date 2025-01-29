package Entidades;

import Comparator.ProdutoidComparator;
import academia.SistemaCentral;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 *
 * @author Carlo
 */
public class Estoque {

    private List<Produto> produtos;

    // Construtor da classe Estoque inicializando a lista de produtos
    public Estoque() {
        this.produtos = new ArrayList<>();
    }

    // Método para criar produtos
    public void criarProduto(Produto p) {
        this.produtos.add(p);
    }
    
    // Método para buscar um produto pelo ID usando binarySearch
    public Produto buscarProduto(int id) {
    // Produto temporário com o ID para a busca
        Produto produtoBusca = new Produto(id, null, 0, 0.0);
        int index = Collections.binarySearch(this.produtos, produtoBusca, new ProdutoidComparator());
        
        if (index >= 0) {
            return this.produtos.get(index);
        } else {
            return null;  // Retorna null se o produto não for encontrado
        }
    }
    
    // metodo para alterar produto 
        public void alterarProduto(int id, String novoNome, double novoPreco) {
        Produto produto = buscarProduto(id);

        if (produto != null) {
            produto.setNome(novoNome);
            produto.setPreco(novoPreco);
            System.out.println("Produto alterado com sucesso: " + produto);
        } else {
            System.out.println("Produto não encontrado.");
        }
    }
        
    // metodo para remover produto
        public void removerQuantidade(int id, int quantidade) {
    Produto produto = buscarProduto(id);
    if (produto != null) {
        produto.setQuantidade(produto.getQuantidade() - quantidade);
    }
        }


}
