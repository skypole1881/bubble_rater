package com.bubble.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.bubble.NotFoundException;
import com.bubble.dao.BlogRepository;
import com.bubble.po.Blog;
import com.bubble.util.MyBeanUtils;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogRepository blogRepository;

	@Override
	public Blog getBlog(Integer id) {
		// TODO Auto-generated method stub
		return blogRepository.findOne(id);
	}

//	@Transactional
//	@Override
//	public Blog getAndConvert(Long id) {
//		Blog blog = blogRepository.findOne(id);
//		if (blog == null) {
//			throw new NotFoundException("该博客不存在");
//		}
//		Blog b = new Blog();
//		BeanUtils.copyProperties(blog, b);
//		String content = b.getContent();
//		b.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
//
//		blogRepository.updateViews(id);
//		return b;
//	}

	@Override
	public Page<Blog> listBlog(Pageable pageable, Blog blog) {
		return blogRepository.findAll(new Specification<Blog>() {
			@Override
			public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<>();
				if (!"".equals(blog.getTitle()) && blog.getTitle() != null) {
					predicates.add(cb.like(root.<String>get("title"), "%" + blog.getTitle() + "%"));
				}
//				if (blog.getTypeId() != null) {
//					predicates.add(cb.equal(root.<Type>get("type").get("id"), blog.getTypeId()));
//				}
//				if (blog.isRecommend()) {
//					predicates.add(cb.equal(root.<Boolean>get("recommend"), blog.isRecommend()));
//				}
				cq.where(predicates.toArray(new Predicate[predicates.size()]));
				return null;
			}
		}, pageable);
	}

	@Override
	public Page<Blog> listBlog(Pageable pageable) {
		return blogRepository.findAll(pageable);
	}

//	@Override
//	public List<Blog> selectAllByCriteria(String criteria,String orderBy) {
//		List<Blog> dtos = new ArrayList<>();
//		dtos = blogRepository.selectBlogByCriteriaStoreCityAndOrder(criteria,orderBy);
//		return dtos;
//	}
//	@Override
//	public Page<Blog> listBlog(Long tagId, Pageable pageable) {
//		return blogRepository.findAll(new Specification<Blog>() {
//			@Override
//			public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
//				Join join = root.join("tags");
//				return cb.equal(join.get("id"), tagId);
//			}
//		}, pageable);
//	}
//
//	@Override
//	public Page<Blog> listBlog(String query, Pageable pageable) {
//		return blogRepository.findByQuery(query, pageable);
//	}

//	@Override
//	public List<Blog> listRecommendBlogTop(Integer size) {
//		Sort sort = new Sort(Sort.Direction.DESC, "updateTime");
//		Pageable pageable = new PageRequest(0, size, sort);
//		return blogRepository.findTop(pageable);
//	}

//	@Override
//	public Map<String, List<Blog>> archiveBlog() {
//		List<String> years = blogRepository.findGroupYear();
//		Map<String, List<Blog>> map = new HashMap<>();
//		for (String year : years) {
//			map.put(year, blogRepository.findByYear(year));
//		}
//		return map;
//	}

	@Override
	public Long countBlog() {
		return blogRepository.count();
	}

//	@Transactional
//	@Override
//	public Blog saveBlog(Blog blog) {
//		if (blog.getId() == null) {
//			blog.setCreateTime(new Date());
//			blog.setUpdateTime(new Date());
//			blog.setViews(0);
//		} else {
//			blog.setUpdateTime(new Date());
//		}
//		return blogRepository.save(blog);
//	}

//	@Override
//	public Blog updateBlog(Integer id, Blog blog) {
//		Blog b = blogRepository.findOne(id);
//		if (b == null) {
//			throw new NotFoundException("该博客不存在");
//		}
//		BeanUtils.copyProperties(blog, b, MyBeanUtils.getNullPropertyNames(blog));
//		b.setUpdateTime(new Date());
//		return blogRepository.save(b);
//	}

	@Override
	public Blog saveBlog(Blog blog) {
		Blog b;
		blog.setCreatedDtm(new Date());
		blog.setLastModifiedDtm(new Date());
		blog.setVersion(0);
		b = blogRepository.save(blog);
		calculatePR();
		setLatest();
		calculateTotal();

		// TODO Auto-generated method stub
		return b;
	}

	private void calculateTotal() {
		List<Blog> BubbleRateList = new ArrayList<Blog>();
		BubbleRateList.addAll(blogRepository.selectBlogOrderByBubbleRate());
		for (Blog blog : BubbleRateList) {
			float totalRate;
			totalRate = (blog.getBubbleRatePR() + blog.getGodfeelingRate() + blog.getTeaRatePR()) / 3;
			blogRepository.updateTotalRate(totalRate, blog.getBlogId());
		}
	}

	private void calculatePR() {
		List<Blog> BubbleRateList = new ArrayList<Blog>();
		List<Blog> TeaRateList = new ArrayList<Blog>();
		BubbleRateList.addAll(blogRepository.selectBlogOrderByBubbleRate());
		TeaRateList.addAll(blogRepository.selectBlogOrderByTeaRate());
		float total = BubbleRateList.size();
		float index = total;
		float indexTea = total;
		for (Blog blog : BubbleRateList) {
			blog.setBubbleRatePR((index / total * 5) + 5);
			index--;
			blogRepository.updateBubbleRatePR(blog.getBubbleRatePR(), blog.getBlogId());
		}
		for (Blog blog : TeaRateList) {
			blog.setTeaRatePR((indexTea / total * 5) + 5);
			indexTea--;
			blogRepository.updateTeaRatePR(blog.getTeaRatePR(), blog.getBlogId());
		}

	}

	private void setLatest() {
		List<Blog> blogsList = new ArrayList<Blog>();
		blogsList.addAll(blogRepository.selectBlogOrderByCreatedTime());
		for (Blog blog : blogsList) {
			if (new Date().getTime() - blog.getCreatedDtm().getTime() >= 7 * 24 * 60 * 60 * 1000) {
				blog.setLatest(false);
			} else {
				blog.setLatest(true);
			}
			blogRepository.updateLatest(blog.isLatest(), blog.getBlogId());
		}

	}

	@Override
	public Blog updateBlog(Integer id, Blog blog) {
		Blog b = blogRepository.findOne(id);
		if (b == null) {
			throw new NotFoundException("not exist");
		}
		BeanUtils.copyProperties(blog, b, MyBeanUtils.getNullPropertyNames(blog));
		b.setLastModifiedDtm(new Date());
		b.setVersion(blog.getVersion() + 1);
		b = blogRepository.save(b);
		setLatest();
		calculatePR();
		calculateTotal();
		return b;
	}

	@Override
	public void deleteBlog(Integer id) {
		blogRepository.delete(id);

	}

	@Override
	public Page<Blog> listBlog(String query, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Blog> listRecommendBlogTop(Integer size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, List<Blog>> archiveBlog() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Blog getAndConvert(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Blog> selectAllByCriteriaByCity(String criteria) {
		List<Blog> dtos = new ArrayList<>();
		dtos = blogRepository.selectAllByCriteriaByCity(criteria);
		return dtos;
	}

	@Override
	public List<Blog> selectAllByCriteriaByDistrict(String criteria) {
		List<Blog> dtos = new ArrayList<>();
		dtos = blogRepository.selectAllByCriteriaByDistrict(criteria);
		return dtos;
	}

	@Override
	public List<Blog> selectAllByCriteriaByName(String criteria) {
		List<Blog> dtos = new ArrayList<>();
		dtos = blogRepository.selectAllByCriteriaByName(criteria);
		return dtos;
	}

	@Override
	public List<Blog> selectAllByCriteria(String criteria, String orderBy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Blog> selectTopTwelve() {
		List<Blog> dtos = new ArrayList<>();
		Pageable pageable = new PageRequest(0, 12);
		dtos = blogRepository.selectTopTwelveBlogOrderByTotalRate(pageable);
		return dtos;
	}

	@Override
	public List<Blog> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Blog> selectSixMore(Integer token) {
		List<Blog> dtos = new ArrayList<>();
		Integer limitNumber = token * 6 + 12;
		Pageable pageable = new PageRequest(0, limitNumber);
		dtos = blogRepository.selectSixMore(pageable);
		return dtos;
	}

	@Override
	public Integer countAllBlog() {
		Integer count = blogRepository.countBlog();
		return count;
	}

	@Override
	public List<Blog> query(String firstTwoCharacters) {

		return blogRepository.queryCity(firstTwoCharacters);
	}

	@Override
	public List<Blog> queryKeyWord(String first, String second) {
		List<Blog> dtos = new ArrayList<>();
		Boolean cold;
		if (first.equals("cold")) {
			cold = true;
			switch (second) {
			case "city":
				dtos = blogRepository.queryKeyWordByStoreCityWithCold(cold);
				break;
			case "district":
				dtos = blogRepository.queryKeyWordByDistrictWithCold(cold);
				break;
			case "store":
				dtos = blogRepository.queryKeyWordByStoreNameWithCold(cold);
				break;
			default:
				break;
			}
		} else if (first.equals("hot")) {
			cold = false;
			switch (second) {
			case "city":
				dtos = blogRepository.queryKeyWordByStoreCityWithCold(cold);
				break;
			case "district":
				dtos = blogRepository.queryKeyWordByDistrictWithCold(cold);
				break;
			case "store":
				dtos = blogRepository.queryKeyWordByStoreNameWithCold(cold);
				break;
			default:
				break;
			}
		} else {
			switch (second) {
			case "city":
				dtos = blogRepository.queryKeyWordByStoreCity();
				break;
			case "district":
				dtos = blogRepository.queryKeyWordByDistrict();
				break;
			case "store":
				dtos = blogRepository.queryKeyWordByStoreName();
				break;
			default:
				break;
			}
		}

		return dtos;
	}

}
