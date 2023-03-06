package com.lcwd.user.service.impl;


import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lcwd.user.service.entities.Hotel;
import com.lcwd.user.service.entities.Rating;
import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.exceptions.ResourceNotFoundException;
import com.lcwd.user.service.external.services.HotelService;
import com.lcwd.user.service.repository.UserRepository;
import com.lcwd.user.service.services.UserService;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        //generate unique userId
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        //get user from database with the help of userRepository
       User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given Id is not found on server  -"+userId));
        //fetch rating of above user from RATING Service

        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
        logger.info("{}",ratingsOfUser);
        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
        
        

        List<Rating> ratingList = ratings.stream().map(rating -> {
            //api call to hotel service to get hotel
            //localhost:8082/hotels/5d772c03-9836-450c-92cc-030a59210083
            //ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("localhost://Hotel-SERVICE/"+rating.getHotelId(), Hotel.class);
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            //logger.info("Response Status Code: ",forEntity.getStatusCode());
            //set the hotel rating and return the rating
            rating.setHotel(hotel);

            return rating;
            
        }).collect(Collectors.toList());
        
        user.setRatings(ratingList);

        return user;
    }
    
}
