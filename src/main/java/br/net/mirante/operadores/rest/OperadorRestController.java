package br.net.mirante.operadores.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import br.net.mirante.operadores.dao.OperadorDAO;
import br.net.mirante.operadores.entity.Operador;

@RestController
@RequestMapping("/api")
public class OperadorRestController {
	
	private OperadorDAO operadorDAO;
	
	@Autowired
	public OperadorRestController(OperadorDAO operadorDAO) {
		this.operadorDAO = operadorDAO;
	}
	
	@GetMapping("/operadores")
	public List<Operador> lista() {
		return operadorDAO.listarOperadores();
	}
	

}
