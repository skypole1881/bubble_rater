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
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bubble.NotFoundException;
import com.bubble.dao.BlogRepo;
import com.bubble.dao.BlogRepository;
import com.bubble.po.Blog;
import com.bubble.util.MyBeanUtils;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {
	@Autowired
	private BlogRepo blogRepo;

	@Autowired
	private BlogRepository blogRepository;

	@Override
	public Blog getBlog(Integer id) {
		// TODO Auto-generated method stub
		return blogRepository.findOne(id);
	}

	@Override
	public Page<Blog> listBlog(Pageable pageable, Blog blog) {
		return blogRepository.findAll(new Specification<Blog>() {
			@Override
			public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<>();
				if (!"".equals(blog.getTitle()) && blog.getTitle() != null) {
					predicates.add(cb.like(root.<String>get("title"), "%" + blog.getTitle() + "%"));
				}
				cq.where(predicates.toArray(new Predicate[predicates.size()]));
				return null;
			}
		}, pageable);
	}

	@Override
	public Page<Blog> listBlog(Pageable pageable) {
		return blogRepository.findAll(pageable);
	}

	@Override
	public Long countBlog() {
		return blogRepository.count();
	}

	@Override
	public Blog saveBlog(Blog blog) {
		Blog b;
		blog.setCreatedDtm(new Date());
		blog.setLastModifiedDtm(new Date());
		blog.setVersion(0);
		b = blogRepository.save(blog);
		setSweetNess(blog);
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

	private void setSweetNess(Blog blog) {

		if (blog.getSweetnessRate() == 10) {
			blog.setSweetness("甜膩");
		} else if (blog.getSweetnessRate() == 9) {
			blog.setSweetness("偏甜");
		} else if (blog.getSweetnessRate() == 7 || blog.getSweetnessRate() == 8) {
			blog.setSweetness("中等");
		} else {
			blog.setSweetness("清淡");
		}
		blogRepository.save(blog);
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
		setSweetNess(blog);
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
	public List<Blog> selectSixMoreOnly(Integer token) {
		List<Blog> dtos = new ArrayList<>();
		dtos = blogRepo.sixMore(token);
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
				dtos = blogRepository.queryKeyWordByStoreNameWithCold(cold);
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
				dtos = blogRepository.queryKeyWordByStoreNameWithCold(cold);
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
				dtos = blogRepository.queryKeyWordByStoreName();
				break;
			}
		}
		return dtos;
	}

	@Override
	public List<Blog> selectDefault() {

		return blogRepository.queryKeyWordByStoreName();
	}

	@Override
	public List<Blog> selectAllByKeywordByCity(String keyword, String cold, String orderby, Integer limitNumStart,
			Integer limitNumEnd) {
		Boolean coldBoolean = true;
		Pageable pageable = null;
		Sort sort = new Sort(Sort.Direction.DESC, orderby);
		pageable = new PageRequest(limitNumStart, limitNumEnd, sort);
		if (cold.equals("cold")) {
			coldBoolean = true;
		} else if (cold.equals("hot")) {
			coldBoolean = false;
		} else {
			return blogRepository.selectAllByKeywordByCity(keyword, pageable);
		}

		return blogRepository.selectAllByKeywordByCityWithCold(keyword, coldBoolean, pageable);
	}

	@Override
	public List<Blog> selectAllByKeywordByDistrict(String keyword, String cold, String orderby, Integer limitNumStart,
			Integer limitNumEnd) {
		String[] oriString = keyword.split(",");
		Boolean coldBoolean = true;
		Pageable pageable = null;
		Sort sort = new Sort(Sort.Direction.DESC, orderby);
		pageable = new PageRequest(limitNumStart, limitNumEnd, sort);
		if (cold.equals("cold")) {
			coldBoolean = true;
		} else if (cold.equals("hot")) {
			coldBoolean = false;
		} else {
			return blogRepository.selectAllByKeywordByDistrict(oriString[0], pageable);
		}

		return blogRepository.selectAllByKeywordByDistrictWithCold(oriString[0], coldBoolean, pageable);
	}

	@Override
	public List<Blog> selectAllByKeywordByName(String keyword, String cold, String orderby, Integer limitNumStart,
			Integer limitNumEnd) {
		Boolean coldBoolean = true;
		Pageable pageable = null;
		Sort sort = new Sort(Sort.Direction.DESC, orderby);
		pageable = new PageRequest(limitNumStart, limitNumEnd, sort);
		if (cold.equals("cold")) {
			coldBoolean = true;
		} else if (cold.equals("hot")) {
			coldBoolean = false;
		} else {
			return blogRepository.selectAllByKeywordByName(keyword, pageable);
		}

		return blogRepository.selectAllByKeywordByNameWithCold(keyword, coldBoolean, pageable);
	}

	@Override
	public List<Blog> selectAllByCriteriaByName(String criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getRank(String id) {
		List<Blog> dtos = blogRepository.selectBlogOrderByTotalRate();
		Integer rank = 0;
		for (int i = 0; i < dtos.size(); i++) {
			if (dtos.get(i).getBlogId() == Integer.valueOf(id)) {
				rank = i + 1;
			}
		}
		return rank;
	}

	@Override
	public List<Blog> selectBlogsByCold(String cold, String orderby, Integer limitNumStart, Integer limitNumEnd) {
		Sort sort = new Sort(Sort.Direction.DESC, orderby);
		Pageable pageable = new PageRequest(limitNumStart, limitNumEnd, sort);
		Boolean coldBoolean = true;
		if (cold.equals("cold")) {
			coldBoolean = true;
		} else if (cold.equals("hot")) {
			coldBoolean = false;
		} else {
			// 全部沒有只有排序
			return blogRepository.selectAllWithOrder(pageable);
		}
		// 只有冷熱
		return blogRepository.selectAllWithColdAndOrder(coldBoolean, pageable);
	}

}
