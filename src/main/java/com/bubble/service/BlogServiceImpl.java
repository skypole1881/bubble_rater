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
import com.bubble.po.Condition;
import com.bubble.po.Rating;
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
		setSweetNess(b);
		calculatePR();
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
	
	@Override
	public List<Blog> setLatest(List<Blog> dtos) {
		Date now = new Date();
		for (Blog blog : dtos) {
			if (now.getTime() - blog.getCreatedDtm().getTime() >= 14 * 24 * 60 * 60 * 1000) {
				blog.setLatest(false);
			} else {
				blog.setLatest(true);
			}
		}
		return dtos;
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
		setSweetNess(b);
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
	public List<Object> queryKeyWord(String first, String second) {
		List<Object> dtos = new ArrayList<>();
		Boolean cold;
		// my update
		if(!first.trim().equals("")) {
			if(first.equals("cold")) {
				cold = true;
			}else {
				cold = false;
			}
			switch (second) {
			case "city":
				dtos = blogRepo.queryKeyWordByStoreCityWithCold(cold);
				break;
			case "district":
				dtos = blogRepo.queryKeyWordByDistrictWithCold(cold);
				break;
			case "store":
				dtos = blogRepo.queryKeyWordByStoreNameWithCold(cold);
				break;
			default:
				dtos = blogRepo.queryKeyWordByStoreNameWithCold(cold);
				break;
			}
		}else {
			switch (second) {
			case "city":
				dtos = blogRepo.queryKeyWordByStoreCity();
				break;
			case "district":
				dtos = blogRepo.queryKeyWordByDistrict();
				break;
			case "store":
				dtos = blogRepo.queryKeyWordByStoreName();
				break;
			default:
				dtos = blogRepo.queryKeyWordByStoreName();
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
	public List<Blog> selectNoKeyword(Condition cdt) {
		if (cdt.getCold().equals("cold")) {
			cdt.setColdBoolean(true);
		} else if (cdt.getCold().equals("hot")) {
			cdt.setColdBoolean(false);
		} else {
				// 連冷熱都沒選
				return blogRepo.selectAllOrderBy(cdt);
		}
		// 只有冷熱
		return blogRepo.selectAllWithCold(cdt);
	}

	@Override
	public List<Blog> selectByKeyword(Condition cdt) {
		// 不管有沒有選btnGroup1, 都是只搜尋店名, 在選冷熱飲已做過onchange選單管理
		return blogRepo.selectAllByKeyword(cdt);
	}

	@Override
	public List<Blog> selectAllByCity(Condition cdt) {
		if (cdt.getCold().equals("cold")) {
			cdt.setColdBoolean(true);
		} else if (cdt.getCold().equals("hot")) {
			cdt.setColdBoolean(false);
		} else {
			return blogRepo.selectAllByCity(cdt);
		}

		return blogRepo.selectAllByCityWithCold(cdt);
	}

	@Override
	public List<Blog> selectAllByDistrict(Condition cdt) {
		if (cdt.getCold().equals("cold")) {
			cdt.setColdBoolean(true);
		} else if (cdt.getCold().equals("hot")) {
			cdt.setColdBoolean(false);
		} else {
			return blogRepo.selectAllByDistrict(cdt);
		}

		return blogRepo.selectAllByDistrictWithCold(cdt);
	}

	@Override
	public List<Blog> selectAllByName(Condition cdt) {
		if (cdt.getCold().equals("cold")) {
			cdt.setColdBoolean(true);
		} else if (cdt.getCold().equals("hot")) {
			cdt.setColdBoolean(false);
		} else {
			return blogRepo.selectAllByName(cdt);
		}

		return blogRepo.selectAllByNameWithCold(cdt);
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
	public List<Rating> selectRating(String bubbletag) {
		return blogRepo.selectRating(bubbletag);
	}
}
