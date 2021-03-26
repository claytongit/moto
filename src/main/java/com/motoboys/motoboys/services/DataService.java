package com.motoboys.motoboys.services;

import java.util.List;
import java.util.Optional;

import com.motoboys.motoboys.models.Datas;
import com.motoboys.motoboys.models.Users;
import com.motoboys.motoboys.repositories.DataRepository;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {

    @Autowired
    private DataRepository repository;

    @Autowired
    private UsersService userService;

    public List<Datas> findAll(Integer id_user){
        userService.findById(id_user);
        return repository.findAllByUsers(id_user);
    }

    public Datas create(Integer id_user, Datas obj){
        obj.setId(null);
        Users user = userService.findById(id_user);
        obj.setUser(user);
        return repository.save(obj);
    }

    public Datas findById(Integer id){
        Optional<Datas> obj = repository.findById(id);
        return obj.orElseThrow( () -> new ObjectNotFoundException("Objeto não encontrado", Datas.class.getName()) );
    }
    
}
