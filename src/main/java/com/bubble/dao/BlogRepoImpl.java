package com.bubble.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bubble.po.Blog;
@Repository
public class BlogRepoImpl implements BlogRepo{
	@Autowired
	private SessionFactory sessionFactory = null;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Blog> sixMore(int token) {
		String qry = "from Blog where publish = '1' order by totalRate desc,godfeelingRate";
		return this.getSession().createQuery(qry).setMaxResults(6).setFirstResult(token*6+6).list();
	}
}
