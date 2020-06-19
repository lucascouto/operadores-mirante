package br.net.mirante.operadores.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.net.mirante.operadores.dao.ITelefoneDAO;
import br.net.mirante.operadores.entity.Telefone;

@Service
public class TelefoneService implements ITelefoneService {
	
	private ITelefoneDAO telefoneDAO;
	
	@Autowired
	public TelefoneService(ITelefoneDAO telefoneDAO) {
		this.telefoneDAO = telefoneDAO;
	}
	
	@Override
	@Transactional
	public List<Telefone> listarTelefones(int idPessoa) {
		return telefoneDAO.listarTelefones(idPessoa);	
	}

	@Override
	@Transactional
	public void cadastrarTelefone(Telefone telefone, int idPessoa) {
		telefoneDAO.cadastrarTelefone(telefone, idPessoa);
	}

	@Override
	@Transactional
	public void deletarTelefone(int id) {
		telefoneDAO.deletarTelefone(id);
	}

	@Override
	@Transactional
	public Telefone obterTelefone(int id) {
		return telefoneDAO.obterTelefone(id);
	}

}
