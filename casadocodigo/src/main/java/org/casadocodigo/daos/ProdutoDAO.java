package org.casadocodigo.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.casadocodigo.model.Produto;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ProdutoDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void gravar(Produto produto) {
		em.persist(produto);
	}
}
