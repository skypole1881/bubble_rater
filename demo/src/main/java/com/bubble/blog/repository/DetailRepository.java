package com.bubble.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bubble.detail.model.Detail;

@Repository
public interface DetailRepository extends JpaRepository<Detail, Long> {

}
