package com.library.app.category.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.library.app.category.model.Category;

public class CategoryRepository {

	EntityManager em;

	public Category add(final Category category) {
		em.persist(category);
		return category;
	}

	public Category findById(final Long id) {
		return em.find(Category.class, id);
	}

	public Category findByName(final String name) {
		final Query query = em.createQuery("from Category where name = :name");
		query.setParameter("name", name);
		@SuppressWarnings("unchecked")
		final List<Category> results = query.getResultList();
		return results.get(0);
	}
}
