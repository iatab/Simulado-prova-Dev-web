package bilton.iatamy.api_rest_produto_pedido.repository;

import bilton.iatamy.api_rest_produto_pedido.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
