package com.lcwd.rating.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.rating.entities.Rating;
import com.lcwd.rating.repository.RatingRepository;
import com.lcwd.rating.services.RatingService;


@Service
public class RatingServieImpl implements RatingService{


    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating create(Rating rating) {
        String randomUserId = UUID.randomUUID().toString();
        rating.setRatingId(randomUserId);
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
    
}

