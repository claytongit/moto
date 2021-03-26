package com.motoboys.motoboys.services;

import java.util.List;
import java.util.Optional;

import com.motoboys.motoboys.models.Users;
import com.motoboys.motoboys.repositories.UserRepository;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UserRepository repository;


    public List<Users> findAll(){
        return repository.findAll();
    }

    public Users findById(Integer id){
        Optional<Users> obj = repository.findById(id);
        return obj.orElseThrow( () -> new ObjectNotFoundException("Objeto não encontrado", Users.class.getName()));
    }

    public Users create(Users obj){
        obj.setId(null);
        return repository.save(obj);
    }
    
}
