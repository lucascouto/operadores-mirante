package br.net.mirante.operadores.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import br.net.mirante.operadores.entity.Operador;
import br.net.mirante.operadores.service.OperadorService;

@RestController
@RequestMapping("/api")
public class OperadorRestController {
	
	private OperadorService operadorService;
	
	@Autowired
	public OperadorRestController(OperadorService operadorService) {
		this.operadorService = operadorService;
	}
	
	@GetMapping("/operadores")
	public List<Operador> lista() {
		return operadorService.listarOperadores();
	}
	

}
