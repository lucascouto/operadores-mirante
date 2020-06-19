package br.net.mirante.operadores.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.net.mirante.operadores.dao.IOperadorDAO;
import br.net.mirante.operadores.entity.Operador;

@Service
public class OperadorService implements IOperadorService {
	
	private IOperadorDAO operadorDAO;
	
	@Autowired
	public OperadorService(IOperadorDAO operadorDAO) {
		this.operadorDAO = operadorDAO;
	}

	@Override
	@Transactional
	public List<Operador> listarOperadores() {
		return operadorDAO.listarOperadores();
	}

	@Override
	@Transactional
	public Operador buscarOperador(int id) {
		return operadorDAO.buscarOperador(id);
	}

	@Override
	@Transactional
	public void cadastrarOperador(Operador operador) {
		operadorDAO.cadastrarOperador(operador);
	}

	@Override
	@Transactional
	public void deletarOperador(int id) {
		operadorDAO.deletarOperador(id);

	}

}
