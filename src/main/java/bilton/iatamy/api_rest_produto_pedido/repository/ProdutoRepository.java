package bilton.iatamy.api_rest_produto_pedido.repository;

import bilton.iatamy.api_rest_produto_pedido.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
