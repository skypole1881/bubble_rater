package com.bubble.detail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bubble.detail.repository.ScoreRepository;

@Service
public class ScoreService {
	@Autowired
	private ScoreRepository scoreRepository;
}
