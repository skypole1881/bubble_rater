package com.bubble.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bubble.po.Blog;
import com.bubble.po.Condition;

@SuppressWarnings("unchecked")
@Repository
public class BlogRepoImpl implements BlogRepo {
//	@Autowired
//	private SessionFactory sessionFactory = null;
	@Autowired
	private EntityManager entityManager;

	public Session getSession() {
		return entityManager.unwrap(Session.class);
//		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Blog> sixMore(int token) {
		String qry = "from Blog where publish = '1' order by totalRate desc,godfeelingRate";
		return this.getSession().createQuery(qry).setMaxResults(6).setFirstResult(token * 6 + 6).list();
	}
	
	@Override
	public List<Blog> selectAll() {
		String qry = "from Blog";
		return this.getSession().createQuery(qry).list();
	}

	@Override
	public List<Blog> selectAllOrderBy(Condition cdt) {
		String orderby = cdt.getOrderby();
		String qry = "from Blog where publish = '1' order by " + orderby + " desc";
		return this.getSession().createQuery(qry).setFirstResult(cdt.getLimitNumStart())
				.setMaxResults(cdt.getLimitNumEnd()).list();
	}
	
	@Override
	public List<Blog> selectAllWithCold(Condition cdt) {
		String orderby = cdt.getOrderby();
		String qry = "from Blog where publish = '1' and cold = :cold order by " + orderby + " desc";
		return this.getSession().createQuery(qry).setFirstResult(cdt.getLimitNumStart())
				.setMaxResults(cdt.getLimitNumEnd()).setParameter("cold", cdt.getColdBoolean()).list();
	}

	@Override
	public List<Blog> selectAllByCity(Condition cdt) {
		String orderby = cdt.getOrderby();
		String qry = "from Blog where publish = '1' and storeCity = :keyword order by " + orderby + " desc";
		return this.getSession().createQuery(qry).setFirstResult(cdt.getLimitNumStart())
				.setMaxResults(cdt.getLimitNumEnd()).setParameter("keyword", cdt.getKeyword()).list();
	}

	@Override
	public List<Blog> selectAllByCityWithCold(Condition cdt) {
		String orderby = cdt.getOrderby();
		String qry = "from Blog where publish = '1' and storeCity = :keyword and cold = :cold order by " + orderby
				+ " desc";
		return this.getSession().createQuery(qry).setFirstResult(cdt.getLimitNumStart())
				.setMaxResults(cdt.getLimitNumEnd()).setParameter("keyword", cdt.getKeyword())
				.setParameter("cold", cdt.getColdBoolean()).list();
	}

	@Override
	public List<Blog> selectAllByDistrict(Condition cdt) {
		String orderby = cdt.getOrderby();
		String storeDistrict = cdt.getKeyword().trim().split(",")[0];
		String storeCity = cdt.getKeyword().trim().split(",")[1];
		String qry = "from Blog where publish = '1' and storeCity = :storeCity and storeDistrict = :storeDistrict order by "
				+ orderby + " desc";
		return this.getSession().createQuery(qry).setFirstResult(cdt.getLimitNumStart())
				.setMaxResults(cdt.getLimitNumEnd()).setParameter("storeDistrict", storeDistrict)
				.setParameter("storeCity", storeCity).list();
	}

	@Override
	public List<Blog> selectAllByDistrictWithCold(Condition cdt) {
		String orderby = cdt.getOrderby();
		String storeDistrict = cdt.getKeyword().trim().split(",")[0];
		String storeCity = cdt.getKeyword().trim().split(",")[1];
		String qry = "from Blog where publish = '1' and storeCity = :storeCity and storeDistrict = :storeDistrict and cold = :cold order by "
				+ orderby + " desc";
		return this.getSession().createQuery(qry).setFirstResult(cdt.getLimitNumStart())
				.setMaxResults(cdt.getLimitNumEnd()).setParameter("storeDistrict", storeDistrict)
				.setParameter("storeCity", storeCity).setParameter("cold", cdt.getColdBoolean()).list();
	}

	@Override
	public List<Blog> selectAllByName(Condition cdt) {
		String orderby = cdt.getOrderby();
		String qry = "from Blog where publish = '1' and storeBrand = :keyword order by " + orderby + " desc";
		return this.getSession().createQuery(qry).setFirstResult(cdt.getLimitNumStart())
				.setMaxResults(cdt.getLimitNumEnd()).setParameter("keyword", cdt.getKeyword()).list();
	}

	@Override
	public List<Blog> selectAllByNameWithCold(Condition cdt) {
		String orderby = cdt.getOrderby();
		String qry = "from Blog where publish = '1' and storeBrand = :keyword and cold = :cold order by " + orderby
				+ " desc";
		return this.getSession().createQuery(qry).setFirstResult(cdt.getLimitNumStart())
				.setMaxResults(cdt.getLimitNumEnd()).setParameter("keyword", cdt.getKeyword())
				.setParameter("cold", cdt.getColdBoolean()).list();
	}

	@Override
	public List<Blog> selectAllByKeyword(Condition cdt) {
		String orderby = cdt.getOrderby();
		String qry = "from Blog where publish = '1' and storeBrand = :keyword order by " + orderby + " desc";
		return this.getSession().createQuery(qry).setFirstResult(cdt.getLimitNumStart())
				.setMaxResults(cdt.getLimitNumEnd()).setParameter("keyword", cdt.getKeyword()).list();
	}

	@Override
	public List<Object> queryKeyWordByStoreCityWithCold(Boolean cold) {
		String qry = "select DISTINCT storeCity from Blog where publish = '1' and cold=:cold";
		return this.getSession().createQuery(qry).setParameter("cold", cold).list();
	}

	@Override
	public List<Object> queryKeyWordByDistrictWithCold(Boolean cold) {
		String qry = "select DISTINCT b.storeDistrict,b.storeCity from Blog b where publish = '1' and cold=:cold";
		return this.getSession().createQuery(qry).setParameter("cold", cold).list();
	}

	@Override
	public List<Object> queryKeyWordByStoreNameWithCold(Boolean cold) {
		String qry = "select DISTINCT b.storeBrand from Blog b where publish = '1' and cold=:cold";
		return this.getSession().createQuery(qry).setParameter("cold", cold).list();
	}

	@Override
	public List<Object> queryKeyWordByStoreCity() {
		String qry = "select DISTINCT storeCity from Blog where publish = '1'";
		return this.getSession().createQuery(qry).list();
	}

	@Override
	public List<Object> queryKeyWordByDistrict() {
		String qry = "select DISTINCT b.storeDistrict,b.storeCity from Blog b where publish = '1'";
		return this.getSession().createQuery(qry).list();
	}

	@Override
	public List<Object> queryKeyWordByStoreName() {
		String qry = "select DISTINCT b.storeBrand from Blog b where publish = '1'";
		return this.getSession().createQuery(qry).list();
	}

	@Override
	public void updateLatest(Blog blog) {
		this.getSession().update(blog);
	}
}
