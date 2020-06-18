package br.net.mirante.operadores.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import br.net.mirante.operadores.entity.Pessoa;

public class PessoaDAOImpl implements PessoaDAO {
	
private EntityManager entityManager;
	
	@Autowired
	public PessoaDAOImpl(EntityManager entityManager) {		
		this.entityManager = entityManager;
	}

	@Override
	public List<Pessoa> listarPessoas() {
		Session sessaoAtual = entityManager.unwrap(Session.class);		
		List<Pessoa> pessoas = sessaoAtual.createQuery("from Pessoa", Pessoa.class).getResultList();		
		return pessoas;
	}

	@Override
	public Pessoa buscarPessoa(int id) {
		Session sessaoAtual = entityManager.unwrap(Session.class);	
		Pessoa pessoa = sessaoAtual.get(Pessoa.class, id);		
		return pessoa;
	}

	@Override
	public void cadastrarPessoa(Pessoa pessoa) {
		Session sessaoAtual = entityManager.unwrap(Session.class);
		sessaoAtual.saveOrUpdate(pessoa);
	}

	@Override
	public void deletarPessoa(int id) {
		Session sessaoAtual = entityManager.unwrap(Session.class);
		sessaoAtual.createQuery("delete from Pessoa where id =:pessoaId")
			.setParameter("pessoaId", id)
			.executeUpdate();

	}

}
