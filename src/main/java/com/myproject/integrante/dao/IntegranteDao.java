package com.myproject.integrante.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

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
			return session.createQuery("from integrante", Integrante.class).list();
		}
	}
	
    
}