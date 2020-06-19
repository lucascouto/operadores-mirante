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

import java.util.List;

import br.net.mirante.operadores.entity.Operador;
import br.net.mirante.operadores.service.IOperadorService;

@RestController
@RequestMapping("/api")
public class OperadorRestController {
	
	private IOperadorService operadorService;
	
	@Autowired
	public OperadorRestController(IOperadorService operadorService) {
		this.operadorService = operadorService;
	}
	
	@GetMapping("/operadores")
	public List<Operador> lista() {
		return operadorService.listarOperadores();
	}
	
	@GetMapping("/operadores/{id}")
	public Operador obterOperador(@PathVariable int id) {
		Operador operador = operadorService.buscarOperador(id);
		if(operador == null) {
			throw new RuntimeException("Operador não encontrado - " + id);
		}		
		return operador;
	}
	
	@PostMapping("/operadores")
	public Operador cadastrarOperador(@RequestBody Operador operador) {		
		operador.setId(0);	
		operadorService.cadastrarOperador(operador);		
		return operador;
	}
	
	@PutMapping("/operadores")
	public Operador atualizarOperador(@RequestBody Operador operador) {
		operadorService.cadastrarOperador(operador);
		return operador;
	}
	
	@DeleteMapping("/operadores/{id}")
	public String deletarOperador(@PathVariable int id) {
		Operador operador = operadorService.buscarOperador(id);
		if(operador == null) {
			throw new RuntimeException("Operador não econtrado " + id);
		}
		operadorService.deletarOperador(id);
		
		return "Operador deletado. Id - " + id;
		
	}
	
	
	

}
