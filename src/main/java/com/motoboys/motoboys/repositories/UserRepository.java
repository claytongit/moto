package com.motoboys.motoboys.repositories;

import com.motoboys.motoboys.models.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{
    
}
