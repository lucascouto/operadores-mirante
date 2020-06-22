package br.net.mirante.operadores.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.hibernate.*;

import br.net.mirante.operadores.entity.Operador;

@Repository
public class OperadorDAO implements IOperadorDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public OperadorDAO(EntityManager entityManager) {		
		this.entityManager = entityManager;
	}

	@Override
	public List<Operador> listarOperadores() {
		
		Session sessaoAtual = entityManager.unwrap(Session.class);		
		List<Operador> operadores = sessaoAtual.createQuery("from Operador", Operador.class).getResultList();		
		return operadores;
	}

	@Override
	public Operador buscarOperador(int id) {
		
		Session sessaoAtual = entityManager.unwrap(Session.class);	
		Operador operador = sessaoAtual.get(Operador.class, id);		
		return operador;
	}

	@Override
	public void cadastrarOperador(Operador operador) {
		Session sessaoAtual = entityManager.unwrap(Session.class);		
		sessaoAtual.saveOrUpdate(operador);
		
	}

	@Override
	public void deletarOperador(int id) {		
		Session sessaoAtual = entityManager.unwrap(Session.class);
		sessaoAtual.createQuery("delete from Operador where id =:operadorId")
			.setParameter("operadorId", id)
			.executeUpdate();
	}

	@Override
	@Transactional
	public Operador buscarPorLogin(String login) {
		Session sessaoAtual = entityManager.unwrap(Session.class);
		Operador operador = sessaoAtual.createQuery("from Operador where login =:login", Operador.class)
			.setParameter("login", login)
			.getSingleResult();
		return operador;
	}
}
