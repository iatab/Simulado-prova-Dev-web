package bilton.iatamy.api_rest_produto_pedido.entities;

import java.util.List;

public class AlterarPedidoDTO {
    private Long id;
    private List<Produto> produtos;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
