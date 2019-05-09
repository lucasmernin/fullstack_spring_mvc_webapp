/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.FoodBlog.Repositories;

import com.sg.FoodBlog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author saed
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    

    User findByUsername(String username);


}
