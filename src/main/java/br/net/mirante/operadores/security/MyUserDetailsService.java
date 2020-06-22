package br.net.mirante.operadores.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.net.mirante.operadores.dao.OperadorDAO;
import br.net.mirante.operadores.entity.Operador;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	OperadorDAO operadorDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {	
		Operador user = operadorDAO.buscarPorLogin(username);
		
		if(user == null)
			new UsernameNotFoundException("Nao econtrado: " + username);
		
		return new MyUserDetails(user);
	}

}
