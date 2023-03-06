package com.lcwd.rating.services;

//import org.springframework.stereotype.Service;
import java.util.List;
import com.lcwd.rating.entities.Rating;


public interface RatingService {
    //create
    Rating create(Rating rating);

    //getAll
    List<Rating> getRatings();
    //get all by user id

    List<Rating> getRatingByUserId(String userId);

    //get all by hotel
    List<Rating> getRatingByHotelId(String userId);
}
