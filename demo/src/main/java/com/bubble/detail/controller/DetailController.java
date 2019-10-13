package com.bubble.detail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bubble.detail.model.Detail;
import com.bubble.detail.service.DetailService;

@RestController
@RequestMapping("/v1/bubble/detail")
public class DetailController {

	@Autowired
	private DetailService detailService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> createDetail(@RequestBody Detail detail) throws Exception {
		detailService.createDetail(detail);
		return new ResponseEntity<>("Bubble detail is created successfully", HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Object> updateDetail(@RequestBody Detail detail) throws Exception {
		detailService.updateDetail(detail);
		return new ResponseEntity<>("Bubble detail is updated successfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> get(@PathVariable("id") Integer id) {

		return new ResponseEntity<>(detailService.getDetail(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> Delete(@PathVariable("id") Integer id) {
		detailService.deleteDetail(id);
		return new ResponseEntity<>("Delete successfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<Object> query(@RequestParam(value = "pageNo", required = false) Integer pageNo,
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestParam(value = "sortBy", required = false) String sortBy,
			@RequestParam(value = "name", required = false) String name) {

		return new ResponseEntity<>(detailService.queryDetail(pageNo, pageSize, sortBy, name), HttpStatus.OK);
	}

}
