package br.net.mirante.operadores.dao;

import br.net.mirante.operadores.entity.Telefone;
import java.util.List;

public interface ITelefoneDAO {
	
	public List<Telefone> listarTelefones(int idPessoa);
	public void cadastrarTelefone(Telefone telefone, int idPessoa);
	public void deletarTelefone(int id);
	public Telefone obterTelefone(int id);
}
