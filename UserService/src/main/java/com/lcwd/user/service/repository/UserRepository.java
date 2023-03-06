package com.lcwd.user.service.repository;
//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

//import com.lcwd.user.service.entities.Rating;
import com.lcwd.user.service.entities.User;

public interface UserRepository extends JpaRepository<User,String>{
    //add any custome method
 

}
