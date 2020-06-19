package br.net.mirante.operadores.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.net.mirante.operadores.service.IPessoaService;
import br.net.mirante.operadores.entity.Pessoa;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PessoaRestController {
	
	private IPessoaService pessoaService;
	
	@Autowired
	public PessoaRestController(IPessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}
	
	@GetMapping("/pessoas")
	public List<Pessoa> lista() {
		return pessoaService.listarPessoas();
	}
	
	@GetMapping("/pessoas/{id}")
	public Pessoa obterPessoa(@PathVariable int id) {
		Pessoa pessoa = pessoaService.buscarPessoa(id);
		
		if(pessoa == null) {
			throw new RuntimeException("Não foi encontrado essa pessoa - " + id);
		}
		
		return pessoa;
	}
	
	@PostMapping("/pessoas")
	public Pessoa cadastrarPessoa(@RequestBody Pessoa pessoa) {
		pessoa.setId(0);
		pessoaService.cadastrarPessoa(pessoa);
		return pessoa;
	}
	
	@PutMapping("/pessoas")
	public Pessoa atualizarPessoa(@RequestBody Pessoa pessoa) {
		pessoaService.cadastrarPessoa(pessoa);
		return pessoa;
	}
	
	@DeleteMapping("/pessoas/{id}")
	public String deletarPessoa(@PathVariable int id) {
		Pessoa pessoa = pessoaService.buscarPessoa(id);	
		if(pessoa == null) {
			throw new RuntimeException("Não foi encontrado essa pessoa - " + id);
		}	
		pessoaService.deletarPessoa(id);
		
		return "Pessoa deletada. Id - " + id;
	}
}
