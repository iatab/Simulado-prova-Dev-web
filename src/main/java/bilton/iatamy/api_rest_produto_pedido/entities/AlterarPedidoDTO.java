package bilton.iatamy.api_rest_produto_pedido.entities;

import java.util.List;

public class AlterarPedidoDTO {

    private List<Produto> produtos;




    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
