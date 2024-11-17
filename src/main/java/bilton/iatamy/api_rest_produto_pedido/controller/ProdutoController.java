package bilton.iatamy.api_rest_produto_pedido.controller;

import bilton.iatamy.api_rest_produto_pedido.entities.Produto;
import bilton.iatamy.api_rest_produto_pedido.service.ProdutoService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/produto")
public class ProdutoController {
    private ProdutoService produtoService;
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping("/adicionar")
    public ResponseEntity<?> adicionarProduto(@RequestBody Produto produto) {
        try {
            Produto prod = produtoService.adicionarProduto(produto);
            return ResponseEntity.ok().body(prod);
        } catch (Exception ex) {
            return new ResponseEntity("Erro de consulta", HttpStatusCode.valueOf(504));
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<?> buscarProduto() {
        try {
            List<Produto> prod = produtoService.listarProdutos();
            return ResponseEntity.ok().body(prod);
        }
        catch (Exception ex) {
            return new ResponseEntity("Erro de consulta", HttpStatusCode.valueOf(504));
        }
    }

@GetMapping("/buscar/{codigo}")
    public ResponseEntity<?> buscarProdutoPorCodigo(@PathVariable Long codigo) {
        try{
            Optional<Produto> prod = produtoService.buscarProdutoPorId(codigo);
            return ResponseEntity.ok().body(prod);

        } catch (Exception ex){
            return new ResponseEntity("Erro de consulta", HttpStatusCode.valueOf(504));
        }

        }
}










