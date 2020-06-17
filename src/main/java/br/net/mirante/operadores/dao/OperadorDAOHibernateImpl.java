package br.net.mirante.operadores.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public List<Operador> listarOperadores() {
		
		Session sessaoAtual = entityManager.unwrap(Session.class);
		
		List<Operador> operadores = sessaoAtual.createQuery("from Operador", Operador.class).getResultList();
		
		return operadores;
	}

	

}
