package br.net.mirante.operadores.service;

import java.util.List;

import br.net.mirante.operadores.entity.Pessoa;

public interface IPessoaService {
	
	public List<Pessoa> listarPessoas();	
	public Pessoa buscarPessoa(int id);
	public void cadastrarPessoa(Pessoa pessoa);
	public void deletarPessoa(int id);

}
