package com.wyden.banco.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wyden.banco.entity.Cliente;
import com.wyden.banco.util.HibernateUtil;

public class ClienteDao {
	public void create(Cliente cliente) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the cliente object
			session.save(cliente);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public List<Cliente> getAll() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from clientes", Cliente.class).list();
		}
	}
}