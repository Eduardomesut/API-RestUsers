/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Api_Rest10_2.repository;

import com.example.Api_Rest10_2.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tarde
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    @Override
    boolean existsById(Long id);
    
    List<User> findByyearBirth(Integer yearBirth);
    
    List<User> findByNameStartingWith(String prefix);
    
    
}
