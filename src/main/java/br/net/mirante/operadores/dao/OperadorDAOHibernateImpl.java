package br.net.mirante.operadores.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.hibernate.*;

import br.net.mirante.operadores.entity.Operador;

@Repository
public class OperadorDAOHibernateImpl implements OperadorDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public OperadorDAOHibernateImpl(EntityManager entityManager) {		
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

	

}
