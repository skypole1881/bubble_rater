package com.bubble.detail.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bubble.detail.model.Detail;

@Repository
public interface DetailRepository extends JpaRepository<Detail, Integer> {

	@Query(value = "SELECT * FROM bubble_detail WHERE name like %?1% order by?2 limit ?3, ?4", nativeQuery = true)
	List<Detail> queryDetail(String criteritera, String sortBy, Integer limitStart, Integer limitEnd);

	@Query(value = " SELECT * FROM bubble_detail d LEFT JOIN bubble_score sc on d.score_id=sc.score_id order by raw_bubblerate", nativeQuery = true)
	List<Detail> findDetailOrderByRawBubbleRate();
	@Query(value = " SELECT * FROM bubble_detail d LEFT JOIN bubble_score sc on d.score_id=sc.score_id order by raw_bubblerate", nativeQuery = true)
	List<Detail> findDetailOrderByRawTeaRateRate();
}
