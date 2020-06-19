package br.net.mirante.operadores.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.net.mirante.operadores.dao.IPessoaDAO;
import br.net.mirante.operadores.entity.Pessoa;

@Service
public class PessoaService implements IPessoaService {
	
	private IPessoaDAO pessoaDAO;
	
	@Autowired
	public PessoaService(IPessoaDAO pessoaDAO) {
		this.pessoaDAO = pessoaDAO;
	}

	@Override
	@Transactional
	public List<Pessoa> listarPessoas() {
		return pessoaDAO.listarPessoas();
	}

	@Override
	@Transactional
	public Pessoa buscarPessoa(int id) {
		return pessoaDAO.buscarPessoa(id);
	}

	@Override
	@Transactional
	public void cadastrarPessoa(Pessoa pessoa) {
		pessoaDAO.cadastrarPessoa(pessoa);
	}

	@Override
	@Transactional
	public void deletarPessoa(int id) {
		pessoaDAO.deletarPessoa(id);
	}

}
