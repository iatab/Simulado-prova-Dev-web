package bilton.iatamy.api_rest_produto_pedido.controller;

import bilton.iatamy.api_rest_produto_pedido.entities.AlterarPedidoDTO;
import bilton.iatamy.api_rest_produto_pedido.entities.Pedido;
import bilton.iatamy.api_rest_produto_pedido.service.PedidoService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    private PedidoService pedidoService;
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

     @GetMapping("/buscar")
    public ResponseEntity<?> buscarPedidos(){
        try{
            List<Pedido> ped = pedidoService.buscarPedido();
            return ResponseEntity.ok().body(ped);
        } catch (Exception e) {
            return new ResponseEntity("Erro de consulta", HttpStatusCode.valueOf(504));

        }

     }


     @PostMapping("/adicionar")
    public ResponseEntity<?> adicionarPedido(@RequestBody Pedido ped){
        try {
            Pedido p = pedidoService.adicionarPedido(ped);
            return ResponseEntity.ok().body(p);
        }
        catch (Exception e) {
            return new ResponseEntity("Erro de consulta", HttpStatusCode.valueOf(504));
        }
     }



     @PutMapping("/alterar")
    public ResponseEntity<?> alterarPedido(@RequestBody Pedido ped){
        try{
            Pedido p = pedidoService.atualizarPedido(ped);
            return ResponseEntity.ok().body(p);
        }
        catch (Exception e) {
            return new ResponseEntity("Erro de consulta", HttpStatusCode.valueOf(504));
        }
     }

     @PatchMapping("/alterarprodutos/{codigo}")
    public ResponseEntity<?> alterarProdutoPedido(@PathVariable Long codigo, @RequestBody AlterarPedidoDTO pedidoDTO){
        try{
            AlterarPedidoDTO p = pedidoService.alterarProdutodoPedidoPorId(codigo, pedidoDTO);
            return ResponseEntity.ok().body(p);

        } catch (Exception e) {
            return new ResponseEntity("Erro de consulta", HttpStatusCode.valueOf(504));
        }
     }

     @DeleteMapping("/excluir/{codigo}")
    public ResponseEntity<?> excluirPedido(@PathVariable Long codigo){
        try{
            pedidoService.removerPedidoPorId(codigo);
            return ResponseEntity.ok().body("Pedido removido com sucesso");
        } catch (Exception ex) {
            return new ResponseEntity("Erro de consulta", HttpStatusCode.valueOf(504));

        }
     }

}
