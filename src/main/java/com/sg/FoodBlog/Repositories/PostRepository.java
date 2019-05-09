/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.FoodBlog.Repositories;

import com.sg.FoodBlog.entities.Category;
import com.sg.FoodBlog.entities.Post;
import com.sg.FoodBlog.entities.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author saed
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    
    List<Post> findByUser(User user);
    
    List<Post> findByCategory(Category category);
    
    List<Post> findByStatus(String status);
    
    List<Post> findByCategoryAndStatus(Category category, String status);
    
    List<Post> findByUserAndStatus(User user, String status);
    

    
}
