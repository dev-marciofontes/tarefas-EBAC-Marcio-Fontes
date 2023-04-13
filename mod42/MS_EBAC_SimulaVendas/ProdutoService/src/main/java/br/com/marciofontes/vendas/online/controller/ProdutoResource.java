/**
 *
 */
package br.com.marciofontes.vendas.online.controller;

import br.com.marciofontes.vendas.online.domain.Produto;
import br.com.marciofontes.vendas.online.domain.Produto.Status;
import br.com.marciofontes.vendas.online.usecase.BuscaProduto;
import br.com.marciofontes.vendas.online.usecase.CadastroProduto;
import io.swagger.v3.oas.annotations.Operation;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/produto")
public class ProdutoResource {

    private BuscaProduto buscaProduto;

    private CadastroProduto cadastroProduto;

    @Autowired
    public ProdutoResource(BuscaProduto buscaProduto,
                           CadastroProduto cadastroProduto) {
        this.buscaProduto = buscaProduto;
        this.cadastroProduto = cadastroProduto;
    }

    @GetMapping
    @Operation(summary = "Busca uma lista paginada de produtos")
    public ResponseEntity<Page<Produto>> buscar(Pageable pageable) {
        try {
            return ResponseEntity.ok(buscaProduto.buscar(pageable));
        } catch (Exception e) {
            // Registre a exceção ou envie uma resposta apropriada ao usuário.
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(value = "/status/{status}")
    @Operation(summary = "Busca uma lista paginada de produtos por status")
    public ResponseEntity<Page<Produto>> buscarPorStatus(Pageable pageable,
                                                         @PathVariable(value = "status", required = true) Status status) {
        try {
            return ResponseEntity.ok(buscaProduto.buscar(pageable, status));
        } catch (Exception e) {
            // Registre a exceção ou envie uma resposta apropriada ao usuário.
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(value = "/{codigo}")
    @Operation(summary = "Busca um produto pelo codigo")
    public ResponseEntity<Produto> buscarPorCodigo(String codigo) {
        try {
            return ResponseEntity.ok(buscaProduto.buscarPorCodigo(codigo));
        } catch (Exception e) {
            // Registre a exceção ou envie uma resposta apropriada ao usuário.
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    @Operation(summary = "Cadastrar um produto")
    public ResponseEntity<Produto> cadastrar(@RequestBody @Valid Produto produto) {
        try {
            return ResponseEntity.ok(cadastroProduto.cadastrar(produto));
        } catch (Exception e) {
            // Registre a exceção ou envie uma resposta apropriada ao usuário.
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping
    @Operation(summary = "Atualiza um produto")
    public ResponseEntity<Produto> atualizar(@RequestBody @Valid Produto produto) {
        try {
            return ResponseEntity.ok(cadastroProduto.atualizar(produto));
        } catch (Exception e) {
            // Registre a exceção ou envie uma resposta apropriada ao usuário.
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Remove um produto pelo seu identificador único")
    public ResponseEntity<String> remover(@PathVariable(value = "id") String id) {
        try {
            cadastroProduto.remover(id);
            return ResponseEntity.ok("Removido com sucesso");
        } catch (Exception e) {
            // Registre a exceção ou envie uma resposta apropriada ao usuário.
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
