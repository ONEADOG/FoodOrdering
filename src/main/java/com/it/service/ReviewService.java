package com.it.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.entity.ReviewEntity;
import com.it.model.ReviewDto;
import com.it.repository.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewrepo;
	
	public List<ReviewDto> getAll(){
		List<ReviewEntity> reviewen = reviewrepo.findAll();
		List<ReviewDto> reviewes = null;
		
		if(reviewen != null) {
			reviewes = new ArrayList<>();
			for(ReviewEntity reviewojb : reviewen) {
				ReviewDto reviewres = new ReviewDto();
				reviewres.setReviewId(reviewojb.getReviewId());
				reviewres.setReviewDetail(reviewojb.getReviewDetail());
				reviewres.setReviewFood(reviewojb.getReviewFood());
				reviewres.setReviewService(reviewojb.getReviewService());
				reviewres.setReviewDate(reviewojb.getReviewDate());
				reviewes.add(reviewres);
			}
		}return reviewes;
	}
	
	public ReviewDto getById(Integer reviewId) {
		Optional<ReviewEntity> reviewen = reviewrepo.findById(reviewId);
		ReviewDto reviewres = null;
		if(reviewen.isPresent()) {
			ReviewEntity reviewes = reviewen.get();
			 reviewres = new ReviewDto();
			 reviewres.setReviewId(reviewes.getReviewId());
			 reviewres.setReviewDetail(reviewes.getReviewDetail());
			 reviewres.setReviewFood(reviewes.getReviewFood());
			 reviewres.setReviewService(reviewes.getReviewService());
			 reviewres.setReviewDate(reviewes.getReviewDate());
			
		}return reviewres;
	}
	
	public void save(ReviewDto request) {
		if(request != null) {
			ReviewEntity reviewen = new ReviewEntity();
			reviewen.setReviewDetail(request.getReviewDetail());
			reviewen.setReviewFood(request.getReviewFood());
			reviewen.setReviewService(request.getReviewService());
			reviewen.setReviewDate(new Date());
			reviewrepo.save(reviewen);
		}
	}
	public void update(Integer reviewId,ReviewDto request) {
		Optional<ReviewEntity> reviewen = reviewrepo.findById(reviewId);
		if(reviewen.isPresent()) {
			ReviewEntity reviews = new ReviewEntity();
			reviews.setReviewDetail(request.getReviewDetail());
			reviews.setReviewFood(request.getReviewFood());
			reviews.setReviewService(request.getReviewService());
			reviews.setReviewDate(request.getReviewDate());
			reviewrepo.save(reviews);
	}
	}
	
	public void deleteById(Integer reviewId) {
		reviewrepo.deleteById(reviewId);
	}
}
