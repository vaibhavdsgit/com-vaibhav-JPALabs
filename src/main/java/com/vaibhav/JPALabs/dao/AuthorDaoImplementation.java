package com.vaibhav.JPALabs.dao;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;

import com.vaibhav.JPALabs.entities.Author;

public class AuthorDaoImplementation implements AuthorDao{
	private EntityManager entityManager;
	public AuthorDaoImplementation()
	{
		entityManager = JPAUtil.getEntityManager();
	}

	@Override
	public Author getAuthorByAuthorId(int id) 
	{
		Author author = entityManager.find(Author.class, id);
		System.out.println("getEmployeeById in EmployeeDaoImpl");
		return author;
	}

	@Override
	public void addAuthor(Author author) throws EntityExistsException
	{
		entityManager.persist(author);		
	}

	@Override
	public void removeAuthor(Author author) {
		entityManager.remove(author);
	}

	@Override
	public void updateAuthor(Author author) {
		entityManager.merge(author);
	}

	@Override
	public void beginTransaction() {
		entityManager.getTransaction().begin();
	}

	@Override
	public void commitTransaction() {
		entityManager.getTransaction().commit();
	}
}
