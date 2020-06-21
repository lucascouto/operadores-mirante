package br.net.mirante.operadores.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

import br.net.mirante.operadores.entity.Operador;
import br.net.mirante.operadores.security.MyUserDetailsService;
import br.net.mirante.operadores.security.model.AuthenticationRequest;
import br.net.mirante.operadores.security.model.AuthenticationResponse;
import br.net.mirante.operadores.security.util.JwtUtil;
import br.net.mirante.operadores.service.IOperadorService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class OperadorRestController {
	
	private IOperadorService operadorService;
	private AuthenticationManager autheticationManager;
	private MyUserDetailsService userDetailsService;
	private JwtUtil jwtUtil;
	
	@Autowired
	public OperadorRestController(
			IOperadorService operadorService, 
			AuthenticationManager autheticationManager, 
			MyUserDetailsService userDetailsService,
			JwtUtil jwtUtil
		) {
		this.operadorService = operadorService;
		this.autheticationManager = autheticationManager;
		this.userDetailsService = userDetailsService;
		this.jwtUtil = jwtUtil;
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAutheticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		try {
			autheticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}
		
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());
		
		final String jwt = jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
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
		operador.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		operadorService.cadastrarOperador(operador);		
		return operador;
	}
	
	@PutMapping("/operadores")
	public Operador atualizarOperador(@RequestBody Operador operador) {		
		operador.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		operadorService.cadastrarOperador(operador);
		return operador;
	}
	
	@DeleteMapping("/operadores/{id}")
	public Operador deletarOperador(@PathVariable int id) {
		Operador operador = operadorService.buscarOperador(id);
		if(operador == null) {
			throw new RuntimeException("Operador não econtrado " + id);
		}
		operadorService.deletarOperador(id);
		
		return operador;
		
	}
	
}
