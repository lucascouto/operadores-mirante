package br.net.mirante.operadores.dao;

import java.util.List;

import br.net.mirante.operadores.entity.Operador;

public interface IOperadorDAO {
	
	public List<Operador> listarOperadores();	
	public Operador buscarOperador(int id);
	public void cadastrarOperador(Operador operador);
	public void deletarOperador(int id);
	public Operador buscarPorLogin(String login);
}
