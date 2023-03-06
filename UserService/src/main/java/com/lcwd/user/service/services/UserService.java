package com.lcwd.user.service.services;

import java.util.List;

import com.lcwd.user.service.entities.User;

public interface UserService{
    //User operation

    //create
    User saveUser(User user);

    //get all User
    List<User> getAllUser();

    //get single user of given userID

    User getUser(String userId);

    //Addition : delete, update

}
