package br.net.mirante.operadores.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.net.mirante.operadores.entity.Pessoa;
import br.net.mirante.operadores.entity.Telefone;

@Repository
public class TelefoneDAO implements ITelefoneDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public TelefoneDAO(EntityManager entityManager) {		
		this.entityManager = entityManager;
	}

	@Override
	public List<Telefone> listarTelefones(int idPessoa) {
		Session sessaoAtual = entityManager.unwrap(Session.class);	
		Pessoa pessoa = sessaoAtual.get(Pessoa.class, idPessoa);
		
		if(pessoa == null) {
			throw new RuntimeException("Pessoa não encontrada " + idPessoa);
		}
		
		return pessoa.getTelefones();
	}

	@Override
	public void cadastrarTelefone(Telefone telefone, int idPessoa) {
		Session sessaoAtual = entityManager.unwrap(Session.class);
		Pessoa pessoa = sessaoAtual.get(Pessoa.class, idPessoa);
		
		if(pessoa == null) {
			throw new RuntimeException("Pessoa não econtrada " + idPessoa);
		}
		
		pessoa.adicionarTelefone(telefone);
		sessaoAtual.saveOrUpdate(telefone);
	}

	@Override
	public void deletarTelefone(int id) {
		Session sessaoAtual = entityManager.unwrap(Session.class);
		Telefone telefone = sessaoAtual.get(Telefone.class, id);
		sessaoAtual.delete(telefone);
	}

	@Override
	public Telefone obterTelefone(int id) {
		Session sessaoAtual = entityManager.unwrap(Session.class);
		Telefone telefone = sessaoAtual.get(Telefone.class, id);
		return telefone;
	}

}
