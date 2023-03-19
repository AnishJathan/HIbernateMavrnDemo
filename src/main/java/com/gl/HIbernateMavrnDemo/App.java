
package com.gl.HIbernateMavrnDemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gl.HIbernateMavrnDemo.config.HibernateConfig;

public class App 
{
	private static SessionFactory factory = HibernateConfig.getSessionFactory();
	public static void main( String[] args )
	{
		Pojo a1 = new Pojo();
		a1.setId(1);
		a1.setF_Name("Anish");
		a1.setL_Name("Jathan");
		a1.setEmail("anish@gmail.com");
		Pojo pro = getPojoById(200);
		System.out.println("********");
		Pojo proxy = loadPojoById(2000);
		System.out.println(proxy.getId());
		System.out.println(proxy.getClass().getName());
	}
	// save or persist
	public static int insertAuthor(Pojo pojo)
	{
		// Create a session
		// DML commit => transaction
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(pojo);
		tx.commit();
		session.close();
		return pojo.getId();
	}
	/*
	 * 3 states of an object
	 * 1. transient => newly created
	 * 2. persistent => save
	 * 3. detached => after you close the seesion
	 * merge and update
	 */
	public static Pojo updateAuthor(Pojo pojo)
	{
		// Create a session
		// DML commit => transaction
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Pojo updatedAuthor = session.merge(pojo);
		tx.commit();
		session.close();
		return updatedAuthor;
	}
	// remove and delete
	public static void deleteAuthor(Pojo pojo)
	{
		// Create a session
		// DML commit => transaction
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.remove(pojo);
		tx.commit();
		session.close();
	}
	public static Pojo getPojoById(int id)
	{
		Session session = factory.openSession();
		Pojo author = session.get(Pojo.class, id);
		session.close();
		return author;
	}
	public static Pojo loadPojoById(int id)
	{
		Session session = factory.openSession();
		Pojo pojo = new Pojo();

		pojo = session.get(Pojo.class, id);

		session.close();
		return pojo;
	}

	public static List<Pojo> getAllAuthors()
	{
		Session session = factory.openSession();
		// from Author [ java class ]
		List<Pojo> authors = session.createQuery("from Author", Pojo.class).getResultList();
		//List<Author> authors = session.createQuery("select a from Author a", Author.class).getResultList();
		session.close();
		return authors;
	}
}
