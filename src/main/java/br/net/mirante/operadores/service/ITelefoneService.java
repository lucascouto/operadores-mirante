package br.net.mirante.operadores.service;

import java.util.List;

import br.net.mirante.operadores.entity.Telefone;

public interface ITelefoneService {
	
	public List<Telefone> listarTelefones(int idPessoa);
	public void cadastrarTelefone(Telefone telefone, int idPessoa);
	public void deletarTelefone(int id);
	public Telefone obterTelefone(int id);

}
