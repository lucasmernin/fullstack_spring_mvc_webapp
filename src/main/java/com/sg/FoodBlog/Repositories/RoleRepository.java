/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.FoodBlog.Repositories;

import com.sg.FoodBlog.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author saed
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    
    Role findByRole(String role);
 
    
}
