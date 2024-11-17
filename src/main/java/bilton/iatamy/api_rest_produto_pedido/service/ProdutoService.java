package bilton.iatamy.api_rest_produto_pedido.service;

import bilton.iatamy.api_rest_produto_pedido.entities.Produto;
import bilton.iatamy.api_rest_produto_pedido.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }
    //Adicionar Produtos: Crie um endpoint que permita adicionar novos produtos disponíveis na loja.
    public Produto adicionarProduto(Produto produto) {
        Produto prod = new Produto();
        prod.setNome(produto.getNome());
        prod.setDescricao(produto.getDescricao());
        prod.setPreco(produto.getPreco());
        return produtoRepository.save(prod);
    }

    //Listar Produtos: Crie um endpoint que permita aos clientes listar todos os produtos disponíveis na loja.
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();


    }


    //Consultar Detalhes do Produto: Crie um endpoint que permita aos clientes consultar os detalhes de um produto específico.
    // é usado o optional pois pode retornar um nulo
    public Optional<Produto> buscarProdutoPorId(Long id) {

        return produtoRepository.findById(id);
    }



}
