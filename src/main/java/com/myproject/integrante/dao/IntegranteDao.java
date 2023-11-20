package com.myproject.integrante.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.myproject.integrante.entity.Integrante;
import com.myproject.integrante.util.HibernateUtil;

public class IntegranteDao {
	
	public void create(Integrante integrante) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the integrante object
			session.persist(integrante);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public List<Integrante> getAll() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			String hql = "FROM Integrante";
            Query<Integrante> query = session.createQuery(hql, Integrante.class);
			return query.list();
		}
	}
	
/* METODO PARA ALTERAR DADOS DE UM INTEGRANTE
 
  	@SuppressWarnings("deprecation")
	public void update(Integrante integrante) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(integrante);
            transaction.commit();
        }
    }
	*/
	 public Integrante getByCpf(String cpf) {
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            String hql = "FROM Integrante WHERE cpf = :cpf";
	            Query<Integrante> query = session.createQuery(hql, Integrante.class);
	            query.setParameter("cpf", cpf);
	            return query.uniqueResult();
	        }
	    }
	
	//METODO PARA EXCLUIR UM INTEGRANTE
	
	 @SuppressWarnings("deprecation")
	public void delete(Integrante integrante) {
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            Transaction transaction = session.beginTransaction();
	            session.delete(integrante);
	            transaction.commit();
	        }
	    }
    
}