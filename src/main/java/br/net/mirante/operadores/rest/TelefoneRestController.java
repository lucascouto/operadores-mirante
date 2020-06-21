package br.net.mirante.operadores.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.net.mirante.operadores.service.ITelefoneService;
import br.net.mirante.operadores.entity.Telefone;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class TelefoneRestController {
	
	private ITelefoneService telefoneService;
	
	public TelefoneRestController(ITelefoneService telefoneService) {
		this.telefoneService = telefoneService;
	}

	@GetMapping("/telefones/{idPessoa}")
	public List<Telefone> obterTelefones(@PathVariable int idPessoa) {
		return telefoneService.listarTelefones(idPessoa);
	}
	
	@PostMapping("/telefones/{idPessoa}")
	public Telefone cadastrarTelefone(@RequestBody Telefone telefone, @PathVariable int idPessoa) {
		telefoneService.cadastrarTelefone(telefone, idPessoa);
		return telefone;
	}
	
	@PutMapping("/telefones/{idPessoa}")
	public Telefone atualizarTelefone(@RequestBody Telefone telefone, @PathVariable int idPessoa) {		
		telefoneService.cadastrarTelefone(telefone, idPessoa);
		return telefone;
	}
	
	@DeleteMapping("/telefones/{id}")
	public Telefone deletarTelefone(@PathVariable int id) {
		Telefone telefone = telefoneService.obterTelefone(id);
		if(telefone == null) {
			throw new RuntimeException("Telefone não encontrado - " + id);
		}
		telefoneService.deletarTelefone(id);
		
		return telefone;
	}
}
