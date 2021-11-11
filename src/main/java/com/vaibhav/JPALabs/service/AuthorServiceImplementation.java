package com.vaibhav.JPALabs.service;

import com.vaibhav.JPALabs.dao.AuthorDao;
import com.vaibhav.JPALabs.dao.AuthorDaoImplementation;
import com.vaibhav.JPALabs.entities.Author;

public class AuthorServiceImplementation implements AuthorService{
	private AuthorDao dao;

	public AuthorServiceImplementation() {
		dao = new AuthorDaoImplementation();
	}

	@Override
	public void addAuthor(Author author) {
		dao.beginTransaction();
		try {
			dao.addAuthor(author);
			dao.commitTransaction();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	@Override
	public void updateAuthor(Author author) {
		dao.beginTransaction();
		dao.updateAuthor(author);
		dao.commitTransaction();
	}

	@Override
	public void removeAuthor(Author author) {
		dao.beginTransaction();
		dao.removeAuthor(author);
		dao.commitTransaction();
	}

	@Override
	public Author findAuthorById(int id) {
		Author author;
		author = dao.getAuthorByAuthorId(id);
		System.out.println("findEmployeeById in EmployeeServiceImpl");
		return author;
	}
}
