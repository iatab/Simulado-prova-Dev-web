package bilton.iatamy.api_rest_produto_pedido.service;

import bilton.iatamy.api_rest_produto_pedido.entities.AlterarPedidoDTO;
import bilton.iatamy.api_rest_produto_pedido.entities.Pedido;
import bilton.iatamy.api_rest_produto_pedido.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {


    private PedidoRepository pedidoRepository;
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }


    public List<Pedido> buscarPedido() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidos;
    }


    //Adicionar novo Pedido: Crie um endpoint que permita aos clientes adicionar um novo pedido.
    public Pedido adicionarPedido(Pedido pedido) {
        Pedido ped = new Pedido();
        ped.setNome(pedido.getNome());
        ped.setDescricao(pedido.getDescricao());
        ped.setProdutos(pedido.getProdutos());
        ped.setProdutos(pedido.getProdutos());
        pedidoRepository.save(ped);
        return ped;
    }
    //Alterar pedido: Crie um endpoint que permita aos clientes alterar um determinado pedido.
    public Pedido atualizarPedido(Pedido pedido) throws Exception {
        Optional<Pedido> ped = pedidoRepository.findById(pedido.getId());
        if (Optional.ofNullable(ped).isPresent()) {
            ped.get().setNome(pedido.getNome());
            ped.get().setDescricao(pedido.getDescricao());
            ped.get().setProdutos(pedido.getProdutos());
            return pedidoRepository.save(ped.get());
        }
        throw new Exception("pedido nao existe");

    }
    //Alterar produtos patch de um pedido: Crie um endpoint que permita aos clientes alterar os produtos de um determinado pedido.
    public AlterarPedidoDTO alterarProdutodoPedidoPorId(Long id, AlterarPedidoDTO pedidoDTO) throws Exception {
        Optional<Pedido> ped = pedidoRepository.findById(id);
        if (ped.isPresent()) {
            ped.get().setProdutos(pedidoDTO.getProdutos());
            pedidoRepository.save(ped.get());
            return pedidoDTO;

        }
        throw new Exception("Pedido nao econtrado");
    }
    //Remover Pedido: Crie um endpoint que permita aos clientes remover um determinado pedido.
        public void removerPedidoPorId(Long id){
        pedidoRepository.deleteById(id);
        }
}
