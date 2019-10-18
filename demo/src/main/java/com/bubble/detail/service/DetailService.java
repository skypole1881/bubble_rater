package com.bubble.detail.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bubble.detail.model.Detail;
import com.bubble.detail.model.Score;
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
	public Detail createDetail(Detail detail) throws Exception {
		if (detail.getId() != 0) {
			throw new Exception("Id should be empty");
		}
		detail = detailRepository.save(detail);
//		calculateRate();
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
		return detailRepository.save(detail);
	}

	private void calculateTotalRate() {
		for (Detail detail : detailRepository.findAll()) {
			Score score = detail.getScore();
			if (score != null) {
				Double totalRate = (score.getBubbleRate() + score.getGodFeelingRate() + score.getTeaRate()) / 3;
				score.setTotalRate(totalRate);
				detailRepository.save(detail);
			}
		}
	}

	private synchronized void calculateRate() {
		List<Detail> BubbleRateList = detailRepository.findDetailOrderByRawBubbleRate();
		List<Detail> TeaRateList = detailRepository.findDetailOrderByRawTeaRateRate();

		int total = BubbleRateList.size();
		int bubbleIndex = total;
		int teaIndex = total;
		for (Detail detail : BubbleRateList) {
			Score score = detail.getScore();
			if (score != null) {
				score.setBubbleRate((bubbleIndex / total * 5) + 5);
				bubbleIndex--;
				detailRepository.save(detail);
			}
		}
		for (Detail detail : TeaRateList) {
			Score score = detail.getScore();
			if (score != null) {
				score.setTeaRate((teaIndex / total * 5) + 5);
				teaIndex--;
				detailRepository.save(detail);
			}
		}
	}

}
