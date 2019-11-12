package com.bubble.detail.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bubble.detail.model.Detail;
import com.bubble.detail.model.Score;
import com.bubble.detail.repository.DetailRepository;
import com.bubble.util.SysUtil;

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
	public Detail createDetail(Detail detail) throws Exception {
		if (detail.getId() != 0) {
			throw new Exception("Id should be empty");
		}
		if (detail.getScore() == null) {
			throw new Exception("Score can not be empty");
		}
		detail.updateCommonInfo();
		detail = detailRepository.save(detail);
		return detail;

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
		Detail detailById = detailRepository.findById(detail.getId()).orElse(detail);
		BeanUtils.copyProperties(detail, detailById, SysUtil.getNullPropertyNames(detail));
		detailById.updateCommonInfo();
		return detailRepository.save(detailById);
	}

	public void calculateTotalRate() {
		for (Detail detail : detailRepository.findAll()) {
			Score score = detail.getScore();
			if (score != null) {
				Double totalRate = (score.getBubbleRate() + score.getGodFeelingRate() + score.getTeaRate()) / 3;
				score.setTotalRate(totalRate);
				detailRepository.save(detail);
			}
		}
	}

	public synchronized void calculateRate() {
		List<Detail> bubbleRateList = detailRepository.findDetailOrderByRawBubbleRate();
		List<Detail> teaRateList = detailRepository.findDetailOrderByRawTeaRateRate();

		double total = bubbleRateList.size();
		double bubbleIndex = total;
		double teaIndex = total;
		for (Detail detail : bubbleRateList) {
			Score score = detail.getScore();
			if (score != null) {
				score.setBubbleRate((bubbleIndex / total * 5) + 5);
				bubbleIndex--;
				detailRepository.save(detail);
			}
		}
		for (Detail detail : teaRateList) {
			Score score = detail.getScore();
			if (score != null) {
				score.setTeaRate((teaIndex / total * 5) + 5);
				teaIndex--;
				detailRepository.save(detail);
			}
		}
	}

}
