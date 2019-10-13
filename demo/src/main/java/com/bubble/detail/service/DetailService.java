package com.bubble.detail.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bubble.detail.model.Detail;
import com.bubble.detail.repository.DetailRepository;

@Service
public class DetailService {

	@Autowired
	private DetailRepository detailRepository;

	public Optional<Detail> getDetail(Integer id) {
		return detailRepository.findById(id);
	}

	public List<Detail> queryDetail(Integer pageNo, Integer pageSize, String sortBy, String criteritera) {

		int limitStart = 0;
		int limitEnd = 10;
		if (sortBy == null) {
			sortBy = "id";
		}
		if (criteritera == null) {
			criteritera = "";
		}

		if (pageNo != null && pageSize != null) {
			limitStart = (pageSize) * (pageNo - 1);
			limitEnd = pageSize;
		}
		return detailRepository.queryDetail(criteritera, sortBy, limitStart, limitEnd);
	}

	@Transactional
	public Detail createDetail(Detail detail) {
		return detailRepository.save(detail);

	}

	@Transactional
	public void deleteDetail(Integer id) {
		detailRepository.deleteById(id);

	}

	@Transactional
	public Detail updateDetail(Detail detail) throws Exception {
		if (detail.getId() == 0) {
			throw new Exception("Id can not be empty");
		}
		if (detail.getScore() != null) {
			if (detail.getScore().getId() == 0) {
				throw new Exception("Score Id can not be empty");
			}
		} else {
			throw new Exception("Score can not be empty");
		}
		return detailRepository.save(detail);
	}

}
