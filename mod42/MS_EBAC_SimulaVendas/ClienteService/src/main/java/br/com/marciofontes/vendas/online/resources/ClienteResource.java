/**
 *
 */
package br.com.marciofontes.vendas.online.resources;

import br.com.marciofontes.vendas.online.domain.Cliente;
import br.com.marciofontes.vendas.online.usecase.BuscaCliente;
import br.com.marciofontes.vendas.online.usecase.CadastroCliente;
import io.swagger.v3.oas.annotations.Operation;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/cliente")
public class ClienteResource {

	private BuscaCliente buscaCliente;
	private CadastroCliente cadastroCliente;

	@Autowired
	public ClienteResource(BuscaCliente buscaCliente,
						   CadastroCliente cadastroCliente) {
		this.buscaCliente = buscaCliente;
		this.cadastroCliente = cadastroCliente;
	}

	@GetMapping
	public ResponseEntity<Page<Cliente>> buscar(Pageable pageable) {
		try {
			return ResponseEntity.ok(buscaCliente.buscar(pageable));
		} catch (Exception e) {
			// Registre a exceção ou envie uma resposta apropriada ao usuário.
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping(value = "/{id}")
	@Operation(summary = "Busca um cliente pelo id")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable(value = "id", required = true) String id) {
		try {
			return ResponseEntity.ok(buscaCliente.buscarPorId(id));
		} catch (Exception e) {
			// Registre a exceção ou envie uma resposta apropriada ao usuário.
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping(value = "isCadastrado/{id}")
	public ResponseEntity<Boolean> isCadastrado(@PathVariable(value = "id", required = true) String id) {
		try {
			return ResponseEntity.ok(buscaCliente.isCadastrado(id));
		} catch (Exception e) {
			// Registre a exceção ou envie uma resposta apropriada ao usuário.
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping
	public ResponseEntity<Cliente> cadastar(@RequestBody @Valid Cliente cliente) {
		try {
			return ResponseEntity.ok(cadastroCliente.cadastrar(cliente));
		} catch (Exception e) {
			// Registre a exceção ou envie uma resposta apropriada ao usuário.
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping(value = "/cpf/{cpf}")
	@Operation(summary = "Busca um cliente pelo cpf")
	public ResponseEntity<Cliente> buscarPorCpf(@PathVariable(value = "cpf", required = true) Long cpf) {
		try {
			return ResponseEntity.ok(buscaCliente.buscarPorCpf(cpf));
		} catch (Exception e) {
			// Registre a exceção ou envie uma resposta apropriada ao usuário.
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping
	@Operation(summary = "Atualiza um cliente")
	public ResponseEntity<Cliente> atualizar(@RequestBody @Valid Cliente cliente) {
		try {
			return ResponseEntity.ok(cadastroCliente.atualizar(cliente));
		} catch (Exception e) {
			//
			// Registre a exceção ou envie uma resposta apropriada ao usuário.
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Remove um cliente pelo seu identificador único")
	public ResponseEntity<String> remover(@PathVariable(value = "id") String id) {
		try {
			cadastroCliente.remover(id);
			return ResponseEntity.ok("Removido com sucesso");
		} catch (Exception e) {
			// Registre a exceção ou envie uma resposta apropriada ao usuário.
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}}