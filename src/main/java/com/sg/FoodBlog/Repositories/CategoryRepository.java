/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.FoodBlog.Repositories;

import com.sg.FoodBlog.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author saed
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
 
    Category findByName(String name);
    
}
